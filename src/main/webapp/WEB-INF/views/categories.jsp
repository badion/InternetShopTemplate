<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="springForm"%>
<html>
<head>
<title>Categories</title>
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
			<c:forEach var="categ" items="${category}">
				<div class=col-md-4>
					<section>
						<header>
							<h2>${categ.name}</h2>
						</header>
						<p class="subtitle">In posuere eleifend odio. Quisque semper
							augue mattis maecenas ligula.</p>
						<p>
							<a href="#"><img
								src="<%=request.getContextPath()%>/static/images/pics13.jpg"
								alt=""></a>
						</p>
						<a href="/InternetShop/categories/${categ.id}/goods/"
							class="btn btn-success">More</a> <a href="#"
							data-href="<c:url value='/categories/delete/${categ.id}'/>"
							data-toggle="modal" data-target="#confirm-delete"
							class="btn btn-danger">Remove</a>
					</section>
				</div>
				<div class="modal fade" id="confirm-delete" tabindex="-1"
					role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">Delete confirmation</div>
							<div class="modal-body">
								Are you sure, that you want to delete this category and all
								subcategories?
								<p class="debug-url"></p>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Cancel</button>
								<a class="btn btn-danger btn-delete">Delete</a>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		<a href="<c:url value='/categories/add'/>" class="button">Add new
			category</a>
	</div>
	<script
		src="<%=request.getContextPath()%>/static/js/confirmation_delete.js"></script>

</body>
</html>