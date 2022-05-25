package com.aakash.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aakash.dao.AccountantDao;
@WebServlet("/DeleteAccountant")
public class DeleteAccountant extends HttpServlet{
  @Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html");
	int id=Integer.parseInt(req.getParameter("id"));
	int delete=AccountantDao.deleteAccountant(id);
	resp.sendRedirect("ViewAccountant");
}
}
