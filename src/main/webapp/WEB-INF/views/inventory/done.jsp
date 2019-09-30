<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="ja">
<c:import url="../meta.jsp"></c:import>
<title><c:out value="${inventory.part.name }" />編集完了</title>
</head>
<body>
	<c:import url="../header.jsp">
		<c:param name="loginId" value="${loginId}"></c:param>
	</c:import>
	<c:import url="inventory.jsp">
		<c:param name="inventory" value="${inventory}"></c:param>
	</c:import>
	<p class="row">
		<a class="btn btn-primary"
			href='<spring:url value="/inventory/index"></spring:url>'>戻る</a>
</body>
</html>