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
        <title>Update Student Page</title>
    </head>
    <body>
        <h2>Bravery College Students</h2>
        <h3>Update Student</h3>
        <form action="StudentController" method="get">
            <input type="hidden" name="command" value="UPDATE"/>
            <input type="hidden" name="id" value="${stud.getId()}"/>
            <table>
                <tr>
                    <td><label>Update name:</label></td>
                    <td><input type="text" name="name" value ="${stud.getName()}"required/></td>
                </tr>
                <tr>
                    <td><label>Update surname:</label></td>
                    <td><input type="text" name="surname" required value ="${stud.getSurname()}"/></td>
                </tr>  
                <tr>
                    <td><label>Update email:</label></td>
                    <td><input type="email" name="email" required value ="${stud.getEmail()}"/></td>
                </tr>
                <tr>
                    <td><label>Update Telephone:</label></td>
                    <td><input type="number" name="telephone" required value ="${stud.getTelephone()}"/></td>
                </tr>
                <tr>
                    <td><label></label></td>
                    <td><input type="submit" name="Update Student"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
