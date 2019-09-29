<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<style>
.partIsLocation {
	display: none;
}
</style>
<form:form modelAttribute="${inventory}" action="" method="post">
	<div class="form-group">
		<label for="select-parts">部品：</label>
		<form:select id="select-parts" cssClass="form-control" path="part.id"
			itemLabel="name" itemValue="id" items="${parts}"></form:select>
	</div>
	<div class="form-group">
		<label for="amount">在庫数</label>
		<form:errors path="amount" element="p" cssClass="text-danger"></form:errors>
		<form:input id="amount" cssClass="form-control" path="amount" />
	</div>
	<div class="form-group">
		<label for="select-location">倉庫移動</label>
		<form:select path="location.id" itemLabel="name" itemValue="id"
			items="${locations}"></form:select>
	</div>
	<div class="form-group">
		<input type="submit" class="form-control" value="${submit}">
	</div>
</form:form>

<c:forEach var="partIsLocation" items="${partsIsLocated }"></c:forEach>
<p class="partsIsLocation"
	id="partIsLocation-<c:out value="${partIslocation.id}"/>">