<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="springForm"%>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<link type="text/css"
	href="<%=request.getContextPath()%>/static/css/bootstrap.css"
	rel="stylesheet" />
<script
	src="<%=request.getContextPath()%>/static/js/jquery-1.11.3.min.js"></script>
<script src="<%=request.getContextPath()%>/static/js/bootstrap.js"></script>
</head>
<title>Home</title>
</head>
<body>
	<jsp:include page="../parts/header.jsp" />
	<div class="container">This is home page</div>
</body>
</html>
