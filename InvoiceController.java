/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account_billing;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javax.swing.JLabel;

/**
 * FXML Controller class
 *
 * @author ACER
 */
public class InvoiceController implements Initializable {
    StringBuilder name ;
    @FXML
    private  Pane pane;
    @FXML
    private Label header,add,mob,divider,date,bill,gst_no,divider1,tablelabel;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // adding name address and mob number from database to invoice
        try{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
					Statement stm = c.createStatement();
					PreparedStatement ps2 = c.prepareStatement("select * from shop_details ");
					ResultSet rs2 = ps2.executeQuery();
					while(rs2.next()){
					header.setText(rs2.getString("name"));
					add.setText(rs2.getString("address"));
					mob.setText(rs2.getString("phno"));
				}
					stm.close();
				    c.close();
				} catch (Exception e) {
				e.printStackTrace();
				}
                               //set Divider line 
                               divider.setText("----------------------Tax Invoice----------------------");
                 //set current Date to date label 
                 Date date1 = new Date(System.currentTimeMillis());
                 date.setText(date1.toString());
                //set bill number to bill label
		 bill.setText("billno");
		 try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
				Statement stm = c.createStatement();
				PreparedStatement ps2 = c.prepareStatement("select * from shop_details ");
				ResultSet rs2 = ps2.executeQuery();
				while(rs2.next()){
                                //set gst number of shop from shop_details table to gst label    
				gst_no.setText(rs2.getString("gstno"));
				}
				stm.close();
		    c.close();
		} catch (Exception e) {
		e.printStackTrace();
		}
                 divider1.setText("-----------------------------------------------------------");
                 //bill table for printing
                 StringBuilder Bill = new StringBuilder();
                 try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			Statement stm = c.createStatement();
//			PreparedStatement ps1 = c.prepareStatement("select * from daily where srno='"+billno+"'and cusname='"+cus1+"' ");
//			ResultSet rs = ps1.executeQuery();
			
			   Bill.append("<HTML><head><title></title></head><body>");
			   
			   Bill.append("<table style=\"border:none\" cellpadding=\"12\" >");
			  
					   
			   Bill.append("<tr>");
			   Bill.append("<th>Particulars</th>");
			   Bill.append("<th>Quantity</th>");
			   Bill.append("<th>Price</th>");
			   Bill.append("<th>Total</th>");
			   Bill.append("</tr>");			
//			   while(rs.next()){
//
//				Bill.append("<tr>");
//				Bill.append("<td> <font face=\"WildWest\" size=\"4\">"+rs.getString("Items")+"</font></td>");
//				Bill.append("<td><font face=\"WildWest\" size=\"4\">"+rs.getString("quantity")+"</font></td>");
//				Bill.append("<td><font face=\"WildWest\" size=\"4\">"+rs.getString("price")+"</font></td>");
//				Bill.append("<td><font face=\"WildWest\" size=\"4\">"+rs.getString("total")+"</font></td>");
//				Bill.append("</tr>");
//			   }
				
					//name.append("</HTML>");
			   Bill.append("</table>");
			   Bill.append("</body></HTML>");
			  
           
                            Bill.append("</HTML>");
                 }
                        catch(ClassNotFoundException cnf)
			{
                            cnf.printStackTrace();
                            System.out.println("Cnf Exception");
			}
			catch(SQLException sql)
			{
                            sql.printStackTrace();
                            System.out.println("SQL Exception");
			}
                 /////////////////////////////////////////////////////////////////////
                 try{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
					Statement stm = c.createStatement();
					PreparedStatement ps2 = c.prepareStatement("select * from shop_details ");
					ResultSet rs2 = ps2.executeQuery();
				    name = new StringBuilder();
					name.append("<HTML><head><title></title></head><body>");
					while(rs2.next()){
					name.append(" &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp <font face=\"WildWest\" size=\"4\">"+rs2.getString("name")+"</font><br>");
					name.append("<font face=\"WildWest\" size=\"4\">"+rs2.getString("address")+"</font><br>");
					name.append(" &nbsp &nbsp &nbsp &nbsp &nbsp  &nbsp &nbsp &nbsp <font face=\"WildWest\" size=\"4\">"+rs2.getString("phno")+"</font>");
				}
					name.append("</body></HTML>");
					stm.close();
				    c.close();
				} catch (Exception e) {
				e.printStackTrace();
				}
                 tablelabel.setText(name.toString());
    
}
}
