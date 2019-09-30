<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<h2 class="h1 row"><c:out value="${done}" /></h2>
<table class="table table-bordered table-striped">
	<thead>
		<tr>
			<th>取引先名</th>
			<th>住所</th>
			<th>備考</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><c:out value="${supplier.name}" /></td>
			<td><c:out value="${supplier.address }" /></td>
			<td><c:out value="${supplier.note}"></c:out></td>
		</tr>
	</tbody>
</table>
