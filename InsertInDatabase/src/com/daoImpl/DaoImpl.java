package com.daoImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bean.Bean;
import com.dao.Dao;

import connectionToDb.ConnectionToDb;





public class DaoImpl implements Dao {

	public void insert(Bean obj) {
Connection con=null;
PreparedStatement ps=null;
try {
	con=ConnectionToDb.db();
	ps=con.prepareStatement("insert into jsoft values(?,?)");
	ps.setString(1, obj.getName());
	ps.setString(2, obj.getPassword());
	ps.executeUpdate();
	ps.close();

	
} catch (Exception e) {
	e.printStackTrace();

}
	}

}
