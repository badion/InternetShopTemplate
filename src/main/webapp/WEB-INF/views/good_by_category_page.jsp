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
		${good.name}
		${good.description}
		 <a href="" class="btn btn-danger" data-toggle="modal"
				data-target="#confirm-delete"
				data-href="<c:url value='/categories/${category.id}/goods/${good.id}/delete'/>">Delete</a>
	</div>
	<div class="modal fade" id="confirm-delete" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">Delete confirmation</div>
				<div class="modal-body">
					Are you sure, that you want to delete this product?
					<p class="debug-url"></p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
					<a class="btn btn-danger btn-delete">Delete</a>
				</div>
			</div>
		</div>
	</div>
	<script
			src="<%=request.getContextPath()%>/static/js/confirmation_delete.js"></script>
<</jsp:body>
</t:genericpage>