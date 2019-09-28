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
	<script src="/js/common.js" type="text/javascript"></script>
<title>修正</title>
</head>
<body>
	<div class="container-fluid">
		<c:import url="../../header.jsp">
			<c:param name="loginId" value="${loginId }"></c:param>
		</c:import>

		<div class="row justify-content-center">
			<form:form modelAttribute="supplier" action="" method="post">
				<div class="form-group">
					<label for="name">取引先名</label>
					<form:errors cssClass="text-danger" path="name" element="p"></form:errors>
					<form:input cssClass="form-control" path="name" />
				</div>
				<div class="form-group">
					<label for="name">所在地</label>
					<form:errors cssClass="text-danger" path="address" element="p"></form:errors>
					<form:input cssClass="form-control" path="address" />
				</div>
				<div class="form-group">
					<label for="note">備考</label>
					<form:errors cssClass="text-danger" path="note" element="p"></form:errors>
					<form:input cssClass="form-control" path="note" />
				</div>
				<div class="form-group">
					<input type="submit" class="form-control btn btn-primary"
						value="適用">
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>