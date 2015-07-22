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
		<form:form name="categoryForm" id="categoryForm"
				commandName="category" action="add.do" method="POST">
			<table class="table-responsive">
				<tr>
					<td>Name of category</td>
					<td><form:input path="name" class="form-control" /></td>
					<td><form:errors path="name" cssClass="error" /></td>
				</tr>
				<tr>
					<td colspan="3"><input type="submit" class="btn btn-success"
							value="Save category" required></td>
				</tr>
			</table>
		</form:form>
	</div>
	</jsp:body>
</t:genericpage>
