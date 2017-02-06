<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="http://localhost:8080/FirstShop/css/button.css">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/FirstShop/css/footer.css">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/FirstShop/css/menu.css">
<title>Edit commodity</title>
<body>
<div>
<form:form modelAttribute="commodity" action="./updateCommodity/${commodity.id}?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
		<form:input path="articul"  placeholder="articul"  pattern="[0-9]{3}" title="Only numbers!" maxlength="3" />
		<form:input path="price"  placeholder="price" pattern="\d+(\.\d{1,2})?" title="Only numbers!"/>
		<form:select path="composition"  items="${compositionDTOs}" itemLabel="fullComposition" itemValue="id"></form:select>
		<form:select path="category" items="${categorieDTOs}" itemLabel="fullCategory"  itemValue="id"></form:select>
		<form:select path="size" items="${sizeDTOs}" itemLabel="fullSize"  itemValue="id"></form:select>
		<form:select path="season" items="${seasonDTOs}" itemLabel="fullSeason"  itemValue="id"></form:select>
		<form:select path="gender" items="${genderDTOs}" itemLabel="fullGender"  itemValue="id"></form:select>
        <form:select path="colors" items="${colorDTOs}" itemLabel="fullColor"  itemValue="id"></form:select>
        <img src="${commodity.pathImage}" alt="add foto" width="100px" height="100px">
      	<input  type="file" name="image" accept="image/*" required>
		<button title="Update commodity">update commodity</button>
	</form:form>
</div>
</body>

