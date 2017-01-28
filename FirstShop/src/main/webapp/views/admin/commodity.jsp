
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<title>Add commodity</title>

<div style="width: 20%; margin: 0px; float:left">
	<c:import url="/views/admin/admin.jsp"></c:import>
	</div>
	<div >

	<a>Add Commodity</a>
	<br>

	<form:form modelAttribute="commodity" action="./addCommodity?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data" >
	<div style=" font-size: 13px; color: red; margin: 0">
			<label for="articul">${commodityArticulException}</label>
		</div>
		<form:input path="articul" placeholder="articul"  pattern="[0-9]{3}"  title="Only numbers!" maxlength="3" />
		<form:input path="price" placeholder="price"  pattern="\d+(\.\d{1,2})?" title="Only numbers!"/>
	
		<form:select path="composition" items="${compositionDTOs}" itemLabel="fullComposition"  itemValue="id"></form:select>
		<form:select path="category" items="${categorieDTOs}" itemLabel="fullCategory"  itemValue="id"></form:select>
		<form:select path="size" items="${sizeDTOs}" itemLabel="fullSize"  itemValue="id"></form:select>
		<form:select path="season" items="${seasonDTOs}" itemLabel="fullSeason"  itemValue="id"></form:select>
		<form:select path="gender" items="${genderDTOs}" itemLabel="fullGender"  itemValue="id"></form:select>
        <form:select path="colors" items="${colorDTOs}" itemLabel="fullColor"  itemValue="id"  ></form:select>
       
      	<input  type="file" name="image" accept="image/*"  required >
		<button title="Зберегти товар">save commodity</button>
	</form:form>
	<br>
	<a>Existing commodities:</a><br><br>
		<c:forEach var="commodity" items="${commoditiesDTOs}" varStatus="ccc">
	 ${ccc.count}. ${commodity.articul}
	<a href="deleteCommodity/${commodity.id}">delete</a>
	<br>
	</c:forEach>
	<br>
	
	<br>
	<a href="${pageContext.request.contextPath}/" title="Назад"><button>Back</button></a>

</div>