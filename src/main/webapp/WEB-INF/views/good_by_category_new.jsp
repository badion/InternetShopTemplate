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
		<form:form name="addGoodForm" id="addGoodForm" commandName="good"
				action="add.do" method="POST">
			<p>Add in ${cat.name} category
			
				
				<table class="table-responsive">
				<tr>
					<td>Good name</td>
					<td><form:input path="name" class="form-control" /></td>
					<td><form:errors path="name" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Description</td>
					<td><form:input path="description" class="form-control" /></td>
					<td><form:errors path="description" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Short description</td>
					<td><form:input path="shortDescription" class="form-control" /></td>
					<td><form:errors path="shortDescription" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Quantity</td>
					<td><form:input path="quantity" class="form-control" /></td>
					<td><form:errors path="quantity" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Price</td>
					<td><form:input path="price" class="form-control" /></td>
					<td><form:errors path="price" cssClass="error" /></td>
				</tr>
			</table>
			<input type="submit" class="btn btn-primary" />
		</form:form>
		</div>
	</jsp:body>
</t:genericpage>
