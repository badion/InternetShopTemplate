$('#confirm-delete').on(
		'show.bs.modal',
		function(e) {
			$(this).find('.btn-delete').attr('href',
					$(e.relatedTarget).data('href'));

			$('.debug-url').html(
					'Delete URL: <strong>'
							+ $(this).find('.btn-delete').attr('href')
							+ '</strong>');
		});

$('#cart-modal').on(
		'click',
		function(e) {
			var url = window.location.pathname + '/shopping-cart';
			$.ajax({
				url : url,
				type : 'GET',
				dataType : "html",
				success : function(response) {
					alert(url);
					url = response.redirect;
				},
				error : function(res) {
					alert("error");
				}
			});
			$('.debug-url').html(
					'Delete URL: <strong>'
							+ $(this).find('.btn-primary').attr('href')
							+ '</strong>');
		});
