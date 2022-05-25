package com.aakash.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aakash.dao.StudentDao;
@WebServlet("/DeleteStudent")
public class DeleteStudent extends HttpServlet{
  @Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int rollno=Integer.parseInt(req.getParameter("rollno"));
	int delete=StudentDao.deleteStudent(rollno);
	resp.sendRedirect("ViewStudent");
}
}
