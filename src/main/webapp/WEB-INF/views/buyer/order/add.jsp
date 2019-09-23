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
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<title>注文画面</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row justify-content-center">
			<div class="col-md-12">
				<form:form modelAttribute="order" action="" method="post">
					<form:hidden path="orderDate" />
					<div class="row">
						<div class="col-md-8">
							<div class="form-group">
								<label>品目</label>
								<form:select cssClass="custom-select" path="part.id"
									items="${parts}" itemLabel="name" itemValue="id"></form:select>
							</div>
						</div>
						<div class="col-md-4" style="margin-top: 30px;">
							<a class="btn btn-primary" href="/input/admin/parts/object/<c:out value="${order.part.id}"/>">詳細</a>
						</div>

					</div>
					<div class="row">
						<div class="col-md-2">
							<div class="form-group">
								<label for="quantity">数量</label>
								<form:errors path="quantity" cssClass="text-danger" element="p"></form:errors>
								<form:input cssClass="form-control" path="quantity" />
							</div>
						</div>
						<div class="col-md-4">
							<span class="col-md-6" style="margin-top: 35px">在庫数</span> <span
								class="col-md-6" style="margin-top: 35px">0</span>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label for="reorderPoint">再発注点</label>
								<form:input cssClass="form-control" path="reorderPoint" />
							</div>
						</div>
						<div class="col-md-4">
							<form:hidden path="employee" />
							<div class="form-group">
								<input class="form-control" type="submit" value="注文する">
							</div>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>