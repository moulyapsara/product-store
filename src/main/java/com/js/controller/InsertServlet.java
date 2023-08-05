package com.js.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.js.dao.customerCRUD;
import com.js.dto.customer;

@WebServlet("/register")
public class InsertServlet extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 customer c=new customer();
	 int id=Integer.parseInt(req.getParameter("id"));
	 c.setId(id);
	 String name=req.getParameter("name");
	 c.setName(name);
	 String email=req.getParameter("email");
	 c.setEmail(email);
	 int password=Integer.parseInt(req.getParameter("pwd"));
	 c.setPassword(password);
	 long phone=Long.parseLong(req.getParameter("phone"));
	 c.setPhone(phone);
	 
	 int res=customerCRUD.insertCustomer(c);
	 RequestDispatcher rd=req.getRequestDispatcher("result.jsp");
	 if (res>0) {
		req.setAttribute("msg", "Inserted Successfully");
		rd.forward(req, resp);
	} else {
         req.setAttribute("msg", "Failed to Insert");
         rd.forward(req, resp);
	}
}
}
