<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, servlets.Dept, dao.Employee" %>

<%
    Dept dept = (Dept) request.getAttribute("dept");
    List<Employee> employees = (List<Employee>) request.getAttribute("employees");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Departments</title>
    <script>
        function showForm(action) {
            document.getElementById('deptForm').style.display = 'block';
            document.getElementById('operation').value = action;

            if (action === 'AddDept') {
                document.getElementById('deptid').value = '';
                document.getElementById('deptname').value = '';
                document.getElementById('deptlocation').value = '';
            } else if (action === 'UpdateDept' && document.getElementById('deptid').value === '') {
                alert("Please select a department first.");
                document.getElementById('deptForm').style.display = 'none';
            }
        }
    </script>
</head>
<body>
    <h2>Department Details</h2>

    <% if (dept != null) { %>
        <p><strong>ID:</strong> <%= dept.getId() %></p>
        <p><strong>Name:</strong> <%= dept.getName() %></p>
        <p><strong>Location:</strong> <%= dept.getLocation() %></p>
    <% } else { %>
        <p style="color: pink;">No department found.</p>
    <% } %>

    <h3>Employees in this Department</h3>

    <% if (employees != null && !employees.isEmpty()) { %>
        <table border="1">
            <tr>
                <th>ID</th><th>Name</th><th>Age</th><th>Gender</th><th>Salary</th><th>Experience</th><th>Level</th>
            </tr>
            <% for (Employee emp : employees) { %>
                <tr>
                    <td><%= emp.getId() %></td>
                    <td><%= emp.getName() %></td>
                    <td><%= emp.getAge() %></td>
                    <td><%= emp.getGender() %></td>
                    <td><%= emp.getSalary() %></td>
                    <td><%= emp.getExperience() %></td>
                    <td><%= emp.getLevel() %></td>
                </tr>
            <% } %>
        </table>
    <% } else { %>
        <p style="color: red;">No employees found for this department.</p>
    <% } %>

    <!-- Navigation Buttons -->
    <form action="depts" method="post">
        <button type="submit" name="operation" value="First">First</button>
        <button type="submit" name="operation" value="Previous">Previous</button>
        <button type="submit" name="operation" value="Next">Next</button>
        <button type="submit" name="operation" value="Last">Last</button>
    </form>

    <!-- Management Buttons -->
    <button onclick="showForm('AddDept')">New Dept</button>
    <button onclick="showForm('UpdateDept')">Update Dept</button>
    <form action="depts" method="post" style="display: inline;">
        <button type="submit" name="operation" value="DeleteDept" onclick="return confirm('Are you sure you want to delete this department?');">
            Delete Dept
        </button>
    </form>

    
    <div id="deptForm" style="display: none;">
        <h3>Department Form</h3>
        <form action="depts" method="post">
            <input type="hidden" id="operation" name="operation">
            <label>ID:</label>
            <input type="number" id="deptid" name="deptid" value="<%= (dept != null) ? dept.getId() : "" %>" required>
            <label>Name:</label>
            <input type="text" id="deptname" name="deptname" value="<%= (dept != null) ? dept.getName() : "" %>" required>
            <label>Location:</label>
            <input type="text" id="deptlocation" name="deptlocation" value="<%= (dept != null) ? dept.getLocation() : "" %>" required>

            <button type="submit">Submit</button>
            <button type="button" onclick="document.getElementById('deptForm').style.display='none'">Cancel</button>
        </form>
    </div>
</body>
</html>
