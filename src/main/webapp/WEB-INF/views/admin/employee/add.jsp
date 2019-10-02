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
<title>従業員の新規登録</title>
</head>
<body>
	<div class="container-fluid">
		<c:import url="../../header.jsp">
			<c:param name="loginId" value="${loginId }"></c:param>
		</c:import>

		<div class="row justify-content-center"></div>
		<form:form modelAttribute="employee" action="" method="post">
			<div class="form-group">
				<label for="name">名前</label>
				<form:errors path="name" cssClass="text-danger" element="p" />
				<form:input cssClass="form-control" path="name" />
			</div>
			<div class="for-group">
				<form:select cssClass="form-control" path="department.id"
					items="${departments}" itemLabel="name" itemValue="id"></form:select>
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
			<div class="form-proup">
				<input class="form-control btn btn-primary" type="submit" value="追加">
			</div>
		</form:form>
	</div>
</body>
</html>