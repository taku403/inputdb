<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<c:import url="../../meta.jsp"></c:import>
<title><c:out value="${location.id}" />番倉庫追加</title>
</head>
<body>
<div class="container-fluid">
<c:import url="../header.jsp">
<c:param name="loginId"  value="${loginId}"></c:param>
</c:import>

</div>
</body>
</html>