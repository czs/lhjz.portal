jQuery(function($) {

	$('.ad-index-btn-menu').click(function() {
		$('.ad-index-menu').sidebar('toggle');
	});

	$('.ui.sticky').sticky({
		offset : 84,
		pushing : true,
		bottomOffset: 84,
		context: '.ad-index-container'
	});

	$('.ad-index-logout').click(function() {
		$(this).siblings('form').submit();
	});

	// semantic-ui ajax api
	$.fn.api.settings.api = {
		'deleteFileById' : 'admin/file/delete?id={id}',
		'updateFileName' : 'admin/file/update?id={id}&name={name}',
		'saveArticle' : 'admin/article/save'
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

jQuery(function($) {
	// custom helper utils
	window.Utils = window.Utils || {};
	
	$.extend(window.Utils, {
		removeFileType: function(name){
			var i = name.lastIndexOf('.');
			return (i != -1) ? name.substring(0, i) : name;
		},
		getFileType: function(name){
			var i = name.lastIndexOf('.');
			return (i != -1) ? name.substring(i) : '';
		}
	});
});


