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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class DeleteController implements Initializable {
@FXML
    private Label itemn,empn,accn;
    @FXML
    private Button deleteButton,exit;
     @FXML
     CheckBox item, emp, account;
    @FXML
    private TextField itemnm,accname,empname;
     JOptionPane jp = new JOptionPane();
     @FXML
    private AnchorPane pane;
    /**
     * Initializes the controller class.
     */
      @FXML
private void actinPerformed(ActionEvent event) throws SQLException, ClassNotFoundException{
    try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			Statement stm = c.createStatement();
                               int t = 0;
				///item table delete
				if(item.isSelected())
				{
					PreparedStatement ps  = c.prepareStatement("delete from item where name='"+itemnm.getText()+"'");
					ps.executeQuery();
				 }
				
				///Account table delete
				if(account.isSelected())
				{
					PreparedStatement ps1  = c.prepareStatement("delete from Accounts where name='"+accname.getText()+"'");
					ps1.executeQuery();
				}
			
				///Employee Table delete
				if(emp.isSelected())
				{
					//ArrayList<Integer> ar = new ArrayList<Integer>();
					PreparedStatement ps11 = c.prepareStatement("delete  from emp where name='"+empname.getText()+"'");
					ps11.executeQuery();
				}	
				jp.showMessageDialog(null,"Delete Successfully");
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
    }
}
   
    

