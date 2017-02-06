<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<title>List commodities</title>
<div style="float: left margin: 0;"></div>
<c:forEach var="commodity" items="${commodities}">
	<div style="border: solid 2px grey; width: 20%; float: left;">
		<div style="border: solid 2px black; float: left;">
			<img src="${commodity.pathImage}" alt="add foto" width="100px"
				height="100px">
		</div>
		<div>
			<h2 style="color: red; text-align: center">Articul:
				${commodity.articul}</h2>
		</div>
		<br>
		<br> <a>Characteristics:</a> <br>${commodity.composition}<br>${commodity.category}<br>${commodity.gender}<br>${commodity.size}<br>Color:
		${commodity.colors}<br> <a id="price" name="${commodity.price}">Price:
			${commodity.price} grn.</a>
		<sec:authorize access="hasRole('ROLE_USER')">
			<form action="buyCommodity/${commodity.id}" class="buy">
				<input type="text" id="cost" style="width: 40px" name="quantity"
					value="1" pattern="[0-9]{1,10000}" title="Only numbers!"
					maxlength="5">
				<button>buy</button>
			</form>
		</sec:authorize>
		<br>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<a href="editCommodity/${commodity.id}">edit commodity</a>
			<br>
			<a href="deleteCommodityFromListcommodities/${commodity.id}">delete</a>
			<br>
			<br>
		</sec:authorize>
	</div>
</c:forEach>


