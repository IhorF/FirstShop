<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<title>Add composition</title>
<input type="hidden" name="csrf_name" value="${_csrf.parameterName}" />
<input type="hidden" name="csrf_value" value="${_csrf.token}" />

<div style="width: 20%; margin: 0px; float: left">
	<c:import url="/views/admin/admin.jsp"></c:import>
</div>
<div>
	<a>Add composition</a> <br>
	<form:form action="addComposition" method="post">
		<div style="font-size: 13px; color: red;">
			<label for="bavovna">${compositionException}</label>
		</div>
		<input name="bavovna" type="number" placeholder="bavovna,%"
			pattern="[0-9]" title="Only numbers!" maxlength="3">
		<input name="poliamid" type="number" placeholder="poliamid,%"
			pattern="[0-9]" title="Only numbers!" maxlength="2">
		<input name="elastan" type="number" placeholder="elastan,%"
			pattern="[0-9]" title="Only numbers!" maxlength="2">
		<button>save composition</button>
	</form:form>
	<br> <a>Existing compositions:</a><br> <br>
	<c:forEach var="composition" items="${compositions}" varStatus="c">
		 ${c.count}. <a>Bavovna </a>${composition.cotton}   <a>%, Poliamid
		</a> ${composition.polyamide} <a>%, Elastan </a>${composition.lycra}<a>%;</a>
		<a href="delComposition/${composition.id}" title="Видалити">delete</a>
		<br>
	</c:forEach>
</div>
