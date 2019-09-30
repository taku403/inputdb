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
<title>登録済み</title>
</head>
<body>
	<div class="container-fluid">
		<c:import url="header.jsp"></c:import>
		<div class="row justify-content-center">
			<table class="table table-bodered table-striped">
				<thead>
					<tr>
						<th>名前</th>
						<th>部署</th>
						<th>電話番号</th>
						<th>住所</th>
						<th>備考</th>
						<th>ログインID</th>
						<th>権限</th>
						<th>登録日</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><c:out value="${employee.name}"></c:out></td>
						<td><c:out value="${employee.department.name}"></c:out></td>
						<td><c:out value="${employee.phone}"></c:out></td>
						<td><c:out value="${employee.address}"></c:out></td>
						<td><c:out value="${employee.note}"></c:out></td>
						<td><c:out value="${employee.loginId}"></c:out></td>
						<td><c:forEach var="permission" items="${permissions}">
								<span><c:out value="${permission}" /> </span>
							</c:forEach></td>
						<td><c:out value="${employee.registerd}" /></td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="row">
			<a class="btn btn-primary"
				href='<spring:url value="/login"></spring:url>'>ログイン画面</a>
		</div>
	</div>
</body>
</html>