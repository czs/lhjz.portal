jQuery(document).ready(function($) {

	$('#btnSiderBar').click(function(event) {
		$('#siderLeftBar').sidebar('toggle');
	});

	$('#siderLeftBar').sidebar({
	// overlay : true
	}).sidebar('show');

	$(window).resize(function() {
		$('body').css('height', '100%');
	});

	$('.ui.dropdown').dropdown();

	$('.ui.modal').modal({
		// closable : false,
		onHidden : function() {
			$('body').css('height', '100%');
		}
	});

	$('#btnAdd').click(function() {
		$('#modalAdd').modal('show');
	});

	$('#btnUpdate').click(function() {
		$('#modalUpdate').modal('show');
	});

	$('#btnDelete').click(function() {
		$('#modalDelete').modal('show');
	});

	$('table').tablesort();
	$('thead th.number').data('sortBy', function(th, td, sorter) {
		if (!!$(td).attr('data-sort-value')) {
			return parseInt($(td).attr('data-sort-value'), 10);
		}
		return parseInt(td.text(), 10);
	});

});