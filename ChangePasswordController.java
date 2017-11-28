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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ACER
 */
public class ChangePasswordController implements Initializable {
    @FXML
    private PasswordField old_password, new_password, conform_password;
    @FXML
    private TextField pet_name, best_friend, lucky_number, user_name;
    JOptionPane jp = new JOptionPane();
    int t=0;
    //Change Login Password
     @FXML
    private void okButtonAction(ActionEvent event) throws Exception{
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
					if((pet_name.getText()).equals(rs.getString("an1"))&&(best_friend.getText()).equals(rs.getString("an2"))&&(lucky_number.getText()).equals(rs.getString("an3")))
					t=-1;
				}
				if(t==0)
				{
					jp.showMessageDialog(null,"Sorry, No Such Record exisits","INFORMATION",jp.ERROR_MESSAGE);
					t=0;
				}
				
				if(t==-1)
				{
				if(((new_password.getText()).equals(conform_password.getText()))&&(new_password.getText().length()!=0)&&(conform_password.getText().length()!=0))
				{
					PreparedStatement ps=c.prepareStatement ("Update pass set pas=?");	
					ps.setString(1,new_password.getText());	ps.executeUpdate();
					jp.showMessageDialog(null,"Password is Successfully Changed","SUCCESS",jp.INFORMATION_MESSAGE);
					
				}
				else
				{
					jp.showMessageDialog(null,"All Fields are Incomplete or Incorrect","INFORMATION",jp.ERROR_MESSAGE);
				}
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
				System.out.println("Cnf Exception");
			}
			catch(SQLException sql)
			{
				jp.showMessageDialog(null,sql,"EXCEPTION",jp.ERROR_MESSAGE);
			}	
       pet_name.setText(null);
       best_friend.setText(null);
       lucky_number.setText(null);
       user_name.setText(null);
       old_password.setText(null);
       new_password.setText(null);
       conform_password.setText(null);
   
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
