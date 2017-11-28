/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account_billing;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

/**
 * FXML Controller class
 *
 * @author user
 */
public class InstallController implements Initializable  {

    JOptionPane jp = new JOptionPane();
    int couneter=0;
    @FXML
    private PasswordField password,con_pwd;
    @FXML
    private TextField name,friend,lnumber,shop_name,shop_add,shop_number,gst_number,gst_prod,uname;
    //INSTALLINH THE DATABASE AND 
     @FXML
    private void installAction(ActionEvent event) throws Exception{
    
		{
			 JPasswordField pf = new JPasswordField();
			 int pwd = JOptionPane.showConfirmDialog(null, pf, "Enter Key", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			 
			 if(!pf.getText().equals("abcdefghijkl12345678"))
			 {
				 if(couneter<4)
				 {
					jp.showMessageDialog(null,"Wrong key","FAILURE",jp.INFORMATION_MESSAGE);	
					couneter++;
				 }
				 else
				 {
					 System.exit(1);
				 }

			 }
			 else
			 {
			try
			{
				if(password.getText().equals(con_pwd.getText()))
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
				Statement stm = c.createStatement();
		
				PreparedStatement ps1  = c.prepareStatement("CREATE TABLE  PASS(NAME VARCHAR2(20),PAS VARCHAR2(20))");
				ps1.executeUpdate();
				PreparedStatement ps2  = c.prepareStatement("insert into pass values(?,?)");
		        	ps2.setString(1,uname.getText());
				ps2.setString(2,password.getText());
				ps2.executeUpdate();
				
				/////create table ShopDetails
				PreparedStatement ps12  = c.prepareStatement("CREATE TABLE  SHOP_DETAILS(NAME VARCHAR2(100),ADDRESS VARCHAR2(100),PHNO NUMBER,gstno number,gst number)");
				ps12.executeUpdate();
				PreparedStatement ps13  = c.prepareStatement("insert into SHOP_DETAILS values(?,?,?,?,?)");
                                ps13.setString(1,shop_name.getText());
				ps13.setString(2,shop_add.getText());
				ps13.setString(3,shop_number.getText());
				ps13.setString(4,gst_number.getText());
				ps13.setString(5,gst_prod.getText());
				ps13.executeUpdate();
				
				PreparedStatement ps  = c.prepareStatement("create table ques(an1 varchar(10),an2 varchar(10),an3 varchar(10))");
				ps.executeUpdate();
				PreparedStatement ps31  = c.prepareStatement("insert into ques values(?,?,?)");
		        	ps31.setString(1,name.getText());
				ps31.setString(2,friend.getText());
				ps31.setString(3,lnumber.getText());
				ps31.executeUpdate();
				
				ps2.executeUpdate();
				PreparedStatement ps3  = c.prepareStatement("CREATE TABLE  ITEMS(name varchar2(50),unit varchar2(50),stock number,sale_price number,purc_price number,mrp number,min_sal number,self_val number,gst_code varchar2(50),tax_cate varchar2(50),cgst number,sgst number,gst number,tax_mrp number,tax_type varchar2(50),sale_dis varchar2(50),purc_dis varchar2(50))");
				ps3.executeUpdate();
                                PreparedStatement ps4  = c.prepareStatement("CREATE TABLE EMP(ID NUMBER,NAME VARCHAR2(20)NOT NULL, DOB DATE NOT NULL, QUAL VARCHAR2(20) NOT NULL,JOB VARCHAR2(20) NOT NULL, SAL NUMBER NOT NULL, PHO NUMBER NOT NULL,ADDRESS VARCHAR2(100))");
				ps4.executeUpdate();
				PreparedStatement ps5  = c.prepareStatement("CREATE TABLE CUSTOMER(NAME VARCHAR(20),TOTALCOST NUMBER,D1 DATE,MOB NUMBER,ADDRESS VARCHAR2(100),GST VARCHAR2(100))");
				ps5.executeUpdate();
				PreparedStatement ps6 = c.prepareStatement("CREATE TABLE BILL(BID NUMBER,NAME VARCHAR2(50),PHNO NUMBER,D1 DATE,NETTOTAL VARCHAR2(50),GST_WITH_TOTAL VARCHAR2(50),COUNT NUMBER,PRIMARY KEY (BID))");
				ps6.executeUpdate();
				PreparedStatement ps7 = c.prepareStatement("CREATE TABLE PBILL(BILLID NUMBER,PAID VARCHAR2(50), PMODE VARCHAR2(50)) ");
				ps7.executeUpdate();
				PreparedStatement ps8 = c.prepareStatement(" CREATE TABLE DAILY(SRNO NUMBER,CusName VARCHAR2(50),ITEMS VARCHAR2(50),QUANTITY NUMBER,UNITS VARCHAR2(50),PRICE NUMBER,TOTAL NUMBER,D1 DATE,HSN_CODE NUMBER,CGST NUMBER,SGST NUMBER) ");
				ps8.executeUpdate();
				//PreparedStatement ps9 = c.prepareStatement("CREATE TABLE E(ID NUMBER,DAY VARCHAR2(50))");
				//ps9.executeUpdate();
				PreparedStatement ps10 = c.prepareStatement("CREATE TABLE PERM(ID VARCHAR2(50),PASS VARCHAR2(50)) ");
				ps10.executeUpdate();
				PreparedStatement ps14 = c.prepareStatement("CREATE TABLE ACCOUNT(NAME VARCHAR2(100),ACCOUNT_NO NUMBER,IFSC VARCHAR2(100),GST_NO VARCHAR2(100),ADDRESS VARCHAR2(50),TEL_NO NUMBER,ACCOUNT_TYPE VARCHAR2(100),STATE VARCHAR2(100),MOB_NO NUMBER,PAN VARCHAR2(100),AADHAR VARCHAR2(100),OWNER VARCHAR2(100),BNAME VARCHAR2(100))");
				ps14.executeUpdate();
				PreparedStatement ps15 = c.prepareStatement("CREATE TABLE TRANSACTION(DT DATE,NAME VARCHAR2(50),PAY_MODE VARCHAR2(50),AMT_PAID NUMBER,NARRATION VARCHAR2(50))");
				ps15.executeUpdate();
					
				jp.showMessageDialog(null,"Project Installed Successfully","SUCCESS",jp.INFORMATION_MESSAGE);	
				c.close();
				stm.close();
				System.exit(0);
				}
				else
				{
					jp.showMessageDialog(null,"Sorry, Please Enter Password & Re-enter Password Must be Same","INFORMATION",jp.ERROR_MESSAGE);
				}
			}
			 
			catch(ClassNotFoundException cnf)
			{
				jp.showMessageDialog(null,cnf,"EXCEPTION",jp.ERROR_MESSAGE);
				System.out.println("Cnf Exception");
			}
			catch(SQLException sql)
			{
				jp.showMessageDialog(null,sql,"EXCEPTION",jp.ERROR_MESSAGE);
			}
			 //String name = jp.showInputDialog(this, "Please Enter Key?");
			 }
		}
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

//    @Override
//    public void start(Stage stage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("Install.fxml"));
//        
//        Scene scene = new Scene(root);
//        
//        stage.setScene(scene);
//        stage.show();
//    }
//    
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        launch(args);
//    }
    
}
