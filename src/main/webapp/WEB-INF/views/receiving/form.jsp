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
			<form:form cssClass="form-inline" modelAttribute="receiving" action="" method="post">
				<form:hidden path="created" />
				<div class="form-group mx-sm-3 mb-2">
					<label class="sr-only" for="input-order-no">注文番号</label>
					<form:errors cssClass="text-danger" path="order.id"></form:errors>
					<form:input id="input-order-no" cssClass="form-control"
						path="order.id" placeholder="注文番号"/>
				</div>
				<div class="form-group mx-sm-3 mb-2">
					<label class="sr-only" for="input-quantity">受入数</label>
					<form:errors cssClass="text-danger" path="quantity"></form:errors>
					<form:input id="input-quantity" path="quantity"
						cssClass="form-control" placeholder="受入数量"/>
				</div>
				<div class="form-group mx-sm-3 mb-2">
				<input id="btn-submit" class="btn btn-success form-control" type="submit" value="完了" >
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
						<td id="quantity-<c:out value="${order.id}"/>"><c:out
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
	// 入力項目のバリデーション処理の記述
		$(function() {
			//以前のテーブル画面を消去するためのIDを保存
			var prev_ordor_id;
			var input_order_err_flag = true;
			var input_quatity_err_flag = true;
			// 画面の初期化をする
			init();
			//注文番号入力時の処理
			$('#input-order-no').on('change', function() {
				var order_id = $('#input-order-no').val();
				//入力が正しいかチェックする
				order_id = check_input_order_id(order_id);
				//入力が正しい場合は該当するテーブルを描写しテーブルセレクタIDを返す。
				var order_table_id = show_order_table(order_id);
				//入力項目のエラーフラグのチェックをし、全ての入力が正しければ、送信ぼたんのdisable属性を解除する
				if(!is_err()){
					
					$('#btn-submit').prop('disabled',false);
					$('#btn-submit').val('完了');
				}
				else {
					return false;
				}
			})

			//注文数量の入力バリデーション処理
		$('#input-quantity').on('change', function() {
				var order_id = $('#input-order-no').val();
				//注文数量の取得
				var order_quantity = get_order_quantity(order_id)
				//受け入れ数の取得
				var receiving_quantity = get_check_receiving_quantity();
				if (receiving_quantity) {
					//注文数と受け入れ数量のチェック
					var cmp = order_quantity - receiving_quantity;
					if (0 > cmp) {
						alert('注文数より受け入れ数量が多いです');
						$('#input-quantity').val('');
						err_flag = true;
						return false;
					}
				}
				else if(receiving_quantity == 0){
					alert('数量０は入力できません');
					err_flag = true;
					return false;
				}
				//入力項目のエラーフラグのチェックをし、全ての入力が正しければ、送信ぼたんのdisable属性を解除する
				if(!is_err()){
					
					$('#btn-submit').prop('disabled',false);
					$('#btn-submit').val('完了');
				}
				else {
					return false;
				}
			})

			
			// 関数
			//画面描写を初期化する
			function init() {
				var input_order_no = $('#input-order-no').val();
				var input_quantity = $('#input-quantity').val();
				$('.order-tables').hide();
				$('#input-quantity').prop('disabled', true);
				if(input_order_no == '' || input_quantity == ''){
					$('#btn-submit').val("未入力項目があるので完了できません").prop('disabled',true);
					return true;
				}
				if(is_err()){
					$('#btn-submit').val("入力項目に誤りがあるので完了できません").prop('disabled',true);
					return true;
				}

			}

			//注文番号入力のバリデーション処理をする
			//成功：order_id , 失敗：false
			function check_input_order_id(order_id) {

				console.log('order.no -> ' + order_id);
				if (isNaN(order_id)) {
					alert("注文番号は数字で入力してください");
					err_flag = true;
					$('#input-ordor-no').val('')
					$('#order-table-no-' + prev_ordor_id).hide();
					return false;
				} else if (order_id == 0) {
					alert("注文番号: ０はありません");
					err_flag = true;
					$('#input-ordor-no').val('')
					$('#order-table-no-' + prev_ordor_id).hide();
					return false;
				} else {
					err_flag = false;
					prev_ordor_id = order_id;
					return order_id;
				}
			}
			// オーダーテーブルが存在するかチェックする
			function is_order_table(order_id) {
				var selector_id = '#order-table-no-' + order_id;
				if ($(selector_id)[0]) {
					err_flag = false;
					return true;
				} else {
					err_flag = true;
					return false;
				}
			}
			// 引数に指定した注文番号のテーブルを描写する。
			// 戻り値：
			// 成功：セレクタID, 存在しない場合：false
			function show_order_table(order_id) {

				var selector_id = '#order-table-no-' + order_id;
				//テーブルセレクタが存在するなら描写する。
				if ($(selector_id)[0]) {
					$('.ordar-tables').hide();
					$(selector_id).show();
					$('#input-quantity').prop('disabled', false);
					$('#input-quantity').focus();
					input_order_err_flag= false;
					return selector_id;
				} else {
					alert("該当する注文番号: " + order_id + " は存在しません。");
					$('#input-order-no').val('');
					$('#input-order-no').focus();
					input_order_err_flag = true;
					return false;
				}
			}

			//注文番号の数量を取得する
			// param: 注文ID
			// return true: order_quantity;
			function get_order_quantity(order_id) {
				// 注文数量のセレクタを生成
				var order_quantity_id = $('#quantity-' + order_id).text();
				return order_quantity_id;
			}
			// 受け入れ数量のバリデーション処理をし受け入れ数量を返す
			// return success: receiving_quantity; fail: false;
			function get_check_receiving_quantity() {
				var input_receiving_ouantity = $('#input-quantity').val();

				if (isNaN(input_receiving_ouantity)) {
					alert('数字を入力してください');
					input_quatity_err_flag = true;
					return false;
				} else if (input_receiving_ouantity == 0) {
					alert('1以上を入力してください');
					input_quatity_err_flag = true;
					return false;
				} else {
					input_quatity_err_flag = false;
					return input_receiving_ouantity;
				}
			}

			//エラーフラグの確認をする
			// フラグ立つ：true; esle false;
			function is_err(){

				if(!input_order_err_flag && !input_quatity_err_flag) {
					return false;
				}
				else {
					return true;
				}
			}
		});
	</script>
</body>