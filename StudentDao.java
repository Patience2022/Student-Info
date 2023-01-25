/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Student;

/**
 *
 * @author patce
 */
public class StudentDao {
    private Connection con;
    private PreparedStatement pst;
    private ResultSet rs;
    private String query;

    public StudentDao(Connection con) {
        this.con = con;
    }
    
    public List<Student> getStudents() throws Exception
    {
        List<Student> students = new ArrayList<>();
        query = "select * from student order by surname";
        pst = con.prepareStatement(query);
        rs = pst.executeQuery();
        while(rs.next())
        {
            int	id = rs.getInt("id");
            String name = rs.getString("name");
            String surname = rs.getString("surname");
            String email = rs.getString("email");
            String telephone = rs.getString("telephone");
            Student student = new Student(id, name, surname, email, telephone);
            students.add(student);
        }
        
        return students;
    }

    public boolean addStudent(Student student) throws Exception
    {
        boolean result = false;
        query = "insert into student (name, surname, email, telephone) values(?,?,?,?)";
        pst = con.prepareStatement(query);
        pst.setString(1, student.getName());
        pst.setString(2, student.getSurname());
        pst.setString(3, student.getEmail());
        pst.setString(4, student.getTelephone());
        pst.execute();
        
        result = true;
        
        return result;
    }

    public boolean deleteStudent(int id)throws Exception
    {
        boolean result = false;
        query = "delete from student where id =?";
        pst = con.prepareStatement(query);
        pst.setInt(1, id);
        pst.execute();
        result = true;
        
        return result;
    }

    public Student getStudent(int id) throws Exception 
    {
       Student student = null;
       query = "select * from student where id =?";
       pst = con.prepareStatement(query);
       pst.setInt(1, id);
       rs = pst.executeQuery();
        while(rs.next())
        {
            id = rs.getInt("id");
            String name = rs.getString("name");
            String surname = rs.getString("surname");
            String email = rs.getString("email");
            String telephone = rs.getString("telephone");
            student = new Student(id, name, surname, email, telephone);
            
        }
       return student;
    }

    public boolean updateStudent(Student student)throws Exception
    {
        boolean success = false;
        query = "update student set name =?, surname =?, email=?, telephone=? where id =?";
        pst = con.prepareStatement(query);
        pst.setString(1, student.getName());
        pst.setString(2, student.getSurname());
        pst.setString(3, student.getEmail());
        pst.setString(4, student.getTelephone());
        pst.setInt(5, student.getId());
        pst.execute();
        success = true;
        return success;
    }
    
}
