jQuery(function() {
	//$('.ad-index-menu').sidebar('toggle');

	$('.ad-index-btn-menu').click(function() {
		$('.ad-index-menu').sidebar('toggle');
	});

	$('.ui.sticky').sticky({
	    offset: 84,
	    pushing: true
	});

	$('.ad-index-logout').click(function(){
		$(this).find('form').submit();
	});

});