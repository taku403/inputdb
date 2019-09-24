<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<table class="table table-bordered">
	<thead>
		<tr>
			<th>製品番号</th>
			<th>品名</th>
			<th>価格</th>
			<th>登録日</th>
			<th>更新日</th>
			<th>社名</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><c:out value="${part.productNo }" /></td>
			<td><c:out value="${part.name}" /></td>
			<td><c:out value="${part.price}"></c:out></td>
			<td><fmt:formatDate value="${part.registerd }"
					pattern="yyyy-MM-dd HH:mm:ss" />
			<td><fmt:formatDate value="${part.update}"
					pattern="yyyy-MM-dd HH:mm:ss" />
			<td><c:out value="${part.supplier.name}"></c:out></td>
	</tbody>
</table>
