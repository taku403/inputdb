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
<title>場所一覧</title>
</head>
<body>
	<div class="container-fluid">
		<c:import url="../header.jsp">
			<c:param name="loginId" value="${loginId }"></c:param>
		</c:import>
		<div class="row ">
			<h1 class="h1 col-sm-4">倉庫情報</h1>
			<h2 class="h2 text-muted col-sm-7">倉庫を選択してください</h2>
			<h2 class="h2 col-sm-1"><a class=" h2 btn btn-secondary text-light" href="<spring:url value="/inventory/location/edit" />">修正をする</a></h2>
		</div>
		<div class="row justify-content-center ">
			<c:if test="${empty locations}">
				<p class="col-sm text-danger">倉庫情報が登録されてません</p>
			</c:if>
			<ul class="nav justify-content-center">
				<c:forEach var="location" items="${locations}">
					<li class="nav-item col-sm-3 border">
					<a
						class="nav-link btn btn-info"
						href="list/<c:out value="${location.id}"/>"> <c:out
								value="${location.name }" />倉庫 <br>備考：<small class=" text-light"><c:out value="${location.note }"/></small>
					</a></li>
				</c:forEach>
				<li class="nav-item col-sm-12"><a
					class="nav-link btn btn-primary text-light" href="<spring:url value="/inventory/location/add" />">新たに倉庫を追加する</a></li>
			</ul>
		</div>
	</div>
</body>
</html>