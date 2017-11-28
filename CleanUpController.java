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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javax.swing.JOptionPane;
/**
 * FXML Controller class
 *
 * @author ACER
 */
public class CleanUpController implements Initializable {
    @FXML
    private CheckBox items,employee,customer,bill,pbill,accounts,transaction,daily;
    int t = 0;
    JOptionPane jp = new JOptionPane();
    @FXML
    private void cleanupAction(ActionEvent Event) throws SQLException, ClassNotFoundException{
        try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			Statement stm = c.createStatement();
			t=0;
				///item table Cleanup
				if(items.isSelected())
				{
					PreparedStatement ps  = c.prepareStatement("delete from item");
					ps.executeQuery();
				 }
				
				///customer table Cleanup
				if(customer.isSelected())
				{
					PreparedStatement ps1  = c.prepareStatement("delete from customer");
					ps1.executeQuery();
				}
			
				///Employee Table Cleanup 
				if(employee.isSelected())
				{
					ArrayList<Integer> ar = new ArrayList<Integer>();
					PreparedStatement ps11 = c.prepareStatement("select id from emp");
					int lst_num;
					ResultSet rs = ps11.executeQuery();
					while(rs.next())
					{
						ar.add(rs.getInt("id"));
					}
				    Collections.sort(ar);
				    if(ar.size()>0)
				    {
					lst_num = ar.get(ar.size()-1);
				    }
					else
					{
						lst_num=0;
					}
					
				    for(int i = 1;i <= lst_num;i++)
				    {
				    	PreparedStatement ps12 = c.prepareStatement("drop table e"+i);
				    	
				    	ps12.executeQuery();
				    }

					PreparedStatement ps1  = c.prepareStatement("delete from emp");
					ps1.executeQuery();
				}
				
			
				///Daily Table Cleanup 
				if(daily.isSelected())
				{
					PreparedStatement ps5  = c.prepareStatement("delete from daily");
					ps5.executeQuery(); 

				}
						    
				///Bill Table Cleanup 
				if(bill.isSelected())
				{
					PreparedStatement ps3  = c.prepareStatement("delete from bill");
					ps3.executeQuery();
				}  
                                //pbill table Cleanup
				if(pbill.isSelected())
				{
					PreparedStatement ps4  = c.prepareStatement("delete from pbill");
					ps4.executeQuery();
				}
                                 //Accounts table Cleanup
				if(accounts.isSelected())
				{
					PreparedStatement ps4  = c.prepareStatement("delete from accounts");
					ps4.executeQuery();
				}
                                 //Transaction table Cleanup
				if(transaction.isSelected())
				{
					PreparedStatement ps4  = c.prepareStatement("delete from transaction");
					ps4.executeQuery();
				}
				jp.showMessageDialog(null,"Cleanup Successfull");
			c.close();
			stm.close();
			}
			
			catch(ClassNotFoundException cnf)
			{
				cnf.printStackTrace();
				System.out.println("Cnf Exception");
			}
			catch(SQLException sql)
			{
				sql.printStackTrace();
				jp.showMessageDialog(null,sql,"EXCEPTION",jp.ERROR_MESSAGE);
			}
			
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
