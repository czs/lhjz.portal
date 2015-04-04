jQuery(function($) {

			// carousel component init
			$('.carousel').carousel();
			
			// navigation click actions
			$('.scroll-link').on('click', function(event) {
						event.preventDefault();
						var sectionID = $(this).attr("data-id");
						scrollToID('#' + sectionID, 750);
						$('.navbar-nav li').each(function() {
									$(this).removeClass("active");
								});
						$(this).parent().addClass("active");
					});

			// scroll to top action
			$('.scroll-top').on('click', function(event) {
						event.preventDefault();
						$('html, body').animate({
									scrollTop : 0
								}, 'slow');
					});

			// scroll function
			function scrollToID(id, speed) {
				// var offSet = 50;
				var offSet = 0;
				var targetOffset = $(id).offset().top - offSet;
				$('html,body').animate({
							scrollTop : targetOffset
						}, speed);
			}
			
			$.scrollUp({
			    scrollName: 'scrollUp',
			    topDistance: '300',
			    topSpeed: 300,
			    animation: 'fade',
			    animationInSpeed: 100,
			    animationOutSpeed: 200,
			    scrollText: '',
			    activeOverlay: false
			});

		});
