<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--Obtaining the bean of type:person with id.personObj from session scope --%>
 <jsp:useBean id="personObj"
  class="example.bean.Person"
  scope="session"/>
  <%--Retrieving values of the bean properties and printing them  --%>
  <h1>Person Details:</h1>
  <h2>Name <jsp:getProperty property="name" name="personObj"/></h2>
  
   <h2>Age<jsp:getProperty property="age" name="personObj"/></h2>
   
    <h2>Weight<jsp:getProperty property="weight" name="personObj"/></h2>
  
  
</body>
</html>