<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<header>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand"
			href='<spring:url value="/login"></spring:url>'>入力システム<span
			class="sr-only">(現位置)</span></a>
		<button type="button" class="navbar-toggler" data-toggle="collapse"
			data-target="#Navber" aria-controls="Navber" aria-expanded="false"
			aria-label="ナビゲーションの切替">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="Navber">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link"
					href="<spring:url value="/admin/index" />">管理</a></li>
				<li class="nav-item"><a class="nav-link"
					href="<spring:url value="/inventory/index" />">在庫</a></li>
				<li class="nav-item"><a class="nav-link"
					href="<spring:url value="/buyer/index"/>">注文</a></li>
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
			<div class="row">
				<c:if test="${not empty param.loginId }">
					<p class="col-sm-8">
						<c:out value="${param.loginId }" />
						さん
					</p>
					<p class="col-sm-4">
						<a href='<spring:url value="/logout"></spring:url>'>ログアウト</a>
					</p>
				</c:if>
				<p class="col-sm-8">ゲストさん</p>
				<p class="col-sm-4">
					<a href="<spring:url value="/login"/>">ログイン</a>
				</p>
			</div>
		</div>
	</nav>
</header>