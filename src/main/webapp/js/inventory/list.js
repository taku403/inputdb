$(function() {
	var amount= $('#amount').text();
	var price = $('#price').text();
	var total_price = amount * price;
	var lot = $('#lot').text();
	var lot_quantity = Math.floor(invent_amount / lot);
	$('#lot-quantity').text(lot_quantity);
	var total_price = price * invent_amount;
	$('#total-price').text(total_price);

});
