$(document).ready(function() {

//	Selecet要素のクラス
	$('.parts').on('change',function(){
		var id = $(this).val();
		$('.part').hide();
		$('#part-' + id).show();
	})

})