<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<title>Registration</title>
<link rel="stylesheet" href="css/customer.css">
<link rel="stylesheet" href="css/button.css">
<div>
	<h3 style="text-align: center; padding-top: 2%;">Customer
		registration</h3>
</div>
<sf:form modelAttribute="customer" action="saveCustomer" method="post">
	<div
		style="text-align: center; font-size: 13px; color: red; margin: 5px">
		<label for="name">${customernameException}</label>
	</div>
	<sf:input path="name" placeholder="Name" />
	<div
		style="text-align: center; font-size: 13px; color: red; margin: 5px">
		<label for="surName">${surnameException}</label>
	</div>
	<sf:input path="surName" placeholder="Surname" />
	<div
		style="text-align: center; font-size: 13px; color: red; margin: 5px">
		<label for="phoneNumber">${phonenumberException}</label>
	</div>
	<sf:input path="phoneNumber" type="tel" placeholder="Phonenumber" />
	<div
		style="text-align: center; font-size: 13px; color: red; margin: 5px">
		<label for="eMail">${emailException}</label>
	</div>
	<sf:input path="eMail" type="email" placeholder="Email" />
	<div
		style="text-align: center; font-size: 13px; color: red; margin: 5px">
		<label for="password">${passwordException}</label>
	</div>
	<sf:input path="password" type="password" placeholder="Password" />
	<br>
	<div style="width: 95px; margin: auto;">
		<button style="height: 35px; width: 95px;">
			<a>register</a>
		</button>
	</div>
</sf:form>





