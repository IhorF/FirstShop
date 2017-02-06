<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" href="css/button.css">
<title>Insert title here</title>
${customer.name} ${customer.surName}
<br>
<img src="${customer.pathImage}" alt="add foto" width="200px"
	height="200px">
<br>
<form:form action="./saveImage?${_csrf.parameterName}=${_csrf.token}"
	method="post" enctype="multipart/form-data">
	<input type="file" name="image" accept="image/*" required>
	<button>save image</button>
</form:form>
<br>
<a>List of ordered commodities:</a>
<br>
<br>
<c:forEach var="commodity" items="${customer.commodities}" varStatus="c">
	${c.count}. ${commodity.articul} 
	<a href="deleteCommodityFromCustomer/${commodity.id}">delete</a>
	<br>
</c:forEach>


