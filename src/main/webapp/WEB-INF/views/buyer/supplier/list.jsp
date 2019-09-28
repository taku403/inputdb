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

	<script src="/js/common.js" type="text/javascript"></script>
<title>新規登録</title>
</head>
<body>
	<div class="contaniner-fluid">
		<c:import url="../../header.jsp">
			<c:param name="loginId" value="${loginId }"></c:param>
		</c:import>

		<table class="table table-bordered table-striped">
			<thead>
				<tr>
					<th width="100">編集</th>
					<th width="100">削除</th>
					<th>取引先名</th>
					<th>住所</th>
					<th>備考</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${suppliers}">
					<tr>
						<td><a class="btn btn-primary"
							href="edit/<c:out value="${item.id}"/>">編集</a></td>
						<td><a class="btn btn-danger"
							href="delete/<c:out value="${item.id}"/>">削除</a></td>
						<td><c:out value="${item.name}" /></td>
						<td><c:out value="${item.address }" /></td>
						<td><c:out value="${item.note}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="row justify-content-center">
			<a class="btn btn-primary" href="admin/supplier/add">追加</a>
		</div>
	</div>
</body>
</html>