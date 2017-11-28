/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account_billing;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class EditempController implements Initializable {

  @FXML
    private Label uname,passwd;
    @FXML
    private Button loginButton,exit;
    @FXML
    private TextField uname1,passwd1;
     JOptionPane jp = new JOptionPane();
     @FXML
    private AnchorPane pane;
     @FXML
     private String tu,p;
    @FXML
            
    private void loginAction(ActionEvent event) throws SQLException, ClassNotFoundException, IOException{
    
                     String str = ""+uname1.getSelectedText()+passwd1.getSelectedText();
					
			try{
                                                    
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			        Statement stm = c.createStatement();
                                                   {
			ResultSet rs = stm.executeQuery("select * from pass");
			while(rs.next()){
			tu=rs.getString(1);
			p=rs.getString(2);
			}
			if((tu.equals(uname1.getText()))&&(p.equals(passwd1.getText())))
			{
				
				
                                 Parent parent = FXMLLoader.load(getClass().getResource("EditEmployee.fxml"));
                                 pane.getChildren().setAll(parent);
				
				
			jp.showMessageDialog(null,"Login Completed Successfully","SUCCESS",jp.INFORMATION_MESSAGE);
			
			}
			else
			jp.showMessageDialog(null,"Sorry, User Name or Password is Wrong","WARRNING",jp.ERROR_MESSAGE);
			}
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
    private void exitButtonAction(ActionEvent event) throws Exception{
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
