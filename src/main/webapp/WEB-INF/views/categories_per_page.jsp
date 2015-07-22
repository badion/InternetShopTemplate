<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
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
			<c:forEach var="categ" items="${paginatorCategories}">
				<div class="col m6 l4">
						<header>
							<h4>${categ.name}</h4>
						</header>
						<p class="subtitle">In posuere eleifend odio. Quisque semper
							augue mattis maecenas ligula.</p>
						<p>
							<a href="#"><img class="responsive-img"
								src="<c:url value="/static/images/pics13.jpg" />" alt=""></a>
						</p>
						<a href="/InternetShop/categories/${categ.id}/goods/"
							class="waves-effect waves-green btn-flat">More</a> 
						<a class="waves-effect waves-red btn-flat"
							href="/InternetShop/categories/delete/${categ.id}"
							data-target="modal1">Remove</a>
				</div>
				</c:forEach>
		</div>
		<div class="center-btn"> 
		<ul class="pagination"> 
			<li class="waves-effect"><a onclick="decriment_page();"><i
							class="material-icons">chevron_left</i></a></li>
			<c:forEach var="i" begin="1" end="${pagesAmount}">
				<li class="waves-effect"><a
							href="/InternetShop/categories/page/${i}">${i}</a></li>
			</c:forEach>
			<li class="waves-effect"><a onclick="increment_page();"><i
							class="material-icons">chevron_right</i></a></li>
				</ul>
		 <a href="<c:url value='/categories/add'/>"
					class="btn-floating btn-large waves-effect waves-light red"><i
					class="material-icons">add</i></a>
		</div>  
			</div>
				<div class="center-btn">
				<a class="waves-effect waves-light btn"
				href="/InternetShop/categories">Show all</a>
			</div>
    </jsp:body>
</t:genericpage>