$(function(){
    var amount = $('#amount').text();
    console.log("amount -> ", amount);
    var price = $('#price').text();
    console.log("price -> ", price);
    var total_price = amount * price;
    $('#total-price').text(total_price);
})