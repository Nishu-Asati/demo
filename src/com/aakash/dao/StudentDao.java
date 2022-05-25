package com.aakash.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.aakash.beans.Student;

public class StudentDao {
public static int saveStudent(Student st)
{
	int save=0;
	try {
		Connection con=DatabaseCon.getCon();
		PreparedStatement ps=con.prepareStatement("insert into fee_student(name,email,gender,course,fee,paid,due,address,contact)"
				+ "values(?,?,?,?,?,?,?,?,?)");
		ps.setString(1,st.getName());
		ps.setString(2,st.getEmail());
		ps.setString(3,st.getGender());
		ps.setString(4,st.getCourse());
		ps.setInt(5,st.getFee());
		ps.setInt(6,st.getPaid());
		ps.setInt(7,st.getDue());
		ps.setString(8,st.getAddress());
		ps.setString(9,st.getContact());
		save=ps.executeUpdate();
		con.close();
	} catch (Exception e) {
	 e.printStackTrace();
	}
	return save;
}
public static int updateStudent(Student st)
{
	int update=0;
	try {
		Connection con=DatabaseCon.getCon();
		PreparedStatement ps=con.prepareStatement("update fee_student set name=?,email=?,gender=?,course=?,fee=?,paid=?,due=?,address=?,contact=? where rollno=?");
		ps.setString(1,st.getName());
		ps.setString(2,st.getEmail());
		ps.setString(3,st.getGender());
		ps.setString(4,st.getCourse());
		ps.setInt(5,st.getFee());
		ps.setInt(6,st.getPaid());
		ps.setInt(7,st.getDue());
		ps.setString(8,st.getAddress());
		ps.setString(9,st.getContact());
		ps.setInt(10,st.getRollno());
		update=ps.executeUpdate();
		con.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return update;
}
public static int deleteStudent(int rollno)
{
	int delete=0;
	try {
		Connection con=DatabaseCon.getCon();
		PreparedStatement ps=con.prepareStatement("delete from fee_student where rollno=?");
		ps.setInt(1,rollno);
		delete=ps.executeUpdate();
		con.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return delete;
}
public static int deleteStudentByName(String name)
{
	int delete=0;
	try {
		Connection con=DatabaseCon.getCon();
		PreparedStatement ps=con.prepareStatement("delete from fee_student where name=?");
		ps.setString(1,name);
		delete=ps.executeUpdate();
		con.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return delete;
}
public static List<Student> getAllStudent()
{
ArrayList<Student> list=new ArrayList<>();
try {
	Connection con=DatabaseCon.getCon();
	PreparedStatement ps=con.prepareStatement("select * from fee_student");
	ResultSet rs=ps.executeQuery();
	while (rs.next()) {
		Student st=new Student();
		st.setName(rs.getString("name"));
		st.setEmail(rs.getString("email"));
		st.setAddress(rs.getString("address"));
		st.setContact(rs.getString("contact"));
		st.setCourse(rs.getString("course"));
		st.setGender(rs.getString("gender"));
		st.setFee(rs.getInt("fee"));
		st.setDue(rs.getInt("due"));
		st.setPaid(rs.getInt("paid"));
		st.setRollno(rs.getInt("rollno"));
		list.add(st);
	}
	con.close();
} catch (Exception e) {
	e.printStackTrace();
}
return list;
}
public static List<Student> getDues()
{
List<Student> list=new ArrayList<>();
try {
	Connection con=DatabaseCon.getCon();
	PreparedStatement ps=con.prepareStatement("select * from fee_student where due>0");
	ResultSet rs=ps.executeQuery();
	while (rs.next()) {
		Student st=new Student();
		st.setName(rs.getString("name"));
		st.setEmail(rs.getString("email"));
		st.setAddress(rs.getString("address"));
		st.setContact(rs.getString("contact"));
		st.setCourse(rs.getString("course"));
		st.setGender(rs.getString("gender"));
		st.setFee(rs.getInt("fee"));
		st.setDue(rs.getInt("due"));
		st.setPaid(rs.getInt("paid"));
		st.setRollno(rs.getInt("rollno"));
		list.add(st);

	}
	con.close();
} catch (Exception e) {
	e.printStackTrace();
}
return list;
}
public static Student getStudentByRollNo(int rollno)
{
	Student st=new Student();
	try {
		Connection con=DatabaseCon.getCon();
		PreparedStatement ps=con.prepareStatement("select * from fee_student where rollno=?");
		ps.setInt(1,rollno);
		ResultSet rs=ps.executeQuery();
		if (rs.next()) {
			st.setName(rs.getString("name"));
			st.setEmail(rs.getString("email"));
			st.setAddress(rs.getString("address"));
			st.setContact(rs.getString("contact"));
			st.setCourse(rs.getString("course"));
			st.setGender(rs.getString("gender"));
			st.setFee(rs.getInt("fee"));
			st.setDue(rs.getInt("due"));
			st.setPaid(rs.getInt("paid"));
			st.setRollno(rs.getInt("rollno"));
			
		}
		con.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return st;
}
}
