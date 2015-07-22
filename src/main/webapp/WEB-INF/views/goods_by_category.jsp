<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="springForm"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<t:genericpage>
	<jsp:attribute name="header">
		<jsp:include page="../parts/header.jsp" />
    </jsp:attribute>
	<jsp:attribute name="footer">
  	 	<jsp:include page="../parts/footer.jsp" />
    </jsp:attribute>
	<jsp:body>
	<div class="container">
		<div class="row">
			<c:forEach var="cat" items="${category}" varStatus="iterationCat">
				<div class="container">
					<h1>${category[iterationCat.index].name}</h1>
				</div>
				<c:if test="${category[iterationCat.index].goods != null}">
					<c:forEach var="good" items="${category[iterationCat.index].goods}"
							varStatus="iterationGood">
						<div class="col m6 l4">
							<section>
								<header>
									<h3>
										<a
												href="/InternetShop/categories/${category[iterationCat.index].id}/goods/${category[iterationCat.index].goods[iterationGood.index].id}">${category[iterationCat.index].goods[iterationGood.index].name}</a>
									</h3>
								</header>
								<p>
									<a href="#"><img
											src="<c:url value="/static/images/pics13.jpg"/>" alt=""></a>
								</p>
								<p class="subtitle">${category[iterationCat.index].goods[iterationGood.index].description}</p>
								<a
										href="/InternetShop/categories/${category[iterationCat.index].id}/goods/${category[iterationCat.index].goods[iterationGood.index].id}/delete"
										class="waves-effect waves-red btn-flat">Delete</a>
								<a href="/InternetShop/shopping-cart/orderNow/${good.id}"
										class="waves-effect waves-green btn-flat">Order now</a>
							</section>
						</div>
					</c:forEach>
				</c:if>
				<a
						href="/InternetShop/categories/${category[iterationCat.index].id}/goods/add">Add
					new good</a>
			</c:forEach>
		</div>
	</div>
	<script src="/static/js/confirmation_delete.js"></script>
	</jsp:body>
</t:genericpage>