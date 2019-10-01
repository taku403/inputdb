<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8" />
<c:import url="../meta.jsp"></c:import>
<title>受付画面</title>
<style>
.order-tables {
	display: none;
}
</style>

</head>
<body>
	<div class="container-fluid">
		<c:import url="../header.jsp">
			<c:param name="loginId" value="${loginId}"></c:param>
		</c:import>

		<div class="row">
			<p class="col-sm-12">
				受付者：
				<c:out value="${receiving.employee.name}" />
			</p>
		</div>

		<div class="row">
			<form:form modelAttribute="receiving" action="" method="post">
				<form:hidden path="created" />
				<div class="form-group">
					<label for="input-order-no">注文番号</label>
					<form:errors cssClass="text-danger" path="order.id"></form:errors>
					<form:input id="input-order-no" cssClass="form-control"
						path="order.id" placeholder="注文番号"/>
				</div>
				<div class="form-group">
					<label for="quantity">受入数</label>
					<form:errors cssClass="text-danger" path="quantity"></form:errors>
					<form:input id="input-quantity" path="quantity"
						cssClass="form-control" placeholder="受入数量"/>
				</div>
			</form:form>
		</div>
		<c:forEach var="order" items="${orders}">
			<table id="order-table-no-<c:out value="${order.id}"/>"
				class="table table-bordered order-tables" style="margin-right: 0;"
				id="part-<c:out value="${part.id}" />">
				<thead>
					<tr>
						<th>製品番号</th>
						<th>品名</th>
						<th>単価</th>
						<th>注文数量</th>
						<th>登録日</th>
						<th>更新日</th>
						<th>社名</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><c:out value="${order.part.productNo }" /></td>
						<td><c:out value="${order.part.name}" /></td>
						<td><c:out value="${order.part.price}" /></td>
						<td id="quantity-<c:out value="${order.quantity}"/>"><c:out
								value="${order.quantity}" /></td>
						<td><fmt:formatDate value="${order.part.registerd }"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td><fmt:formatDate value="${order.part.update}"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td><c:out value="${order.part.supplier.name}" /></td>
					</tr>
				</tbody>
			</table>
		</c:forEach>
	</div>
	<script>
		$(function() {

			// 画面の初期化
			init();

			//画面を初期化する
			function init() {
				$('.order-tables').hide();
			}

			//バリデーション関数
			//注文番号の入力が正しいかチェックする。
			// 戻り値
			//成功：注文番号： 失敗：false

			//注文番号入力時の処理
			$('#input-order-no').on('change', function() {
				var order_id = $('#input-order-no').val();
				console.log("order_id -> " + order_id)
				//入力が正しいかチェックする
				order_id = check_input_order_id(order_id);
				//入力が正しい場合は該当するテーブルを描写する。
				show_order_table(order_id);
			})

			//注文番号入力のバリデーション処理をする
			//成功：注文数 , 失敗：false
			function check_input_order_id(order_id) {

				console.log('order.no -> ' + order_id);
				if (isNaN(order_id)) {
					alert("注文番号は数字で入力してください");
					return false;
				} else if (order_id == 0) {
					alert("注文番号: 0はありません");
					return false;
				} else {

					return order_id;
				}
			}

			// 引数に指定した注文番号のテーブルを描写する。
			// 戻り値：
			// 成功：true, 存在しない場合：false
			function show_order_table(order_id) {

				var selector = '#order-table-no-' + order_id;
				//テーブルセレクタが存在するなら描写する。
				if ($(selector)[0]) {
					$('.ordar-tables').hide();
					$(selector).show();
					return true;
				} else {
					alert("該当する注文番号: " + order_id + " は存在しません。");
					return false;
				}
			}

			var order_id = check_input_order_id();
			//受入数のバリデーションチェック
			if (order_id) {

			}
			$('#input-quantity').change(function() {
				var quantity = $('#input-quantity').val();

			})
		});
	</script>
</body>