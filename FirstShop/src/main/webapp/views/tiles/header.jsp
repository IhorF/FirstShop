<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" href="css/menu.css">
<ul class="snip1168">
	<sec:authorize access="!isAuthenticated()">
		<li class="current"><a href="home" data-hover="Home">Home</a></li>
		<li><a href="aboutUs" data-hover="About Us">About Us</a></li>
		<li><a href="contacts" data-hover="Contacts">Contacts</a></li>
		<li><a href="listcommodity" data-hover="List commodities">List commodities</a></li>
		<li><a href="registration" data-hover="Register">Register</a></li>
		<li><a href="loginpage" data-hover="Login">Login</a></li>
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<li><a href="admin" data-hover="Admin page">Admin page</a></li>
		<li><a href="listcommodity" data-hover="List commodities">List commodities</a></li>
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_USER')">
		<li><a href="profile" data-hover="Profile">Profile</a></li>
		<li><a href="basket" data-hover="Basket">Basket</a></li>
		<li><a href="listcommodity" data-hover="List commodities">List commodities</a></li>
	</sec:authorize>
	<sec:authorize access="isAuthenticated()">
		<li><a href="logoutPage" data-hover="Logout">Logout</a></li>
	</sec:authorize>
	<sec:authorize access="isAuthenticated()">
		<c:forEach var="customer" items="${customerDTOs}">
	${customer.name}  ${customer.surName}
	</c:forEach>
	</sec:authorize>
</ul>
