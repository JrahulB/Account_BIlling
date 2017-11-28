/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account_billing;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
	 
	public class Backup {
		int i;
	  private Connection connection = null;
	 
	  public Backup(String database, String user, String password)
	    throws ClassNotFoundException, SQLException {
	 
	        // Create MySQL database connection
		  Class.forName("oracle.jdbc.driver.OracleDriver");
		 connection =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
	  }
	  
	  java.text.SimpleDateFormat sdf =  new java.text.SimpleDateFormat("dd-MMM-yyyy");
	    Date date1 = new Date(System.currentTimeMillis());
	   
	  public void generateXls(String tablename, String filename, String backupPath,String fdate,String date)
	    throws SQLException, FileNotFoundException, IOException {
	 
	    // Create new Excel workbook and sheet
	    HSSFWorkbook xlsWorkbook = new HSSFWorkbook();
	    HSSFSheet xlsSheet = xlsWorkbook.createSheet();
	    short rowIndex = 0;
	    // Execute SQL query
	    PreparedStatement stmt =connection.prepareStatement("select * from "+tablename+" where D1 between '"+fdate+"'and '"+date+"'");
	    ResultSet rs = stmt.executeQuery();
	    // Get the list of column names and store them as the first
	    // row of the spreadsheet.
	    ResultSetMetaData colInfo = rs.getMetaData();
	    List<String> colNames = new ArrayList();
	    HSSFRow titleRow = xlsSheet.createRow(rowIndex++);
	    for ( i = 1; i <= colInfo.getColumnCount(); i++){
	      colNames.add(colInfo.getColumnName(i));
	      titleRow.createCell((short) (i-1)).setCellValue(
	        new HSSFRichTextString(colInfo.getColumnName(i)));
	      xlsSheet.setColumnWidth((short) (i-1), (short) 4000);
	    }
	 
	    // Save all the data from the database table rows
	    while (rs.next()) {
	      HSSFRow dataRow = xlsSheet.createRow(rowIndex++);
	      short colIndex = 0;
	      for (String colName : colNames) {
	        dataRow.createCell(colIndex++).setCellValue(
	          new HSSFRichTextString(rs.getString(colName)));
	      }
	    }
	    // Write to disk
	    File file = new File(backupPath,filename+"_"+ sdf.format(date1)+""+".xls");
	    if(!file.exists())
	    {
	    	file.createNewFile();
	    }
	    xlsWorkbook.write(new FileOutputStream(file));
	   
	  }
	  // Close database connection
	  public void close() throws SQLException {
	    connection.close();
	
	  }
}
