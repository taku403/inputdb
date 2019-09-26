<%@page import="java.util.List"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<title>注文画面</title>
<style>
.part {
	display: none;
}
</style>
<script>
	$(document).ready(function() {
		//	alert("aa");

		$('')

		$('.parts').on('change', function() {
			//			alert("cc");
			var id = $(this).val();
			console.log(id);
			$('.part').hide();
			$('#part-' + id).show();
		});
	});
</script>
</head>
<body>
	<div class="container-fluid">
		<div class="row justify-content-center">
			<div class="col-md-10">
				<form:form modelAttribute="order" action="" method="post">
P						<form:hidden path="employee" />
					<form:hidden path="orderDate" />
					<form:hidden path="part" />
					<div class="form-group row">
						<label class="col-sm-1 col-form-label col-form-label-md">品目</label>
						<form:select
							cssClass="custom-select parts form-control-md col-md-11"
							path="part.id" items="${parts}" itemLabel="name" itemValue="id"></form:select>
					</div>
					<div class="row">
						<div class="form-group col-md-4">
							<div class="row">
								<label for="quantity"
									class="col-sm-4 col-form-label col-form-label-md">数量</label>
								<form:errors path="quantity" cssClass="text-danger" element="p"></form:errors>
								<form:input cssClass="col-sm-8 form-control form-control-md"
									path="quantity" />
							</div>
						</div>
						<div class="form-group col-md-4">
							<div class="row">
								<label class="col-sm-4 col-form-label col-form-label-md"
									for="reorder">再発注点</label>
								<form:errors path="reorder" cssClass="text-danger" element="p"></form:errors>
								<form:input cssClass="col-sm-8 form-control form-control-md"
									path="reorder" />
							</div>
						</div>
						<div class="form-group col-md-4">
							<label class="col-sm-4 form-col-sm">発注者</label>
							<p>
								<c:out value="${name}" />
							</p>
						</div>
					</div>
					<c:forEach items="${parts}" var="part">
						<table class="table table-bordered part row"
							style="margin-right: 0;" id="part-<c:out value="${part.id}" />">
							<thead>
								<tr>
									<th>製品番号</th>
									<th>品名</th>
									<th>価格</th>
									<th>登録日</th>
									<th>更新日</th>
									<th>社名</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><c:out value="${part.productNo }" /></td>
									<td><c:out value="${part.name}" /></td>
									<td><c:out value="${part.price}"></c:out></td>
									<td><fmt:formatDate value="${part.registerd }"
											pattern="yyyy-MM-dd HH:mm:ss" /></td>
									<td><fmt:formatDate value="${part.update}"
											pattern="yyyy-MM-dd HH:mm:ss" /></td>
									<td><c:out value="${part.supplier.name}"></c:out></td>
								</tr>
							</tbody>
						</table>
					</c:forEach>
					<div class="form-group row">
						<input class="form-control" type="submit" value="注文する">
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>