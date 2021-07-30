<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Login</title>
    <style>
    .us{
        background-color: rgba(0, 0, 0, 0.3);
        font-size: 100%;
        text-align: center;
        padding-top: 80px;
        padding-bottom: 10px;
        width: 500px; 
        min-width: 0; 
        margin-top: 120px;
        margin-left: 440px; 
    }
    .us input
    {
        margin-left: 3%;
        width: 200px;
    }
    label {
        width: 100px ;
    }
    button{       
        margin-bottom: 10px ;
        width: 100px ;  
        padding-bottom: 40%;      
    }
    body{
        background-color: #d8d8d8;
    }
    </style>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    	<a class="navbar-brand" href="#">Audit Management System</a>
  	</nav>
  	
  	
      
      
    <div class="us">   
        <c:choose>
            <c:when test="${msg == null}">
                <form:form action="/home" modelAttribute="user" method="post">
                <h2>Login</h2>
                <font color="red">${errorMessage}</font>
                <br>
                <br>
                <label for="Username">Username:</label>
                <form:input path="userId" placeholder="Username"/>
                <br>
                <label for="Password">Password:</label>
                <form:input path="password" type="password" placeholder="Password"/>
                <br>
                <br>
                <input class="btn btn-success" type="submit" class="btn" value="Login">
                </form:form>
            </c:when>
            <c:when test="${msg != null}">
            		<div> ${msg}. </div><div><br><br><a href="/loginPage">Click here</a> to login again</div>  
            </c:when>
        </c:choose>
    </div>
    <script type="text/javascript">
	    const inputs = document.querySelectorAll(".input");
	
	
	    function addcl(){
	    	let parent = this.parentNode.parentNode;
	    	parent.classList.add("focus");
	    }
	
	    function remcl(){
	    	let parent = this.parentNode.parentNode;
	    	if(this.value == ""){
	    		parent.classList.remove("focus");
	    	}
	    }
	
	
	    inputs.forEach(input => {
	    	input.addEventListener("focus", addcl);
	    	input.addEventListener("blur", remcl);
	    });

    </script>
</body>
</html>