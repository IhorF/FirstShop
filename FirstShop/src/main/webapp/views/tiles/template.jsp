<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/button.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <title>Shop</title> -->
</head>
<body>
<div ><tiles:insertAttribute name="header"/></div>
	<div style="height:600px"><tiles:insertAttribute name="body"/></div>
	<div><tiles:insertAttribute name="footer"/></div>
</body>
</html>