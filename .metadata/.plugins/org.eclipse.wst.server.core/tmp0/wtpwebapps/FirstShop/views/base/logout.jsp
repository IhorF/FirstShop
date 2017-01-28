<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

 <title>Logout</title>
    <div style="width: 45%; margin: auto;"> <h1 style="text-align: center;">Do you really want to log out?</h1></div>
    
    
    
    
   <div style="width: 15%; margin: auto;"> <form:form style="  float: left;" action="logout" method="post">
							<button style="height: 35px; width: 95px; "><a>YES</a></button> 		
		</form:form>
	 <form:form  action="listcommodity" method="get">
								<button style="height: 35px; width: 95px; float: right;"><a>NO</a></button>
		</form:form>
	
		</div>
		
		
		
		
		
		
			
		
		
		
		
		
		
		
		
	<!-- 	<div style="width: 10%; margin: auto 0"></div> -->