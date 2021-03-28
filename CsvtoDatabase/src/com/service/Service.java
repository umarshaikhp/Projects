package com.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.utils.ConnectionToDb;

public class Service {
	private static Connection con = null;
	static {
		System.out.println("getting connection-------------------");
		con=ConnectionToDb.get_Connection();
		System.out.println("got connection-----------------------"+con);
	}
	
public static void main(String[] args) {
	PreparedStatement ps=null;
	BufferedReader bReader=null;
	String sql = " INSERT INTO Employeepeople(name,city,salary,designation) VALUES(?,?,?,?) ";


	{ 
	        
			try {
				
			File file = new File("D:/ExportInCsv.csv");
			System.out.println(file.exists());
			bReader = new BufferedReader(new FileReader("D:/ExportInCsv.csv"));
			

			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			}
	        String line = ""; 
	        try {
	        	line = bReader.readLine();
	        	System.out.println(line);
				while ((line = bReader.readLine()) != null) {
				    try {
				    	System.out.println(line);


				        if (line != null) 
				        {
				            String[] array = line.split(",+");
				            System.out.println(array.length);

//	                    for(String result:array)
//	                    {
//	                        System.out.println(result);
 //Create preparedStatement here and set them and excute them
				        
						try {
							ps = con.prepareStatement(sql);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				         ps.setString(1,array[0]);
				         ps.setString(2,array[1]);
				         ps.setString(3,array[2]);
				         ps.setString(4,array[3]);
				         ps.executeLargeUpdate();
				         ps. close();
   //Assuming that your line from file after split will folllow that sequence

				            
				        } 
				    } catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				    finally
				    {
				       if (bReader == null) 
				        {
				            try {
								bReader.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
				        }
				    }


}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}}
