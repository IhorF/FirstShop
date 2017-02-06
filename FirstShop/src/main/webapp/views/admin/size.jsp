<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add size</title>


<div style="width: 20%; margin: 0px; float:left">
	<c:import url="/views/admin/admin.jsp"></c:import>
	</div>
	<div >
<a>Add size</a>
<br><br>
<form:form modelAttribute="size" action="addSize" method="post">
<div style=" font-size: 13px; color: red; margin: 0">
		<label for="articul">${sizeException}</label>
</div>
	<form:input path="name" placeholder="size" pattern="[0-9]{2}" title="Only numbers!" maxlength="2" />
	<button title="Save size">save size</button>
</form:form>
	<br>
	<a>Existing sizes:</a><br><br>
<c:forEach var="size" items="${sizes}" varStatus="c">
	${c.count}. ${size.name} 
	<a href="deleteSize/${size.id}">delete</a>
	<br>
</c:forEach>
</div>
