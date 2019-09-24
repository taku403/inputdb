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
<title></title>
</head>
<body>
	<div class="container-fluid">
		<div class="row justify-content-center">
			<table class="table table-bodered table-striped">
				<thead>
					<tr>
						<th>編集</th>
						<th>削除</th>
						<th>名前</th>
						<th>部署</th>
						<th>電話番号</th>
						<th>住所</th>
						<th>備考</th>
						<th>ログインID</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${employees}">
						<tr>
							<td><a class="btn btn-primary"
								href="edit/<c:out value="${item.id}"/>">編集</a></td>
							<td><a class="btn btn-danger"
								href="delete/<c:out value="${item.id}"/>"> 削除 </a></td>
							<td><c:out value="${item.name}"></c:out></td>
							<td><c:out value="${item.department.name}"></c:out></td>
							<td><c:out value="${item.phone}"></c:out></td>
							<td><c:out value="${item.address}"></c:out></td>
							<td><c:out value="${item.note}"></c:out></td>
							<td><c:out value="${item.loginId}"></c:out></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="row justify-content-center">
				<a class="btn btn-primary" href="<spring:url value="/admin/employee/add"/>">追加</a>
		</div>
	</div>
</body>
</html>