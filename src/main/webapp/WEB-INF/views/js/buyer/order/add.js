$(function() {


	var selectedId = $('.custom-select').val();

	$('.custom-select').change(function() {
		selectedId = $('option:selected').val();
	})

	return selectedId;
})