<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
			<c:forEach var="cat" items="${category}" varStatus="iterationCat">
				<div class="container">
					<h1>${category[iterationCat.index].name}</h1>
				</div>
				<c:if test="${category[iterationCat.index].goods != null}">
					<c:forEach var="good" items="${category[iterationCat.index].goods}"
						varStatus="iterationGood">
						<div class=col-md-4>
							<section>
								<header>
									<h3>
										<a
											href="/InternetShop/categories/${category[iterationCat.index].id}/goods/${category[iterationCat.index].goods[iterationGood.index].id}">${category[iterationCat.index].goods[iterationGood.index].name}</a>
									</h3>
								</header>
								<p>
									<a href="#"><img
										src="<%=request.getContextPath()%>/static/images/pics13.jpg"
										alt=""></a>
								</p>
								<p class="subtitle">${category[iterationCat.index].goods[iterationGood.index].description}</p>
								<a href="" class="btn btn-danger" data-toggle="modal"
									data-target="#confirm-delete"
									data-href="<c:url value='/categories/${category[iterationCat.index].id}/goods/${category[iterationCat.index].goods[iterationGood.index].id}/delete'/>">Delete</a>
							</section>
						</div>
					</c:forEach>
				</c:if>
				<div class="modal fade" id="confirm-delete" tabindex="-1"
					role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">Delete confirmation</div>
							<div class="modal-body">
								Are you sure, that you want to delete this product?
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
				<a
					href="/InternetShop/categories/${category[iterationCat.index].id}/goods/add">Add
					new good</a>
			</c:forEach>
		</div>
	</div>
	<script
		src="<%=request.getContextPath()%>/static/js/confirmation_delete.js"></script>
</body>
</html>