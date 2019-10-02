<%@page import="java.util.List"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<c:import url="../../meta.jsp"></c:import>
<title>注文画面</title>
<style>
.part {
	display: none;
}
</style>
<script>
	$(document).ready(function() {
		//	alert("aa");

		var id = $('.parts').val()
		console.log("id -> ", id);
		$('.part').hide();
		$('#part-' + id).show();

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
		<c:import url="../../header.jsp">
			<c:param name="loginId" value="${loginId}"></c:param>
		</c:import>

		<c:choose>
			<c:when test="${empty parts }">
				<div class="row justify-content-center">
					<p class="col-sm-12 text-danger">現在取引している部品がありません</p>
					<a href="<spring:url value="/byer/supplier/list"/>"
						class="btn btn-secondary">戻る</a>
				</div>
			</c:when>
			<c:otherwise>
				<form:form modelAttribute="order" action="" method="post">
					<form:hidden path="employee.id" />
					<form:hidden path="orderDate" />
					<form:hidden path="receivingQuantity" />
					<form:hidden path="remainQuantity" />
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
								<c:out value="${order.employee.name}" />
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
						<input class="btn btn-primary form-control" type="submit"
							value="注文する">
					</div>
				</form:form>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>