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
<title>サプライヤー追加画面</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row justify-content-center">
			<form:form modelAttribute="supplier" method="post" action="">
				<div class="form-group">
					<form:errors path="name"></form:errors>
					<label for="name">社名</label>
					<form:input path="name" cssClass="form-control" />
				</div>
				<div class="form-group">
					<form:errors path="tradingPerson"></form:errors>
					<label for="tradingPerson">担当者</label>
					<form:input path="tradingPerson" cssClass="form-control" />
				</div>
				<div class="form-group">
					<form:errors path="address"></form:errors>
					<label for="address">所在地</label>
					<form:input path="address" cssClass="form-control" />
				</div>
				<div class="form-group">
					<form:errors path="note"></form:errors>
					<label for="note">備考</label>
					<form:input path="note" cssClass="form-control" />
				</div>

			</form:form>
		</div>
	</div>
</body>