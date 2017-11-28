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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class Fund_TransferController implements Initializable {
    @FXML
    private ComboBox typ_account,acc_name,typ_debit;
    @FXML
    private TextField amount,narration;
    @FXML
    private DatePicker date;
    JOptionPane jp = new JOptionPane();
    //add account holder names from accounts table in account holder combobox
    @FXML
    private void accountTypeAction(ActionEvent event) throws SQLException {
        String str = ""+typ_account.getSelectionModel().getSelectedItem();
					
	try{
            acc_name.getItems().clear();
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
            Statement stm = c.createStatement();
            ResultSet rs;
            if(typ_account.equals("All")){
            rs = stm.executeQuery("select name from Account" );
            }
            else
            rs = stm.executeQuery("select name from Account where Account_type='"+typ_account.getSelectionModel().getSelectedItem()+"'");
								   				
            while(rs.next())
            {
		acc_name.getItems().addAll(rs.getString("name"));						
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
		sql.printStackTrace();
		System.out.println("DB connectivity issue");
            }
     }

     //add account holder names from accounts table in Debit Account Type combobox
    @FXML
    private void debitAccountTypeAction(ActionEvent event) throws SQLException {
       
    }
    //Save Transaction Data to Database in Transaction Table
    @FXML
    private void saveButtonAction(ActionEvent event) throws SQLException {
       try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			Statement stm = c.createStatement();
			PreparedStatement ps  = c.prepareStatement("insert into Transaction values("+date.getAccessibleText()+",?,?,?,?)");
			ps.setString(1,acc_name.getSelectionModel().getSelectedItem().toString());	
			ps.setString(2,typ_debit.getSelectionModel().getSelectedItem().toString());
			if((amount.getText()).length()!=0)
			ps.setString(3,amount.getText());
			else
			ps.setString(4,"");
			if((narration.getText()).length()!=0)
			ps.setString(4,narration.getText());
			else
			ps.setString(5,"");
	
			ps.executeUpdate();
	
			typ_account.setSelectionModel(null);
			acc_name.setSelectionModel(null);
			amount.setText(null);
			narration.setText(null);
			jp.showMessageDialog(null,"Transaction Successfully","SUCCESS",jp.INFORMATION_MESSAGE);
			//list.setVisible(true);
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
        // Add account type to unit combobox
        typ_account.getItems().removeAll(typ_account.getItems());
        typ_account.getItems().addAll("Supplier Account", "Customer Account", "Expense Account","Asset Account","Loan Account","Other Account","Capital Bank Account");
        typ_account.getSelectionModel().select("Supplier Account");
        //Add Bank names to debit account type combobox from accounts table//////
         try{
         Class.forName("oracle.jdbc.driver.OracleDriver");
			    Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
				Statement stm = c.createStatement();
				ResultSet rs = stm.executeQuery("select BNAME from Account where owner = 'Self' ");
				   				
				while(rs.next())
				{
					typ_debit.getItems().addAll(rs.getString("bname"));
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
	    		sql.printStackTrace();
	    		System.out.println("DB connectivity issue");
	    	}
         ///////////////////////////////////////////////////////////
    }    
    
}
