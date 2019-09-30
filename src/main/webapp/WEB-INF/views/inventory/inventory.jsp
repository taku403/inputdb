<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<table class="table table-border table-striped">
	<thead>
		<tr>
			<th>品名</th>
			<th>在庫数</th>
			<th>倉庫</th>
			<th>修正日</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td id="part-name"><c:out value="${inventory.part.name }" /></td>
			<td id="inventory-amount"><c:out value="${inventory.amount}" /></td>
			<td id="inventory-location-name"><c:out value="${inventory.location.name}" /></td>
			<td><c:out value="${inventory.updated }" /></td>
		</tr>
	</tbody>
</table>