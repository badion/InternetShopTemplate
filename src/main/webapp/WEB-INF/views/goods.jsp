<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="springForm"%>
<html>
<head>
<title>Goods</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link type="text/css"
	href="<%=request.getContextPath()%>/static/css/bootstrap.css"
	rel="stylesheet" />
<script
	src="<%=request.getContextPath()%>/static/js/jquery-1.11.3.min.js"></script>
<script src="<%=request.getContextPath()%>/static/js/bootstrap.js"></script>
</head>
<body>
	<jsp:include page="../parts/header.jsp" />

	<div class="container">
		<div class="row">
			<c:forEach var="good" items="${goods}">
				<div class=col-md-4>
					<section>
						<header>
							<h3>${good.name}</h3>
						</header>
						<p>
							<a href="#"><img
								src="<%=request.getContextPath()%>/static/images/pics13.jpg"
								alt=""></a>
						</p>
						<p class="subtitle">${good.description}</p>
						<%-- 							<a href="/InternetShop/categories/${categ.id}/goods/" --%>
						<!-- 								class="btn btn-success">More</a> <a href="#" -->
						<%-- 								data-href="<c:url value='/categories/delete/${categ.id}'/>" --%>
						<!-- 								data-toggle="modal" data-target="#confirm-delete" -->
						<!-- 								class="btn btn-danger">Remove</a> -->
					</section>
				</div>
			</c:forEach>
		</div>
	</div>

</body>
</html>