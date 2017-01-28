
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 


<title>Basket</title>


<c:forEach var="commodity" items="${commodities}" >
<img src="${commodity.pathImage}" alt="add foto" width="100px" height="100px"><br>
<a>Articul: </a>${commodity.articul} <br>  <a>Price: </a>${commodity.price} 	<br>

	 <a href="deleteFromOrder/${commodity.id}">delete</a>
    <a href="getOrder/${commodity.id}">get order</a>

<br>
</c:forEach> 

