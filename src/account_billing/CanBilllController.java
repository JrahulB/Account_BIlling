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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class CanBilllController implements Initializable {

     @FXML
    private AnchorPane anchor;
     @FXML
    private Button canButton;
    @FXML
    private TextField id1,name,pho;
     @FXML
      JOptionPane jp = new JOptionPane();
   @FXML
    private void showDisplayAction(ActionEvent event) throws Exception{
         JOptionPane.showOptionDialog(null, "ARE YOU SURE YOU WANT TO CANCLE BILL" 
		                , "WANT TO CANCLE BILL", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE
		                   ,null, null, null);
			
			
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
				Statement stm = c.createStatement();
				PreparedStatement ps  = c.prepareStatement("delete from bill where bid='"+id1.getText()+"' or name='"+name.getText()+"' or phno='"+pho.getText()+"'" );
				ps.executeQuery();
				jp.showMessageDialog(null,"Bill Canceled Successfully","SUCCESS",jp.INFORMATION_MESSAGE);
			
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
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
