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
<title>発注一覧</title>
</head>
<body>
	<div class="container-fluid">
	<c:import url="../../header.jsp"></c:import>
		<div class="row justify-content-center">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>修正</th>
						<th>取り消し</th>
						<th>品名</th>
						<th>発注日</th>
						<th>発注数</th>
						<th>再発注数量</th>
						<th>発注者</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${orders}">
						<tr>
							<td><a class="btn btn-primary"
								href="/admin/parts/edit/<c:out value="${item.id}"/>">修正</a></td>
							<td><a class="btn btn-primary"
								href="/admin/parts/delete/<c:out value="${item.id}" />">取り消し</a></td>
							<td><c:out value="${item.part.name}" /></td>
							<td><fmt:formatDate value="${item.orderDate}"
									pattern="yyyy-MM-dd HH:mm:ss" /></td>
							<td><c:out value="${item.quantity}"></c:out></td>
							<td><c:out value="${itme.reorder}" /></td>
							<td><c:out value="${item.employee.name }" /> </td>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="row justify-content-center">
			<a class="btn btn-primary"
				href='<spring:url value="/buyer/order/add"></spring:url>'>発注</a>
		</div>
	</div>
</body>