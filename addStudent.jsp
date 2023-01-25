<%-- 
    Document   : addStudent
    Created on : Jan 25, 2023, 11:30:11 AM
    Author     : patce
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Student Page</title>
    </head>
    <body>
        <h2>Bravery College Students</h2>
        <h3>Add new Student</h3>
        <form action="StudentController" method="get">
            <input type="hidden" name="command" value="ADD"/>
            <table>
                <tr>
                    <td><label>Enter name:</label></td>
                    <td><input type="text" name="name" required/></td>
                </tr>
                <tr>
                    <td><label>Enter surname:</label></td>
                    <td><input type="text" name="surname" required/></td>
                </tr>  
                <tr>
                    <td><label>Enter email:</label></td>
                    <td><input type="email" name="email" required/></td>
                </tr>
                <tr>
                    <td><label>Enter Telephone:</label></td>
                    <td><input type="number" name="telephone" required/></td>
                </tr>
                <tr>
                    <td><label></label></td>
                    <td><input type="submit" name="Add new Student"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
