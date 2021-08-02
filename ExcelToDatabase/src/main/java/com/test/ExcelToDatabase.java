package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelToDatabase {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		LocalDateTime startTime = LocalDateTime.now();
		System.out.println(startTime);
		PreparedStatement preStatement = null;
		// try {
		String filename = "C:\\Users\\umar shaikh\\Desktop\\Book5.xlsx";
		try (FileInputStream file = new FileInputStream(new File(filename))) {

			XSSFWorkbook xssfWorkbook = new XSSFWorkbook(file);
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			con.setAutoCommit(false);
			String sql = "insert into employees values(?,?,?,?,?,?)";

			preStatement = con.prepareStatement(sql);
			XSSFSheet sheetAt = xssfWorkbook.getSheetAt(0);

			int rowCount = sheetAt.getPhysicalNumberOfRows();
			
			for (int i = 1; i < rowCount; i++) {
				XSSFRow row = sheetAt.getRow(i);
				int cell = row.getPhysicalNumberOfCells();
				

				int studentId = (int) (row.getCell(0).getNumericCellValue());
				String StudentName = row.getCell(1).getStringCellValue();
				String studentSchool = row.getCell(2).getStringCellValue();
				String studentClass = row.getCell(3).getStringCellValue();
				int studentmarks = (int) (row.getCell(4).getNumericCellValue());
				int studentresult = (int) (row.getCell(5).getNumericCellValue());
				preStatement.setInt(1, studentId);
				preStatement.setString(2, StudentName);
				preStatement.setString(3, studentSchool);
				preStatement.setString(4, studentClass);
				preStatement.setInt(5, studentmarks);
				preStatement.setInt(6, studentresult);

				preStatement.addBatch();

			}
			
			int[] row = preStatement.executeBatch();
			System.out.println(row.length);
			con.commit();
			LocalDateTime endTime = LocalDateTime.now();
			System.out.println(endTime);

//System.out.println("||"+getCellValue(cell));

			xssfWorkbook.close();
			file.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String getCellValue(XSSFCell cell) {
		switch (cell.getCellType()) {
		case NUMERIC:
			return String.valueOf(cell.getNumericCellValue());
		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
		case STRING:
			return cell.getStringCellValue();
		default:
			return cell.getStringCellValue();

		}

	}
}
