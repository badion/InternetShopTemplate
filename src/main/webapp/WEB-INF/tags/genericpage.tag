<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true"%>
<%@attribute name="footer" fragment="true"%>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/static/css/style.css"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="<%=request.getContextPath()%>/static/js/jquery.validate.min.js"></script>
<script
	src="<%=request.getContextPath()%>/static/js/custom_js/category_validation.js"></script>
<script
	src="<%=request.getContextPath()%>/static/js/custom_js/good_validation.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.96.1/css/materialize.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.96.1/js/materialize.min.js"></script>
</head>
<body>
	<div id="pageheader">
		<jsp:invoke fragment="header" />
	</div>
	<div id="body">
		<script>
			$(document).ready(function() {

				$('.modal-trigger').leanModal();
				$(".button-collapse").sideNav();
				$('.pagination li a').each(function(index) {
					if (this.href.trim() == window.location)
						$(this).parent().addClass("active");
				});
			});

			function decriment_page() {
				var arr = window.location.toString().split('/');
				var last_element = arr[arr.length - 1];
				var decrement = parseInt(last_element) - 1;
				if (decrement <= 0) {
					Materialize.toast('It is first page', 4000);
				} else {
					window.location.href = 'http://localhost:8080/InternetShop/categories/page/'
							+ decrement;
				}
			}
			function increment_page() {
				var arr = window.location.toString().split('/');
				var last_element = arr[arr.length - 1];
				var increment = parseInt(last_element) + 1;
				if (increment > '${pagesAmount}') {
					Materialize.toast('That was last page', 4000);
				} else {
					window.location.href = 'http://localhost:8080/InternetShop/categories/page/'
							+ increment;
				}
			}
		</script>
		<jsp:doBody />
	</div>
	<div id="pagefooter">
		<jsp:invoke fragment="footer" />
	</div>
</body>
</html>