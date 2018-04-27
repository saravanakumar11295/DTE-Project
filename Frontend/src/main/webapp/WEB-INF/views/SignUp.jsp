<%@ include file="Header.jsp" %>

<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<body class="bg"><br><br>
<div class="container">
      <div class="col-xs-12 col-sm-12 col-md-6 well well-sm col-md-offset-4" >
      <legend><center><h1>Sign up!<h1></center></legend>
 <div class="row" style="margin-left:20px;margin-right:20px">
      
      <c:url value="/adduserDetail" var="string" />
           <form:form action="${string}" method="post" modelAttribute="user" >
<div class="form-group">
						<label>User Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :</label>
						<form:input path="userName" placeholder="UserName" />
</div>
<div class="form-group">
						<label>CustomerName&nbsp; :</label>
						<form:input path="customerName" placeholder="customerName" required="true" />
</div>
<div class="form-group">
						<label>EmailId&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :</label>
						<form:input path="emailId" placeholder="Email" required="true "/>
</div>
<div class="form-group">
						<label>PhoneNumber&nbsp;&nbsp; :</label>
						<form:input path="mobileNo" placeholder="Phonenumber" pattern="[789][0-9]{9}$" />
</div>
<div class="form-group">
						<label>Password&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :</label>
						<form:password path="password" placeholder="Password" required="true" />
</div>
<div class="form-group">
						<label>Address&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :</label>
						<form:textarea path="address" placeholder="address" />
</div>																									   
						<div>
                        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign up</button></div>
 </form:form>
</div>																									         
  </div>
  </div>
    <%@include file="Footer.jsp" %>
  
</body>
</html>
  