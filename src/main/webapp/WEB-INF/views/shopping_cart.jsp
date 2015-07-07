<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Shopping cart</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link type="text/css"
	href="<%=request.getContextPath()%>/static/css/bootstrap.css"
	rel="stylesheet" />
<script
	src="<%=request.getContextPath()%>/static/js/jquery-1.11.3.min.js"></script>
<script src="<%=request.getContextPath()%>/static/js/bootstrap.js"></script>

<html>
<body>
	<jsp:include page="../parts/header.jsp" />
	<div class="container">
		<div class="row">
			<c:forEach var="good" items="${shoppingCart.goods}">
				<div class=col-md-4>
					<p>${good.name}</p>
					<p>
						<a href="#"><img
							src="<%=request.getContextPath()%>/static/images/pics13.jpg"
							alt=""></a>
					</p>
					<p class="subtitle">${good.description}</p>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>