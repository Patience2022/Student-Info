/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.DBCon;
import dao.StudentDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Student;

/**
 *
 * @author patce
 */
@WebServlet(name = "StudentController", urlPatterns = {"/StudentController"})
public class StudentController extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String command = request.getParameter("command");
        
        if(command == null)
        {
            command = "LIST";
        }
        try
        {
            switch(command)
            {
                case "LIST":
                    listStudents(request, response);
                    break;
                case "ADD":
                    addStudent(request, response);
                    break;
                case "DELETE":
                    deleteStudent(request, response);
                    break;
                case "LOAD":
                    loadStudent(request, response);
                    break;
                case "UPDATE":
                    updateStudent(request, response);
                    break;
                default:
                    listStudents(request, response);
                    break;
                        
            }
        }
        catch(Exception e){throw new ServletException(e);}
    }


    private void listStudents(HttpServletRequest request, HttpServletResponse response) throws Exception 
    {
        PrintWriter out = response.getWriter();
        StudentDao dao = new StudentDao(DBCon.getConnection());
        List<Student> students = dao.getStudents();
        if(!students.isEmpty())
        {
            
            request.setAttribute("stud", students);
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }
        else
        {
           out.println("There is no data available at this moment.");
        }
        
    }

    private void addStudent(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone");
        
        StudentDao dao = new StudentDao(DBCon.getConnection());
        Student student = new Student(name, surname, email, telephone);
        boolean result = dao.addStudent(student);
        if(result)
        {
           listStudents(request, response); 
        }
        else
        {
            throw new ServletException();
        }
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        int id = Integer.parseInt(request.getParameter("id"));
        StudentDao dao = new StudentDao(DBCon.getConnection());
        boolean result = dao.deleteStudent(id);
        if(result)
        {
           listStudents(request, response); 
        }
        else
        {
            throw new ServletException();
        }
    }

    private void loadStudent(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        int id = Integer.parseInt(request.getParameter("id"));
        StudentDao dao = new StudentDao(DBCon.getConnection());
        Student student = dao.getStudent(id); 
        if(student !=null)
        {
            request.setAttribute("stud", student);
            RequestDispatcher dispatcher = request.getRequestDispatcher("updateStudent.jsp");
            dispatcher.forward(request, response);           
        }
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone");
        
        StudentDao dao = new StudentDao(DBCon.getConnection());
        Student student = new Student(id,name, surname, email, telephone);
        boolean success = dao.updateStudent(student);
        if(success)
        {
           listStudents(request, response); 
        }
        else
        {
            throw new ServletException();
        }   
    }


}
