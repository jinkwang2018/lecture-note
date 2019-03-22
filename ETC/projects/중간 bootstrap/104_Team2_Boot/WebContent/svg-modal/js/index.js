(function() {
	
	var svgModal = {
		showOverlay: $('.btn--show-overlay'),						
		closeOverlay: $('#modal__close'),
		modal: $('#modal'),											
		svgWrapper: $("#svg-wrapper"),								 
		pathElement: undefined,
		modalOpen: false,
		btnHovered: false,											
		paths: {
			default: $('#svg-path').attr('d'),						
			active: $("#svg-wrapper").data('btn-hovered'),			
			modalOpen: $('#svg-wrapper').data('modal-open')
		},
		init: function() {
			
			var s = Snap("#svg");
      
			svgModal.pathElement = s.select('path');
			this.events();													
		},
		events: function() {
			svgModal.showOverlay.on('mouseenter', this.btnHover);
			svgModal.showOverlay.on('mouseleave', this.btnHover);
			svgModal.showOverlay.on('click', this.toggleModal);
			svgModal.closeOverlay.on('click', this.toggleModal);
		},
		btnHover: function(e) {
			e.preventDefault();
			
			var $this = $(this);
			
			if (!svgModal.modalOpen) {

				svgModal.pathElement.stop().animate({
					
					'path': svgModal.btnHovered ? svgModal.paths.default : svgModal.paths.active
					
				}, 250, mina.easeout);
				
				svgModal.btnHovered = !svgModal.btnHovered;
				
			}
		},
		toggleModal: function(e) {
			e.preventDefault();
			
			var $this = $(this);

			setTimeout(function() {
				$('body').toggleClass('modal--active');
			}, 100);
			
			svgModal.pathElement.stop().animate({
				
				'path': svgModal.paths.modalOpen
				
			}, 300, mina.easeout, function() {

				svgModal.pathElement.stop().animate({
					'path': svgModal.modalOpen ? svgModal.paths.active : svgModal.paths.default
				}, svgModal.modalOpen ? 800 : 300, svgModal.modalOpen ? mina.elastic : mina.easeout);

			});

      svgModal.btnHovered = false;

			svgModal.modalOpen = !svgModal.modalOpen;
			
		}
 	};

	svgModal.init();
	
	
})();