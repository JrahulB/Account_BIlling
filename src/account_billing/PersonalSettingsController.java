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
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
/**
 * FXML Controller class
 *
 * @author ACER
 */
public class PersonalSettingsController implements Initializable {
@FXML
    private TextField  pet_name,friends_name,lucky_No,old_shopNm,old_shopAdd,new_shopNm,new_shopAdd,old_bankNm,
        old_AccNo,old_ifscNo,new_bankNm,new_AccNm,new_ifscNm;
JOptionPane jp = new JOptionPane();
int t;
@FXML
    private Button update,cancel;
@FXML
    private void updateButtonAction(ActionEvent event) throws Exception{
                try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
				Statement stm = c.createStatement();
				
				t=0;
				ResultSet rs = stm.executeQuery("select * from ques");
				while(rs.next())
				{	
					t=1;	   
					if((pet_name.getText()).equals(rs.getString("an1"))&&(friends_name.getText()).equals(rs.getString("an2"))&&(lucky_No.getText()).equals(rs.getString("an3")))
					t=-1;
				}
                                ResultSet rs1 = stm.executeQuery("select * from shop_details");
				while(rs1.next())
				{	
					t=1;	   
					if((old_shopNm.getText()).equals(rs1.getString("Name"))&&(old_shopAdd.getText()).equals(rs1.getString("Adress"))&&(new_shopNm.getText()).equals(rs1.getString("name"))&&(new_shopAdd.getText()).equals(rs1.getString("adress")))
					t=-1;
				}
                                ResultSet rs2 = stm.executeQuery("select * from bankdetail");
				while(rs2.next())
				{	
					t=1;	   
					if((old_bankNm.getText()).equals(rs2.getString("bank_name"))&&(old_AccNo.getText()).equals(rs2.getString("ACCOUNT_NO"))&&(old_ifscNo.getText()).equals(rs2.getString("IFSC_NO"))&&(new_ifscNm.getText()).equals(rs2.getString("IFSC_NO"))
                                                &&(new_AccNm.getText()).equals(rs2.getString("ACCOUNT_NO"))&&(new_bankNm.getText()).equals(rs2.getString("BANK_NAME")))
                                         
					t=-1;
				}
				if(t==0)
				{
					jp.showMessageDialog(null,"Sorry, No Such Record exisits","INFORMATION",jp.ERROR_MESSAGE);
					t=0;
				}
				
				if(t==-1)
				{
                                    PreparedStatement ps=c.prepareStatement ("Update shop_details set Name =?");	
					ps.setString(1,new_shopNm.getText());	
                                        ps.executeUpdate();
                                        PreparedStatement ps1=c.prepareStatement ("Update shop_details set Adress =?");	
					ps1.setString(2,new_shopAdd.getText());	
                                        ps1.executeUpdate();
                                        PreparedStatement ps2=c.prepareStatement ("Update bankdetail set bank_name =?");	
					ps2.setString(1,new_bankNm.getText());	
                                        ps2.executeUpdate();
                                        PreparedStatement ps3=c.prepareStatement ("Update bankdetail set Account_NO=?");	
					ps3.setString(2,new_AccNm.getText());	
                                        ps3.executeUpdate();
                                        PreparedStatement ps4=c.prepareStatement ("Update bankdetail set IFSC_NO =?");	
					ps4.setString(3,new_ifscNm.getText());	
                                        ps4.executeUpdate();
					jp.showMessageDialog(null,"Password is Successfully Changed","SUCCESS",jp.INFORMATION_MESSAGE);
					
//				if(((new_password.getText()).equals(conform_password.getText()))&&(new_password.getText().length()!=0)&&(conform_password.getText().length()!=0))
//				{
//					PreparedStatement ps=c.prepareStatement ("Update pass set pas=?");	
//					ps.setString(1,new_password.getText());	ps.executeUpdate();
//					jp.showMessageDialog(null,"Password is Successfully Changed","SUCCESS",jp.INFORMATION_MESSAGE);
//					
//				}
//				else
//				{
					jp.showMessageDialog(null,"All Fields are Incomplete or Incorrect","INFORMATION",jp.ERROR_MESSAGE);
			//}
				}				
				else
				{
					jp.showMessageDialog(null,"Sorry, Your Security Questions are Incorrect","WARRNING",jp.ERROR_MESSAGE);
				}
						
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
				jp.showMessageDialog(null,sql,"EXCEPTION",jp.ERROR_MESSAGE);
			}	
       pet_name.setText(null);
       friends_name.setText(null);
       lucky_No.setText(null);
       old_shopNm.setText(null);
       old_shopAdd.setText(null);
       new_shopNm.setText(null);
       new_shopAdd.setText(null);
       old_bankNm.setText(null);
       old_AccNo.setText(null);
       old_ifscNo.setText(null);
       new_bankNm.setText(null);
       new_AccNm.setText(null);
       new_ifscNm.setText(null);
   
    }
    @FXML
    private void cancelButtonAction(ActionEvent event) throws Exception{
             
			
                            System.exit(0);
                        }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
