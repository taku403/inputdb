<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<form:form modelAttribute="employee" action="" method="post">
	<div class="form-group row">
		<label class="col-sm2 col-form-label" for="name">名前</label>
		<form:errors path="name" cssClass="text-danger" element="p" />
		<div class="col-sm-10">
			<form:input cssClass="form-control" path="name" />
		</div>
	</div>
	<div class="for-group row">
		<form:select cssClass="form-control" path="department.id"
			items="${departments}" itemLabel="name" itemValue="id"></form:select>
	</div>
	<div class="form-group row">
		<label class="col-sm-2 col-form-label" for="phone">電話番号</label>
		<form:errors cssClass="text-danger" path="phone" element="p" />
		<div class="col-sm-8">
			<form:input cssClass="form-control" path="phone" />
		</div>
	</div>
	<div class="form-group row">
		<label class="col-sm-2 col-form-label" for="address">住所</label>
		<div class="col-sm-8">
			<form:textarea cssClass="form-control" path="address" />
		</div>
	</div>
	<div class="form-group row">
		<label class="col-sm-2 col-form-label" for="note">備考</label>
		<div class="col-sm-10">
			<form:textarea cssClass="form-control" path="note" />
		</div>
	</div>
	<div class="form-group row">
		<label class="col-sm-2 col-form-label" for="loginId">ログインID</label>
		<form:errors path="loginId" cssClass="text-danger" element="p" />
		<div class="col-sm-8">
			<form:input path="loginId" cssClass="form-control" />
		</div>
	</div>
	<div class="form-group row">
		<label class="col-sm-2 col-form-label" for="loginPass">ログインパスワード</label>
		<form:errors path="loginPass" cssClass="text-danger" element="p" />
		<div class="col-sm-8">
			<form:password path="loginPass" cssClass="form-control" />
		</div>
	</div>>
	<div class="form-group row">
		<input class="form-control btn btn-primary" type="submit" value="<c:out value="${submitValue}"/>">
	</div>
</form:form>
