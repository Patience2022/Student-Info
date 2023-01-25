<%-- 
    Document   : index
    Created on : Jan 25, 2023, 8:58:04 AM
    Author     : patce
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
       <form>
            <div class="wrapper">
                <div class="header">
                    <h2>Bravery College Students</h2>
                    <h3>List of Students</h3>
                    <input type="button" value="Add Student" onclick="window.location.href='addStudent.jsp';return false;"/>
                    <br/>
                    <br/>
                </div>
                <div class="container">
                    <div class="content">
                        <table border="1">
                            <tr>
                                <th>ID number</th>
                                <th>Name</th>
                                <th>Surname</th>
                                <th>Email</th>
                                <th>Telephone</th>
                                <th>Action</th>
                            </tr> 
                            <c:forEach var="student" items="${stud}">
                                <c:url var="updateLink" value="StudentController">
                                    <c:param name="command" value="LOAD"/>
                                    <c:param name="id" value="${student.id}"/>
                                </c:url>
                                <c:url var="deleteLink" value="StudentController">
                                    <c:param name="command" value="DELETE"/>
                                    <c:param name="id" value="${student.id}"/>
                                </c:url>                               
                                <tr>
                                    <td>${student.id}</td>
                                    <td>${student.name}</td>
                                    <td>${student.surname}</td>
                                    <td>${student.email}</td>
                                    <td>${student.telephone}</td>
                                    <td> <a href="${updateLink}">Update </a>
                                    |<a href="${deleteLink}">Delete </a></td>
                                </tr>  
                            </c:forEach>                
                        </table>  
                    </div>
                </div>
            </div>
        </form>
    </body>
</html>
