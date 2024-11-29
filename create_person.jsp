<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<body>
 <%--Instantiating a Java bean:Person --%>
 <jsp:useBean id="personObj"
  class="example.bean.Person"
  scope="session"/>
  <%--Setting the value of the properties of the bean --%>
  <%--here * means select all from  database --%>
  <jsp:setProperty property="*" name="personObj"/>  
  <h1>Person created Successfully.</h1>
  <h1>To view,please
   <a href="show_person.jsp">
    Click Here
   </a>
  </h1>
  
</body>
</html>