
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<title>Shop</title>


	<%-- <sec:authentication property="name" /> --%>


          <div style="width: 30%; margin: auto;"> <h1 style="text-align: center;">WELCOME TO SHOP</h1></div>
        
   <%--  
	<sec:authorize access="!isAuthenticated()">
		<br>
		<a href="loginpage">login</a>
		<br>
		<a href="registration">registration</a>
		<br>
		<a href="listcommodity">list commodities</a>
	</sec:authorize>


	<sec:authorize access="hasRole('ROLE_ADMIN')">
	
		
		<br>
		<a href="admin">admin page</a>
		<br>
<a href="listcommodity">list commodities</a>
	</sec:authorize>
	<br>
	<sec:authorize access="hasRole('ROLE_USER')">
		<a href="profile">profile</a>
		<br>
		<a href="basket">basket</a>
		<br>
		<a href="listcommodity">list commodities</a>
	</sec:authorize>
	<sec:authorize access="isAuthenticated()">

		<form:form action="logout" method="post">
		<br>
			<button>logout</button>
		</form:form>
	</sec:authorize>

	<br>
	<br>
	<br>
 --%>
<%-- 
	<c:forEach var="commodity" items="${commodities}">
		${commodity.articul}
		<sec:authorize access="hasRole('ROLE_USER')">
		<form action="buyCommodity/${commodity.id}" class="buy">
			<a id="price" name="${commodity.price}"> ${commodity.price} грн.</a>
			<input type="text" id="cost" style="width: 20px" name="quantity" value="1">
			<button >buy</button>
			</form>
		</sec:authorize>
		<br>

	</c:forEach>
	
		<script>
		
		$('.buy').click(
				function () {
					var number = document.getElementById('cost').value;
					var priceCommodity = document.getElementById('price').getAttribute('name');
					 var idCommodity = document.getElementById('cost').getAttribute('name'); 

					var totalCost = number * priceCommodity;
					console.log(totalCost);
				console.log(idCommodity); 
				
				})
	</script> --%>
