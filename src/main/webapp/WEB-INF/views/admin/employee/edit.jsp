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
<title></title>
</head>
<body>
	<div class="container-fluid">

		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand"
				href='<spring:url value="/login"></spring:url>'>入力システム</a>
			<button type="button" class="navbar-toggler" data-toggle="collapse"
				data-target="#Navber" aria-controls="Navber" aria-expanded="false"
				aria-label="ナビゲーションの切替">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="Navber">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link"
						href="<spring:url value="/admin/index" />">管理<span
							class="sr-only">(現位置)</span></a></li>
					<li class="nav-item"><a class="nav-link"
						href="<spring:url value="/admin/inventory/index" />">在庫</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<spring:url value="/admin/buyer/index"/>">注文</a></li>
					<li class="nav-item"><a class="nav-link" href="recipt/index">受付</a></li>

					<li class="nav-item dropdown"><a href="#"
						class="nav-link dropdown-toggle" id="navbarDropdown" role="button"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							製造 </a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item"
								href='<spring:url value="/plant/assembly1"></spring:url>'>工程１</a>
							<a class="dropdown-item"
								href='<spring:url value="/plant/assembly2"></spring:url>'>工程２</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item"
								href='<spring:url value="/plant/etc"></spring:url>'>その他</a>
						</div></li>
				</ul>
				<form class="form-inline my-2 my-lg-0">
					<input type="search" class="form-control mr-sm-2"
						placeholder="検索..." aria-label="検索...">
					<button type="submit" class="btn btn-outline-success my-2 my-sm-0">検索</button>
				</form>
			</div>
			<!-- /.navbar-collapse -->
		</nav>

		<div class="row justify-content-center"></div>
		<form:form modelAttribute="employee" action="" method="post">
			<div class="form-group">
				<label for="name">名前</label>
				<form:errors path="name" cssClass="text-danger" element="p" />
				<form:input cssClass="form-control" path="name" />
			</div>
			<div class="for-group">
				<label>部署</label>
				<form:select cssClass="form-control" path="department.id"
					items="${departments}" itemLabel="name" itemValue="id"></form:select>
			</div>
			<div class="form-group">
				<label for="phone">電話番号</label>
				<form:errors cssClass="text-danger" path="phone" element="p" />
				<form:input cssClass="form-control" path="phone" />
			</div>
			<div class="form-group">
				<label for="address">住所</label>
				<form:input cssClass="form-control" path="address" />
			</div>
			<div class="form-group">
				<label for="note">備考</label>
				<form:textarea cssClass="form-control" path="note" />
			</div>
			<div class="form-group">
				<label for="loginId">ログインID</label>
				<form:errors path="loginId" cssClass="text-danger" element="p" />
				<form:input path="loginId" cssClass="form-control" />
			</div>
			<div class="form-group">
				<label for="loginPass">ログインパスワード</label>
				<form:errors path="loginPass" cssClass="text-danger" element="p" />
				<form:password path="loginPass" cssClass="form-control" />
			</div>
			<form:hidden path="update" />
			<form:hidden path="registerd" />
			<div class="form-proup">
				<input class="form-control btn btn-primary" type="submit" value="編集">
			</div>
		</form:form>
	</div>

</body>