jQuery(function() {

	$('.ad-index-btn-menu').click(function() {
		$('.ad-index-menu').sidebar('toggle');
	});

	$('.ui.sticky').sticky({
		offset : 84,
		pushing : true
	});

	$('.ad-index-logout').click(function() {
		$(this).siblings('form').submit();
	});

	// semantic-ui ajax api
	$.fn.api.settings.api = {
		'deleteFileById' : 'admin/file/delete?id={id}'
	};

	// toastr notification options
	toastr.options = {
		"closeButton" : true,
		"debug" : false,
		"newestOnTop" : true,
		"progressBar" : false,
		"positionClass" : "toast-bottom-center",
		"preventDuplicates" : false,
		"onclick" : null,
		"showDuration" : "300",
		"hideDuration" : "1000",
		"timeOut" : "5000",
		"extendedTimeOut" : "1000",
		"showEasing" : "swing",
		"hideEasing" : "linear",
		"showMethod" : "fadeIn",
		"hideMethod" : "fadeOut"
	};

});
