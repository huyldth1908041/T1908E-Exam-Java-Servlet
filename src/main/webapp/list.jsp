<%@ page import="com.t1908e.exam_wad.entity.Employee" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: luuhu
  Date: 5/21/2021
  Time: 7:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Employee> employeeList = (List<Employee>)  request.getAttribute("list");
%>
<html>
<head>
    <title>List</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<h1 class="text-center">List Employee</h1>\
<div class="container">
    <div class="row">
        <a href="/employee/create">Create new</a>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Full name</th>
                <th scope="col">Birthday</th>
                <th scope="col">Address</th>
                <th scope="col">Position</th>
                <th scope="col">Department</th>
            </tr>
            </thead>
            <tbody>
            <%for (int i = 0; i < employeeList.size(); i++) { %>
            <tr>
                <th scope="row"><%=employeeList.get(i).getFullName()%>
                </th>
                <th scope="row"><%=employeeList.get(i).getBirthDay()%>
                <th scope="row"><%=employeeList.get(i).getAddress()%>
                <th scope="row"><%=employeeList.get(i).getPosition()%>
                <th scope="row"><%=employeeList.get(i).getDepartment()%>
            </tr>
            <%}%>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
