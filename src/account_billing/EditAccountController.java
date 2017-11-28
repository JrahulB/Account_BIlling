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
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class EditAccountController implements Initializable {
 @FXML
    private Button load,change;
 @FXML
    private TextField name,acc_no,ifsc,gst_no,address,tel_no,mob_no,pan,aadhar,bname;
  @FXML
    private ComboBox acc_type,owner,state ;
      @FXML
      int t=0;
     
      JOptionPane jp = new JOptionPane();
     
    /**
     * Initializes the controller class.
     */
    @FXML
private void loadactinPerformed(ActionEvent event) throws SQLException, ClassNotFoundException{
   try
			{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
				Statement stm = c.createStatement();
                                int t = 0;
				ResultSet rs = stm.executeQuery("select * from account where name='"+name.getText()+"'");
				while(rs.next())
				{	
					t=1;	
		
			   
					
			                name.setText(rs.getString("NAME"));
                                        acc_no.setText(rs.getString("ACCOUNT_NO"));
                                        owner.getSelectionModel().select(rs.getString("OWNER"));
					ifsc.setText(rs.getString("IFSC"));
				        gst_no.setText(rs.getString("GST_NO"));
					address.setText(rs.getString("ADDRESS"));
					tel_no.setText(rs.getString("TEL_NO"));
                                        acc_type.getSelectionModel().select(rs.getString("ACC_TYPE"));
                                        mob_no.setText(rs.getString("MOB_NO"));
                                        pan.setText(rs.getString("PAN"));
                                        state.getSelectionModel().select(rs.getString("STATE"));
                                        aadhar.setText(rs.getString("AADHAR"));
                                        bname.setText(rs.getString("BNAME"));
                                       
                    
				}
                                
                                if(t==0)
				{
					jp.showMessageDialog(null,"Sorry, No Such Record exisits","INFORMATION",jp.ERROR_MESSAGE);
					t=0;
				}
		        	c.close();
				stm.close();
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
  
}
//comboBox Action     
                    @FXML
                    private void handleUnitComboBoxAction(ActionEvent event) {
                   state.getSelectionModel().getSelectedItem();
                   acc_type.getSelectionModel().getSelectedItem();
                   acc_type.getItems().addAll("Supplier Account", "Customer Accout", "Expense Account","Asset Account","Loan Account","Other Account","Capital Bank Account");
                   acc_type.getSelectionModel().select("Supplier Account");
                   owner.getSelectionModel().getSelectedItem();
                   owner.getItems().addAll("Self", "Other");
                   

                    }
          
               
                    
 @FXML
private void changeactinPerformed(ActionEvent event) throws SQLException, ClassNotFoundException{
    	              try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
				Statement stm = c.createStatement();
				if(mob_no.getText().length()!=10)
				jp.showMessageDialog(null,"Phone Number Must Have 10 Digits","INFORMATION",jp.ERROR_MESSAGE);
				//else
				//{
					ResultSet rs1 = stm.executeQuery("select * from account where name='"+name.getText()+"'");
					while(rs1.next())
					{	
                                            t = 1;
					}
					if(t==1)
					{
						t=0;
						if((name.getText()).length()!=0)
						{
							PreparedStatement ps=c.prepareStatement ("Update account set name=? where name='"+name.getText()+"'");	
							ps.setString(1,name.getText());	ps.executeUpdate();
						}
						
						if((acc_no.getText()).length()!=0)
						{
							PreparedStatement ps=c.prepareStatement ("Update account set account_no=? where name='"+name.getText()+"'");	
							ps.setString(1,acc_no.getText());ps.executeUpdate();
						}
						
						if((ifsc.getText()).length()!=0)
						{
							PreparedStatement ps=c.prepareStatement ("Update account set ifsc=? where name='"+name.getText()+"'");	
							ps.setString(1,ifsc.getText());ps.executeUpdate();
						}
						if((gst_no.getText()).length()!=0)
						{
							PreparedStatement ps=c.prepareStatement ("Update account set gst_no=? where name='"+name.getText()+"'");	
							ps.setString(1,gst_no.getText());ps.executeUpdate();
						}
						
						if((address.getText()).length()!=0)
						{
							PreparedStatement ps=c.prepareStatement ("Update account set address=? where name='"+name.getText()+"'");	
							ps.setString(1,address.getText());ps.executeUpdate();
						}
                                                
                                               
						
                                                if((tel_no.getText()).length()!=0)
						{
							PreparedStatement ps=c.prepareStatement ("Update account set tel_no=? where name='"+name.getText()+"'");	
							ps.setString(1,tel_no.getText());ps.executeUpdate();
						}
                                                //if((sale_disc1.getText()).length()!=0)
						{
							PreparedStatement ps=c.prepareStatement ("Update account set acc_type=? where name='"+name.getText()+"'");	
						   	ps.setString(1,acc_type.getSelectionModel().getSelectedItem().toString());ps.executeUpdate();
						}
                                                {
							PreparedStatement ps=c.prepareStatement ("Update account set state=? where name='"+name.getText()+"'");	
						   	ps.setString(1,state.getSelectionModel().getSelectedItem().toString());ps.executeUpdate();
						}
                                                if((mob_no.getText()).length()!=0)
						{
							PreparedStatement ps=c.prepareStatement ("Update account set mob_no=? where name='"+name.getText()+"'");	
							ps.setString(1,mob_no.getText());ps.executeUpdate();
						}
                                                
                                                if((pan.getText()).length()!=0)
						{
							PreparedStatement ps=c.prepareStatement ("Update account set pan=? where name='"+name.getText()+"'");	
							ps.setString(1,pan.getText());ps.executeUpdate();
						}
                                                if((aadhar.getText()).length()!=0)
						{
							PreparedStatement ps=c.prepareStatement ("Update account set aadhar=? where name='"+name.getText()+"'");	
							ps.setString(1,aadhar.getText());ps.executeUpdate();
						}
                                                {
							PreparedStatement ps=c.prepareStatement ("Update account set owner=? where name='"+name.getText()+"'");	
							ps.setString(1,owner.getSelectionModel().getSelectedItem().toString());ps.executeUpdate();
						}
                                                if((bname.getText()).length()!=0)
						{
							PreparedStatement ps=c.prepareStatement ("Update account set bname=? where name='"+name.getText()+"'");	
							ps.setString(1,bname.getText());ps.executeUpdate();
						}
//                                               
                                                
						jp.showMessageDialog(null,"Record Updated Successfully","SUCCESS",jp.INFORMATION_MESSAGE);
						acc_no.setText(null);
						ifsc.setText(null);
					        name.setText(null);
						gst_no.setText(null);
						address.setText(null);
						tel_no.setText(null);
                                               // acc_type.setText(null)
						mob_no.setText(null);
                                                pan.setText(null);
                                                aadhar.setText(null);
                                                bname.setText(null);
                                               
                        
					}
					else
					{
				         jp.showMessageDialog(null,"Sorry, No Such Record exisits","INFORMATION",jp.ERROR_MESSAGE);
				        }
					
				//}
			
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

        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                   acc_type.setEditable(true);
                   acc_type.getSelectionModel().getSelectedItem();
                   acc_type.getItems().addAll("Supplier Account", "Customer Accout", "Expense Account","Asset Account","Loan Account","Other Account","Capital Bank Account");
                   acc_type.getSelectionModel().select("Supplier Account");
                   owner.setEditable(true);
                   owner.getSelectionModel().getSelectedItem();
                   owner.getItems().addAll("Self", "Other");
                   state.setEditable(true);
                   state.getItems().addAll("Andra Pradesh", "Arunachal Pradesh", "Assam","Bihar","Chhattisgarh","Goa","Gujarat","Haryana","Himachal Pradesh","Jammu and Kashmir","Jharkhand","Karnataka","Madhya Pradesh","Kerala",
                "Maharashtra","Manipur","Meghalaya","Mizoram","Nagaland","Orissa","Punjab","Rajasthan","Sikkim","Tamil Nadu","Tripura","Uttaranchal","West Bengal","Uttar Pradesh");
    }    
    
}
