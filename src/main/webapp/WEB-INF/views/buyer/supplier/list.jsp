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
<title>新規登録</title>
</head>
<body>
	<div class="contaniner-fluid">
		<c:import url="../../header.jsp">
			<c:param name="loginId" value="${loginId }"></c:param>
		</c:import>
		 <div class="row" style="margin-left: 80px;">
			<h1 class="h1 col-12">取引先一覧</h1>
		</div>
		<div class="row justify-content-center">
			<table class="col-sm-10 table table-bordered table-striped"
				style="margin-top: 20px;">
				<thead>
					<tr>
						<th width="100">編集</th>
						<th width="100">削除</th>
						<th width="100">発注</th>
						<th>取引先名</th>
						<th>住所</th>
						<th>備考</th>
						<th>登録日</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="supplier" items="${suppliers}">
						<tr>
							<td><a class="btn btn-secondary"
								href="edit/<c:out value="${supplier.id}"/>">編集</a></td>
							<td><a id="delete-btn" class="delete-btn btn btn-danger"
								href="delete/<c:out value="${supplier.id}"/>">削除</a></td>
							<td><a class="btn btn-success"
								href="/input/buyer/order/add/<c:out value="${supplier.id}"/>">発注</a></td>
							<td><c:out value="${supplier.name}" /></td>
							<td><c:out value="${supplier.address }" /></td>
							<td><c:out value="${supplier.note}"></c:out></td>
							<td><c:out value="${supplier.created}"></c:out></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="row justify-content-center">
			<a class="col-sm-10 btn btn-primary"
				href='<spring:url value="/buyer/supplier/add"></spring:url>'>取引先の追加</a>
		</div>

	</div>
	<script type="text/javascript">
		$(function() {
			$('.delete-btn').click(function() {
				if (!confirm("本当に削除してよろしいですか？")) {
					return false;
				}
			})
		})
	</script>
</body>
</html>