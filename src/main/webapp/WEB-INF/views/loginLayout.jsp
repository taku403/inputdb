<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<form:form cssClass="row justifycontent-center border"
	style="padding: 10px; border-radius: 8px; width: 400px;"
	modelAttribute="employee" action="" method="post">
	<div class="form-group col-sm-12">
		<label for="loginId">ログインID </label>
		<c:if test="${not empty loginErr }">
			<span class="text-danger"> <c:out value="${loginErr}" />
			</span>
		</c:if>

		<form:errors cssClass="text-danger" path="loginId" />
		<form:input cssClass="form-control" path="loginId" />
	</div>
	<div class="form-group col-sm-12">
		<label for="loginPass">ログインパスワード</label>
		<form:errors cssClass="text-danger" path="loginPass" />
		<form:input cssClass="form-control" path="loginPass" />
	</div>
	<div class="form-group col-sm-12">
		<input class="form-control btn btn-primary" type="submit" value="ログイン">
	</div>
	<div class="form-group col-sm-12">
		<a class="form-control btn btn-success"
			href="<spring:url value="/register"/>">新規登録</a>
	</div>
</form:form>
