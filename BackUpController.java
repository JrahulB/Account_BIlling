/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account_billing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ACER
 */
public class BackUpController implements Initializable {
    private String datePattern = "yyyy-MM-dd";
    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);
    public Object stringToValue(String text) throws ParseException {
        return dateFormatter.parseObject(text);
    }
        public String valueToString(Object value) throws ParseException {
        if (value != null) {
            Calendar cal = (Calendar) value;
            return dateFormatter.format(cal.getTime());
        }
         
        return "";
    }
    @FXML
    private CheckBox items,customer,bill,pbill,employee,accounts,transaction,daily;
    @FXML
    private TextField path;
    @FXML
    private DatePicker fdate,tdate;
    int t = 0;
    File backupPath;
    JOptionPane jp = new JOptionPane();
    @FXML
     private void backupAction(ActionEvent event) throws SQLException, ClassNotFoundException, IOException, FileNotFoundException{
        try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			Statement stm = c.createStatement();
			t=0;
			
				if(items.isSelected())
				{
					BackupItem b =new BackupItem("xe", "system", "root");
				    try {
						b.generateXls("items", "items", backupPath.toString());
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				     // jp.showMessageDialog(mainFrame,"Backup Successfull");
				      b.close();
				    }
				
				///customer table backup
				if(customer.isSelected())
                                {
					Backup b =new Backup("xe", "system", "root");
				    try {
						b.generateXls("customer", "customer", backupPath.toString(),((TextField)fdate.getEditor()).getText(),((TextField)tdate.getEditor()).getText());
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				    b.close();
				}
			
				///Employee Table Backup 
				if(employee.isSelected())
				{
					BackupItem b =new BackupItem("xe", "system", "root");
				    try {
						b.generateXls("emp", "employee", backupPath.toString());
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				    b.close();
				    
				}
				
			
				///Daily Table Backup 
				if(daily.isSelected())
                                {
					Backup b =new Backup("xe", "system", "root");
				    try {
						b.generateXls("daily", "daily", backupPath.toString(),((TextField)fdate.getEditor()).getText(),((TextField)tdate.getEditor()).getText());
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				    b.close();
				   
				}
						    
				///Bill Table Backup 
				if(bill.isSelected())
				{
					Backup b =new Backup("xe", "system", "root");
				    try {
						b.generateXls("bill", "bill", backupPath.toString(),((TextField)fdate.getEditor()).getText(),((TextField)tdate.getEditor()).getText());
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				    b.close();
				}  
                                //pbill table Backup
				if(pbill.isSelected())
				{
					BackupItem b1 =new BackupItem("xe", "system", "root");
				    try {
						b1.generateXls("pbill", "pbill", backupPath.toString());
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				     b1.close();
				}
                                ///Accounts Table Backup 
				if(employee.isSelected())
				{
					BackupItem b =new BackupItem("xe", "system", "root");
				    try {
						b.generateXls("accounts", "accounts", backupPath.toString());
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				    b.close();
				    
				}
                                ///Transaction Table Backup 
				if(bill.isSelected())
				{
					Backup b =new Backup("xe", "system", "root");
				    try {
						b.generateXls("transaction", "transaction", backupPath.toString(),((TextField)fdate.getEditor()).getText(),((TextField)tdate.getEditor()).getText());
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				    b.close();
				} 
				jp.showMessageDialog(null,"Backup Successfull");
			
			c.close();
			stm.close();
			}
			
			catch(ClassNotFoundException cnf)
			{
				System.out.println("Cnf Exception");
			}
			catch(SQLException sql)
			{
				jp.showMessageDialog(null,sql,"EXCEPTION",jp.ERROR_MESSAGE);
			}
			 
     }
     @FXML
    private void browseAction(ActionEvent event) throws Exception{
        JFileChooser chooser = new JFileChooser(); 
			chooser.setCurrentDirectory(new java.io.File("."));
		    chooser.setDialogTitle("Select directory to backup");
		    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		    //
		    // disable the "All files" option.
		    //
		    chooser.setAcceptAllFileFilterUsed(false);
		    //    
		    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) { 
		      backupPath = chooser.getSelectedFile();
		      }
		    else {
		      System.out.println("No Selection ");
		      }
			path.setText(backupPath.toString());
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      //set date Pattern to FromDate
      fdate.setConverter(new StringConverter<LocalDate>() {
     String pattern = "dd-MMM-yyyy";
     DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

     {
         fdate.setPromptText(pattern.toLowerCase());
     }

     @Override public String toString(LocalDate date) {
         if (date != null) {
             return dateFormatter.format(date);
         } else {
             return "";
         }
     }

     @Override public LocalDate fromString(String string) {
         if (string != null && !string.isEmpty()) {
             return LocalDate.parse(string, dateFormatter);
         } else {
             return null;
         }
     }
 });
      //set date format to ToDate datepicker
      tdate.setConverter(new StringConverter<LocalDate>() {
     String pattern = "dd-MMM-yyyy";
     DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

     {
         tdate.setPromptText(pattern.toLowerCase());
     }

     @Override public String toString(LocalDate date) {
         if (date != null) {
             return dateFormatter.format(date);
         } else {
             return "";
         }
     }

     @Override public LocalDate fromString(String string) {
         if (string != null && !string.isEmpty()) {
             return LocalDate.parse(string, dateFormatter);
         } else {
             return null;
         }
     }
 });
    }    
    
}
