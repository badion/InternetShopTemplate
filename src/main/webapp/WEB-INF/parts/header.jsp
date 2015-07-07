<!-- Header -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div id="header">
	<div class="container">
		<!-- Logo -->
		<div id="logo">
			<h1>
				<a href="/InternetShop/">Internet-shop</a>
			</h1>
		</div>

		<!-- Nav -->
		<nav id="nav">
			<ul class="nav navbar-nav">
				<li class="active"><a href="/InternetShop/">Homepage</a></li>
				<li><a href="/InternetShop/categories">Categories</a></li>
				<li><a href="#">Right Sidebar</a></li>
				<li><a href="#">No Sidebar</a></li>
				<li id="shoppingCart" style="margin-left: 550px">Shopping cart
					(${fn:length(shoppingCart.goods)})</li>
			</ul>
		</nav>
	</div>
</div>
<!-- Header -->