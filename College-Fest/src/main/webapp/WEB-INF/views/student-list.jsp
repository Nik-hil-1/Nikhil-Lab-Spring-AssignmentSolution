<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
      integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
      crossorigin="anonymous">
      
<title>Student List</title>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">Student Directory</h3>
    <hr>
        <a href="/CollegeFest/students/showFormForAdd" class="btn btn-primary btn-sm mb-3">Add Student</a>
        <a href="/CollegeFest/logout" class="btn btn-primary btn-sm mb-3 mx-auto" style="float: right">Logout</a>
    
    <table class="table table-bordered table-striped">
        <thead class="thead-dark">
            <tr>
                <th>Student_Id</th>
                <th>Name</th>
                <th>Department</th>
                <th>Country</th>
                <th>Action</th>
            </tr>
        </thead> 
        <tbody>
            <c:forEach items="${Students}" var="temp">
                <tr>
                    <td><c:out value="${temp.id}" /></td>
                    <td><c:out value="${temp.name}" /></td>
                    <td><c:out value="${temp.department}" /></td>
                    <td><c:out value="${temp.country}" /></td>
                    <td>
                        <a href="/CollegeFest/students/showFormForUpdate?id=${temp.id}" class="btn btn-info btn-sm">Update</a>
                        <a href="/CollegeFest/students/delete?id=${temp.id}" class="btn btn-danger btn-sm"
                         onclick="if (!(confirm('Are you sure you want to delete this book?'))) return false">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>   
    </table>
</div>
</body>
</html>