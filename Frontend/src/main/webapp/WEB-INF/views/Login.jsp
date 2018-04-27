<html>
<%@include file="Header.jsp" %>

<br><br>
<div class="container">
	<div class="row">
		<div class="col-md-4 col-md-offset-4 text-center">
			<div class="search-box">
				<div class="caption">
					<h1>welcome to Login</h1>
				</div>
				<c:url value="/signIn" var="action" />
				<form:form class="loginForm" modelAttribute="user" method="POST" action="${action}">
					<div class="input-group">
						<form:input path="userName" id="name" class="form-control" placeholder="Full Name" />
						<form:password path="password" id="paw" class="form-control" placeholder="Password" />
						<input type="submit" id="submit" class="form-control" value="Submit">
					</div>
				</form:form>
			</div>
		</div>
		
	</div>
</div>

<%@include file="Footer.jsp" %>

</body>
</html>