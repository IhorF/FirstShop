
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add gender</title>


<div style="width: 20%; margin: 0px; float:left">
	<c:import url="/views/admin/admin.jsp"></c:import>
	</div>
	<div >
<a>Add gender</a>
<br><br>
<form:form modelAttribute="gender" action="addGender" method="post">
<div style=" font-size: 13px; color: red; margin: 0">
			<label for="articul">${genderException}</label>
		</div>
	<form:input path="name" placeholder="gender" pattern="[a-z]{3,}" title="Only letters!" maxlength="15" />
	<button title="Save gender">save category</button>
</form:form>
	<br>
	<a>Existing genders:</a><br><br>

<c:forEach var="gender" items="${genders}" varStatus="c">
	${c.count}. ${gender.name} 
	<a href="deleteGender/${gender.id}">delete</a>
	<br>
</c:forEach>


</div>