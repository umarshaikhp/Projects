package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Bean;
import com.dao.Dao;
import com.daoImpl.DaoImpl;

/**
 * Servlet implementation class Controller
 */


public class Controller1 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String name=request.getParameter("username");
String password=request.getParameter("password");
System.out.println(name+" "+password);
Bean obj=new Bean();
obj.setName(name);
obj.setPassword(password);
Dao  b=new DaoImpl();

b.insert(obj);
	}

}
