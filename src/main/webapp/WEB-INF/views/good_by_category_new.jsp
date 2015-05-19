<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Add new category</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link type="text/css"
	href="<%=request.getContextPath()%>/static/css/bootstrap.css"
	rel="stylesheet" />
<script
	src="<%=request.getContextPath()%>/static/js/jquery-1.11.3.min.js"></script>
<script src="<%=request.getContextPath()%>/static/js/bootstrap.js"></script>
</head>
<body>
	<jsp:include page="../parts/header.jsp"></jsp:include>
	<div class="container">
		<form:form name="addGoodForm" commandName="good" action="add.do"
			method="POST">
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
</body>
</html>