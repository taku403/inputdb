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
<title>新規登録</title>
</head>
<body>
	<div class="container-fluid">
		<c:import url="header.jsp"></c:import>
		<form:form modelAttribute="employee" action="" method="post">
			<div class="form-group">
				<label for="name">名前</label>
				<form:errors path="name" cssClass="text-danger" element="p" />
				<form:input cssClass="form-control" path="name" />
			</div>
			<div class="row">
				<div class="col-sm-4">
					<div class="for-group row">
						<label class="col-sm-4 col-form-label" for="department.id">部署</label>
						<div class="col-sm-8">
							<form:select cssClass="form-control" path="department.id"
								items="${departments}" itemLabel="name" itemValue="id"></form:select>
						</div>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="row border" style="borderadius: 4px;">
						<c:forEach var="permission" items="${permissions}">
							<div class="form-group col-sm-3">
								<label class="col-sm-2 col-form-label"><c:out
										value="${permission.name}" />
										<input type="checkbox" name="permissions" value="<c:out value="${permission.id}"/>">
								</label>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label for="phone">電話番号</label>
				<form:errors cssClass="text-danger" path="phone" element="p" />
				<form:input cssClass="form-control" path="phone" />
			</div>
			<div class="form-group">
				<label for="address">住所</label>
				<form:textarea cssClass="form-control" path="address" />
			</div>
			<div class="form-group">
				<label for="note">備考</label>
				<form:textarea cssClass="form-control" path="note" />
			</div>
			<div class="form-group">
				<label for="loginId">ログインID</label>
				<form:errors path="loginId" cssClass="text-danger" element="p" />
				<form:input path="loginId" cssClass="form-control" />
			</div>
			<div class="form-group">
				<label for="loginPass">ログインパスワード</label>
				<form:errors path="loginPass" cssClass="text-danger" element="p" />
				<form:password path="loginPass" cssClass="form-control" />
			</div>
			<div class="form-group">
				<input class="form-control btn btn-primary" type="submit" value="登録">
			</div>
		</form:form>

	</div>
</body>
</html>