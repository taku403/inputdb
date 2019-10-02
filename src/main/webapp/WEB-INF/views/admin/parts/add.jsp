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
<title>パーツ新規登録</title>
</head>
<body>
	<div class="container-fluid">
		<c:import url="../../header.jsp">
			<c:param name="loginId" value="${loginId }"></c:param>
		</c:import>

		<div class="row justify-content-center">
			<form:form modelAttribute="part" action="" method="post">
				<div class="form-group">
					<form:errors path="name" element="p" cssClass="text-danger"></form:errors>
					<label for="name">製品名</label>
					<form:input path="name" cssClass="form-control" />
				</div>
				<div class="form-group">
					<form:errors path="productNo" element="p" cssClass="text-danger"></form:errors>
					<label for="name">製造番号</label>
					<form:input path="productNo" cssClass="form-control" />
				</div>
				<div class="form-group">
					<form:errors path="price" element="p" cssClass="text-danger"></form:errors>
					<label for="price">価格</label>
					<form:input path="price" cssClass="form-control" />
				</div>
				<div class="form-group">
					<form:errors path="lot" element="p" cssClass="text-danger"></form:errors>
					<label for="lot">ロット数</label>
					<form:input path="lot" cssClass="form-control" />
				</div>
				<div class="form-group">
					<form:select path="supplier.id" cssClass="form-control"
						items="${suppliers}" itemValue="id" itemLabel="name" />
				</div>
				<div class="form-group">
					<input type="submit" value="登録" class="form-control">
				</div>
				<form:hidden path="registerd" />
				<form:hidden path="update" />
			</form:form>
		</div>
	</div>
</body>
</html>