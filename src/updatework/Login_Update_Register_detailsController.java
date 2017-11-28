/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package updatework;

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
 * @author G1 NOTEBOOK
 */
public class Login_Update_Register_detailsController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private Label uname,passwd;
    @FXML
    private Button loginButton,exit;
    @FXML
    private TextField uname2,passwd2;
     JOptionPane jp = new JOptionPane();
     @FXML
    private AnchorPane pane;
     @FXML
     private String tu,p;
    @FXML
            
    private void loginAction(ActionEvent event) throws SQLException, ClassNotFoundException, IOException{
    
                     String str = ""+uname2.getSelectedText()+passwd2.getSelectedText();
					
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
                        if((tu.equals(uname2.getText()))&&(p.equals(passwd2.getText())))
			{
				
				
                                 Parent parent = FXMLLoader.load(getClass().getResource("Register_Details_Update.fxml"));
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
