<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8" />
<c:import url="../meta.jsp"></c:import>

<title>受付画面</title>
<style>
.order-tables {
	display: none;
}
</style>

</head>
<body>
	<script src="<spring:url value="/js/receiving/form.js"/>"
		type="text/javascript"></script>

	<div class="container-fluid">
		<c:import url="../header.jsp">
			<c:param name="loginId" value="${loginId}"></c:param>
		</c:import>

		<div class="row">
			<p class="col-sm-12">
				受付者：
				<c:out value="${receiving.employee.name}" />
			</p>
		</div>

		<div class="row">
			<form:form cssClass="form-inline" modelAttribute="receiving"
				action="" method="post">
				<form:hidden path="created" />
				<form:hidden path="completeFlag"/>
				<form:hidden path="employee.id"/>
				<div class="form-group mx-sm-2 mb-2">
					<label class="sr-only" for="input-order-no">注文番号</label>
					<form:errors cssClass="text-danger" path="order.id"></form:errors>
					<form:input id="input-order-no" cssClass="form-control"
						path="order.id" placeholder="注文番号" />
				</div>
				<div class="form-group mx-sm-2 mb-2">
					<label class="sr-only" for="input-quantity">受入数</label>
					<form:errors cssClass="text-danger" path="quantity"></form:errors>
					<form:input id="input-quantity" path="quantity"
						cssClass="form-control" placeholder="受入数量" />
				</div>
				<div class="form-group mx-sm-2 mb-2">
					<input id="btn-submit" class="btn btn-success form-control"
						type="submit" value="完了">
				</div>

			</form:form>
		</div>
		<c:forEach var="order" items="${orders}">
			<table id="order-table-no-<c:out value="${order.id}"/>"
				class="table table-bordered order-tables" style="margin-right: 0;"
				id="part-<c:out value="${part.id}" />">
				<thead>
					<tr>
						<th>製品番号</th>
						<th>品名</th>
						<th>単価</th>
						<th>注文数量</th>
						<th>登録日</th>
						<th>更新日</th>
						<th>社名</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><c:out value="${order.part.productNo }" /></td>
						<td><c:out value="${order.part.name}" /></td>
						<td><c:out value="${order.part.price}" /></td>
						<td id="order-quantity-<c:out value="${order.id}"/>"> hidden="hidden"><c:out value="${order.quantity }"/></td>
						<td id="quantity-<c:out value="${order.id}"/>"><c:out
								value="${order.receivingQuantity}" /></td>
						<td><fmt:formatDate value="${order.part.registerd }"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td><fmt:formatDate value="${order.part.update}"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td><c:out value="${order.part.name}" /></td>
					</tr>
				</tbody>
			</table>
		</c:forEach>
	</div>
</body>