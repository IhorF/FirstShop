
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add season</title>

<div style="width: 20%; margin: 0px; float:left">
	<c:import url="/views/admin/admin.jsp"></c:import>
	</div>
	<div >
<a>Add season</a>
<br><br>

<form:form modelAttribute="season" action="addSeason" method="post">
<div style=" font-size: 13px; color: red; margin: 0">
			<label for="articul">${seasonException}</label>
		</div>
	<form:input path="name" placeholder="season" pattern="[a-z]{3,}" title="Only letters!" maxlength="15" />
	<button title="Save season">save season</button>
</form:form>
	<br>
	<a>Existing seasons:</a><br><br>
<c:forEach var="season" items="${seasons}" varStatus="c">
	${c.count}. ${season.name} 
	<a href="deleteSeason/${season.id}">delete</a>
	<br>
</c:forEach>


</div>



