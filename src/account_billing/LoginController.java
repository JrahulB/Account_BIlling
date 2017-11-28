/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account_billing;

import com.osiersystems.pojos.AutoCompleteComboBoxListener;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class LoginController implements Initializable {
@FXML
private TextField uname;
@FXML
private PasswordField pass;
  @FXML
    private AnchorPane pane;
@FXML
private ComboBox ctype;
 JOptionPane jp = new JOptionPane();
     // Choice ctype;
	String tu,p,pe,p1;
   
    /**
     * Initializes the controller class.
     */
      
     @FXML
     private void clikOnLogin(ActionEvent event ) throws Exception
     {
         //String str1=(String)event.getActionCommand();
		Object source = event.getSource();
                try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			Statement stm = c.createStatement();
			pe=ctype.getSelectionModel().getSelectedItem().toString();
			if(pe.equals("admin"))
			{
			ResultSet rs = stm.executeQuery("select * from pass");
			while(rs.next())
                        {
			tu=rs.getString(1);
			p=rs.getString(2);
			}
                        if((tu.equals(uname.getText())) && (p.equals(pass.getText())))
			{
				
				
                                 Parent parent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                                 pane.getChildren().setAll(parent);
				
				
			jp.showMessageDialog(null,"Login Completed Successfully","SUCCESS",jp.INFORMATION_MESSAGE);
			
			}
			
			else
			jp.showMessageDialog(null,"Sorry, User Name or Password is Wrong","WARRNING",jp.ERROR_MESSAGE);
			}
			else
			{
			ResultSet rs1 = stm.executeQuery("select * from perm");
			while(rs1.next()){
			tu=rs1.getString(1);
			p=rs1.getString(2);
			}
			if((tu.equals(uname.getText()))&&(p.equals(pass.getText())))
			{
				//p1.nn(pe,uname.getText(),pass.getText());
				jp.showMessageDialog(null,"Login Completed Successfully","SUCCESS",jp.INFORMATION_MESSAGE);
			}
			else
			jp.showMessageDialog(null,"Sorry, User Name or Password is Wrong","WARRNING",jp.ERROR_MESSAGE);
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
 		}
//		if(source==exit)
//		{
//			System.exit(0);
//		}
    // }
     //}
       
    @FXML
    private void exitButtonAction(ActionEvent event) throws Exception{
    System.exit(0);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
         ctype.getItems().addAll("Admin", "Other");
        ctype.setEditable(true);
         new AutoCompleteComboBoxListener(ctype);
    }   
//    	public static void main(String[] args) {
//      InstallController u=new InstallController();
//      u.makeStuff();
//      launch(args);
//}

    
}
