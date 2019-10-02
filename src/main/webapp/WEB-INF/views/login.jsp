<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8" />
<c:import url="meta.jsp"></c:import>
<title>ログイン画面</title>
</head>
<body>
	<div class="container-fluid">
		<c:import url="header.jsp">
			<c:param name="loginId" value="${loginId}" />
		</c:import>
		<h2 class="h5 text-danger row justify-content-center"
			style="margin-top: 15px;">
			<c:out value="${notLogin}" />
		</h2>
		<div class="row justify-content-center">
			<form:form cssClass="row justifycontent-center border"
				style="padding: 10px; border-radius: 8px; width: 400px;" modelAttribute="employee"
				action="" method="post">
				<div class="form-group col-sm-12">
					<label for="loginId">ログインID </label>
					<c:if test="${not empty loginErr }">
						<span class="text-danger">
							<c:out value="${loginErr}" />
						</span>
					</c:if>
					<form:errors cssClass="text-danger" path="loginId" />
					<form:input  cssClass="form-control" path="loginId" />
				</div>
				<div class="form-group col-sm-12">
					<label for="loginPass">ログインパスワード</label>
					<form:errors cssClass="text-danger" path="loginPass" />
					<form:input cssClass="form-control" path="loginPass" />
				</div>
				<div class="form-group col-sm-12">
					<input class="form-control btn btn-primary" type="submit"
						value="ログイン">
				</div>
				<div class="form-group col-sm-12">
					<a class="form-control btn btn-success"
						href="<spring:url value="/register"/>">新規登録</a>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>