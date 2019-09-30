<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8" />
<c:import url="meta.jsp"></c:import>

<title>ログアウト</title>
</head>
<body>
<div class="container-fluid">
<c:import url="header.jsp">
<c:param name="loginId" value=""></c:param>
</c:import>
<div class="row justify-content-centar">
<h2 class="col-sm-12">ログアウトしました</h2>
<p class="col-sm-12"><a class="btn btn-primary" href='<spring:url value="/login">ログイン画面に戻る</spring:url>'></a>
</div>
</div>
</body>
</html>