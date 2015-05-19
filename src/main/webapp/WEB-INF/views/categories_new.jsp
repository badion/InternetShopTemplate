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
		<form:form name="categoryForm" commandName="category" action="add.do"
			method="POST">
			<table class="table-responsive">
				<tr>
					<td>Name of category</td>
					<td><form:input path="name" class="form-control" /></td>
					<td><form:errors path="name" cssClass="error" /></td>
				</tr>
				<tr>
					<td colspan="3"><input type="submit" class="btn btn-success"
						value="Save category"></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>