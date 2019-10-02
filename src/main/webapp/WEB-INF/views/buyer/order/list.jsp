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
						<th>現在の受け入れた数量</th>
						<th>残りの数量</th>
						<th>発注者</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="order" items="${orders}">
						<tr>
							<td><a class="btn btn-primary"
								href="edit/<c:out value="${order.id}"/>">修正</a></td>
							<td><a id="delete-<c:out value="${order.id }"/>"
								class="delete-btn btn btn-danger"
								href="delete/<c:out value="${order.id}" />">取り消し</a></td>
							<td><c:out value="${order.part.name}" /></td>
							<td><fmt:formatDate value="${order.orderDate}"
									pattern="yyyy-MM-dd HH:mm:ss" /></td>
							<td><c:out value="${order.quantity}"></c:out></td>
							<td><c:out value="${order.reorder}" /></td>
							<td><c:out value="${order.receivingQuantity }" /></td>
							<td><c:out value="${order.remainQuantity }" /></td>
							<td><c:out value="${order.employee.name}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="row justify-content-center">
			<a class="btn btn-primary"
				href='<spring:url value="/buyer/order/add"></spring:url>'>発注</a>
		</div>
	</div>
	<script>
		$(function() {
			$('.delete-btn').click(function() {
				if (!confirm("削除してよろしいですか？")) {
					return false;
				}
			})
		});
	</script>
</body>