<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add category</title>
<div style="width: 20%; margin: 0px; float: left">
	<c:import url="/views/admin/admin.jsp"></c:import>
</div>
<div>
	<a>Add category</a> <br> <br>
	<form:form modelAttribute="category" action="addCategory" method="post">
		<div style="font-size: 13px; color: red; margin: 0">
			<label for="articul">${categoryException}</label>
		</div>
		<form:input path="name" placeholder="category" pattern="[a-z]{3,}"
			title="Only letters!" maxlength="15" />
		<button title="Save category">save category</button>
		</form:form>
	<br> <a>Existing categories:</a><br> <br>
	<c:forEach var="category" items="${categories}" varStatus="c">
	${c.count}. ${category.name} 
	<a href="deleteCategory/${category.id}">delete</a>
	<br>
	</c:forEach>
</div>





