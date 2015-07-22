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
			<c:forEach var="good" items="${goods}">
				<div class="col m6 l4">
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
	</jsp:body>
</t:genericpage>
