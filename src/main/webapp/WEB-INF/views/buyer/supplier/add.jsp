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
<title><c:out value="${supplier.name}"/></title>
</head>
<body>
	<div class="container-fluid">
		<c:import url="../../header.jsp">
			<c:param name="loginId" value="${loginId }"></c:param>
		</c:import>

		<div class="row justify-content-center">
			<form:form modelAttribute="supplier" action="" method="post">
				<div class="form-group">
					<label for="name">取引先名</label>
					<form:errors cssClass="text-danger" path="name" element="p"></form:errors>
					<form:input cssClass="form-control" path="name" />
				</div>
				<div class="form-group">
					<label for="name">所在地</label>
					<form:errors cssClass="text-danger" path="address" element="p"></form:errors>
					<form:input cssClass="form-control" path="address" />
				</div>
				<div class="form-group">
					<label for="note">備考</label>
					<form:errors cssClass="text-danger" path="note" element="p"></form:errors>
					<form:input cssClass="form-control" path="note" />
				</div>
				<div class="form-group">
					<input type="submit" class="form-control btn btn-primary"
						value="適用">
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>