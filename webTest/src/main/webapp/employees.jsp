<%@page import="java.util.ArrayList"%>
<%@page import="dao.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



<% String currentSortBy = request.getParameter("sortBy"); %>
<% String currentSortOrder = request.getParameter("sortOrder"); %>
<% String newSortOrder = "asc".equals(currentSortOrder) ? "desc" : "asc"; %>


<table>

<tr>

			 <th><a href="?sortBy=id&sortOrder=<%= newSortOrder %>">ID</a></th>
            <th><a href="?sortBy=name&sortOrder=<%= newSortOrder %>">Name</a></th>
            <th><a href="?sortBy=age&sortOrder=<%= newSortOrder %>">Age</a></th>
            <th><a href="?sortBy=gender&sortOrder=<%= newSortOrder %>">Gender</a></th>
            <th><a href="?sortBy=salary&sortOrder=<%= newSortOrder %>">Salary</a></th>
            <th><a href="?sortBy=experience&sortOrder=<%= newSortOrder %>">Experience</a></th>
            <th><a href="?sortBy=level&sortOrder=<%= newSortOrder %>">Level</a></th>

</tr>
<c:forEach items="${emps}" var="e">
 
  <tr>
  
  <td><c:out value="${e.id}"></c:out></td>
  

  <td>${e.name}</td>
  <td>${e.age}</td>
  <td>${e.gender}</td>
  <td>${e.salary}</td>
  <td>${e.experience}</td>
  <td>${e.level}</td>
  <td>
     <a href="employees?operation=Update&id=${e.id}">Update</a>
     <a href="employees?operation=Delete&id=${e.id}">Delete</a>
  </td>
  
  </tr>
 
 </c:forEach>
 
 <tr>
 
 <td colspan="7"> 
 <a href ="employees?operation=new">New Employee</a>
 </td>
 
 
 </tr>
 
</table>


<table>

<tr>
<th>Id</th>
<th>Name</th>
<th>Age</th>
<th>Gender</th>
<th>Salary</th>
<th>Experience</th>
<th>Level</th>
</tr>

<%
   List<Employee> emps=(List<Employee>) request.getAttribute("emps");
   for(Employee e:emps){
	  %>
	  <tr>
	  <td>
	  <%=e.getId() %>
	  </td>
	  <td>
	  <%=e.getName() %>
	  </td>
	  
	  <td>
	  <%=e.getAge() %>
	  </td>
	  <td>
	  <%=e.getGender() %>
	  </td>
	  <td>
	  <%=e.getSalary() %>
	  </td>
	  <td>
	  <%=e.getExperience() %>
	  </td>
	  <td>
	  <%=e.getLevel() %>
	  </td>
	  
	  
	  </tr>
	  
   <% }%>
   
<form action="employees" method="GET">
    <label for="searchBy">Search By:</label>
    <select name="searchBy" id="searchBy" required>
        <option value="" disabled selected>-- Select an option --</option>
        <option value="id">ID</option>
        <option value="name">Name</option>
        <option value="age">Age</option>
        <option value="gender">Gender</option>
        <option value="level">Level</option>
        <option value="experience">Experience</option>
        <option value="salary">Salary</option>
    </select>

    <input type="text" name="searchValue" placeholder="Enter value" required>

    <label for="comparison">Condition:</label>
    <select name="comparison" id="comparison">
        <option value="equals">Equals</option>
        <option value="greater">Greater Than</option>
        <option value="less">Less Than</option>
    </select>

    <button type="submit">Search</button>
</form>
</body>
</html>