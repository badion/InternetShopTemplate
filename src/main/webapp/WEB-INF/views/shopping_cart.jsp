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
			<c:forEach var="good" items="${shoppingCart.goods}">
				<div class=col-md-4>
					<p>
						<a href="/InternetShop/shopping-cart/delete/${good.id}">Delete</a>
					</p>
					<p>Name: ${good.name}</p>
					<p>Quantity: ${good.quantity}</p>
					<p>Price: ${good.price}</p>
					<p>
							<a href="#"><img
								src="<c:url value="/static/images/pics13.jpg" />" alt=""></a>
					</p>
					<p class="subtitle">${good.description}</p>
				</div>
			</c:forEach>
			<p>Total price: ${totalSum}</p>
		</div>
	</div>
	</jsp:body>
</t:genericpage>