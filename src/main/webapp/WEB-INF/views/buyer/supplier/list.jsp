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

		<table class="table table-bordered table-striped">
			<thead>
				<tr>
					<th width="100">編集</th>
					<th width="100">削除</th>
					<th>取引先名</th>
					<th>住所</th>
					<th>備考</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${suppliers}">
					<tr>
						<td><a class="btn btn-primary"
							href="edit/<c:out value="${item.id}"/>">編集</a></td>
						<td><a class="delete-btn btn btn-danger"
							href="delete/<c:out value="${item.id}"/>">削除</a></td>
						<td><c:out value="${item.name}" /></td>
						<td><c:out value="${item.address }" /></td>
						<td><c:out value="${item.note}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="row justify-content-center">
			<a class="btn btn-primary" href='<spring:url value="/buyer/supplier/add"></spring:url>'>追加</a>
		</div>
	</div>
	<script type="text/javascript">
	$(function(){
		$('.delete-btn').click(function(){
			if(!confirm("削除してよろしいですか？")){
				return false;
			}
		})
	})</script>
</body>
</html>