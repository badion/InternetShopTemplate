<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
	function formSubmit() {
		document.getElementById("logoutForm").submit();
	}
</script>
<div id="header">
	<nav class="light-blue lighten-1" role="navigation">
		<div class="container">
			<div class="nav-wrapper">
				<a id="logo-container" href="/InternetShop/" class="brand-logo">NaN</a>
				<ul class="right hide-on-med-and-down">
					<li class="active"><a href="/InternetShop/">Homepage</a></li>
					<li><a href="/InternetShop/categories/page/1">Categories</a></li>
					<li><a href="/InternetShop/login">Login</a></li>
					<c:if test="${pageContext.request.userPrincipal.name != null}">
						<li>Welcome : ${pageContext.request.userPrincipal.name} | <a
							href="javascript:formSubmit()"> Logout</a>
						</li>
						<c:url value="/logout" var="logoutUrl" />
						<form action="${logoutUrl}" method="post" id="logoutForm">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
						</form>
					</c:if>
				</ul>
				<ul id="nav-mobile" class="side-nav">
					<li class="active"><a href="/InternetShop/">Homepage</a></li>
					<li><a href="/InternetShop/categories/page/1">Categories</a></li>
					<li><a href="/InternetShop/login">Login</a></li>
					<c:if test="${pageContext.request.userPrincipal.name != null}">
						<li>Welcome : ${pageContext.request.userPrincipal.name} | <a
							href="javascript:formSubmit()"> Logout</a>
						</li>
						<c:url value="/logout" var="logoutUrl" />
						<form action="${logoutUrl}" method="post" id="logoutForm">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
						</form>
					</c:if>
				</ul>
				<a href="#" data-activates="nav-mobile" class="button-collapse"><i
					class="mdi-navigation-menu"></i></a>
			</div>
		</div>
	</nav>
</div>
<script>
	
</script>
