
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add color</title>


<div style="width: 20%; margin: 0px; float:left">
	<c:import url="/views/admin/admin.jsp"></c:import>
	</div>
	<div >
<a>Add color</a>
<br><br>
<form:form modelAttribute="color" action="addColor" method="post">
<div style=" font-size: 13px; color: red; margin: 0">
			<label for="articul">${colorException}</label>
		</div>
	<form:input path="name" placeholder="color"  pattern="[a-z]{3,}" title="Only letters!" maxlength="15"  />
	<button title="Save color">save color</button><br><br>
	<br>
	<a>Existing colors:</a><br><br>
<c:forEach var="color" items="${colors}" varStatus="c">
	${c.count}. ${color.name} 
	<a href="deleteColor/${color.id}" id="colorId" name="${color.id}">delete</a><br>
</c:forEach>
</form:form>
</div>