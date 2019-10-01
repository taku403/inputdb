<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8" />
<c:import url="../../meta.jsp"></c:import>
<title>追加</title>
</head>
<body>
	<div class="container-fluid">
		<form:form modelAttribute="location" action="" method="post">
			<div class="form-group">
			<label for="name">倉庫名</label>
				<form:errors cssClass="text-danger" path="name"></form:errors>
			</div>
			<form:input placeholder="倉庫名を入力してください" cssClass="form-control" path="name"/>
			<div class="form-group">
			<input class="form-control btn btn-primary" type="submit" value="追加">
			</div>
		</form:form>
	</div>
</body>