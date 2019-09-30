<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<c:import url="../../meta.jsp"></c:import>
</head>
<body>
	<div class="container-fluid">
		<c:import url="../../header.jsp">
			<c:param name="loginId" value="${loginId }"></c:param>
		</c:import>
		<div class="row">
			<c:import url="supllier.jsp">
				<c:param name="supplier" value="${supplier}"></c:param>
				<c:param name="done" value="${done }" ></c:param>
			</c:import>
		</div>
		<div class="row"><a class="btn btn-primary" href='<spring:url value="/buyer/supplier/list"></spring:url>'>戻る</a></div>
	</div>
</body>