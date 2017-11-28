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
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ACER
 */
public class AddAccountController implements Initializable {
    @FXML
    private TextField name,acc_no,ifsc,gst_no,address,tel_no,mob_no,pan,aadhar,bank_name;
    @FXML
    private ComboBox state,acc_type,owner;
    
     JOptionPane jp = new JOptionPane();
      
          @FXML
        private void addAccount(ActionEvent event) throws SQLException, ClassNotFoundException{
                    try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			Statement stm = c.createStatement();
		
			
                        int t = 0;
			/*if(((tax.getText().length()!=0)&&(Integer.parseInt(cgstt.getText())>100||Integer.parseInt(tax.getText())<0)))//final price of product is 
			jp.showMessageDialog(this,"Tax Must be in between 1 to 100","INFORMATION",jp.ERROR_MESSAGE);*/
			if(name.getText().length()==0 &&acc_no.getText().length()==0 &&ifsc.getText().length()==0 ){//&&cgst.getText().length()==0 &&sgstt.getText().length()==0 &&stockt.getText().length()==0){
				jp.showMessageDialog(null,"Fields should not be Empty","INFORMATION",jp.ERROR_MESSAGE);
			}
		
			else
			{
				
//				ResultSet rs1 = stm.executeQuery("select * from item where id="+mrp.getText());
//				while(rs1.next())
//				{	
//					t=1;
//				}
			//if(t==0)
				//{
					//t=0;
				ResultSet rs2 = stm.executeQuery("select * from account where  ACCOUNT_NO ='"+acc_no.getText()+"'");//name ='"+name.getText()+"'
				if(rs2.next()){
					jp.showMessageDialog(null,"Record Already Present","INFORMATION",jp.ERROR_MESSAGE);
				}
				else{
					PreparedStatement ps  =c.prepareStatement("insert into account values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
					if((name.getText()).length()!=0)
					ps.setString(1,name.getText());
					else
					ps.setString(1,"");
					if((acc_no.getText()).length()!=0)
					ps.setString(2,acc_no.getText());	
					else
					ps.setString(2,"");	
					if((ifsc.getText()).length()!=0)
					ps.setString(3,ifsc.getText());
					else
					ps.setString(3,"");
					if((gst_no.getText()).length()!=0)
					ps.setString(4,gst_no.getText());
					else
					ps.setString(4,"");
					if((address.getText()).length()!=0)
					ps.setString(5,address.getText());
					else
					ps.setString(5,"");
					if((tel_no.getText()).length()!=0)
					ps.setString(6,tel_no.getText());
					else
					ps.setString(6,"");
					ps.setString(7, (String) acc_type.getSelectionModel().getSelectedItem());
                                        ps.setString(8, (String) state.getSelectionModel().getSelectedItem());
                                        if((mob_no.getText()).length()!=0)
					ps.setString(9,mob_no.getText());
					else
                                        ps.setString(9,"");
					if((pan.getText()).length()!=0)
					ps.setString(10,pan.getText());
					else 
                                        ps.setString(10,"");
					if((aadhar.getText()).length()!=0)
					ps.setString(11,aadhar.getText());
					else    
                                        ps.setString(11,"");
                                         ps.setString(12, (String) owner.getSelectionModel().getSelectedItem());
                                         if((bank_name.getText()).length()!=0)
					ps.setString(13,bank_name.getText());
					else    
                                        ps.setString(14,"");
						name.setEditable(true);
						acc_no.setEditable(true);
						ifsc.setEditable(true);
						gst_no.setEditable(true);
						address.setEditable(true);
                                                tel_no.setEditable(true);
						
						name.setText(null);
						acc_no.setText(null);
						ifsc.setText(null);
						gst_no.setText(null);
						address.setText(null);
						tel_no.setText(null);
                                                mob_no.setText(null);
                                                pan.setText(null);
                                                aadhar.setText(null);
					
					
					ps.executeUpdate();
					jp.showMessageDialog(null,"Account Added Successfully","SUCCESS",jp.INFORMATION_MESSAGE);
				}
				/*else
				{
					jp.showMessageDialog(this,"Sorry, Record ID is Already Exists","INFORMATION",jp.ERROR_MESSAGE);
					t=0;
				}*/
				
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
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      // Add account type to unit combobox
        acc_type.getItems().removeAll(acc_type.getItems());
        acc_type.getItems().addAll("Supplier Account", "Customer Accout", "Expense Account","Asset Account","Loan Account","Other Account","Capital Bank Account");
        acc_type.getSelectionModel().select("Supplier Account");
                //Add state to tax category combobox
        state.getItems().removeAll(state.getItems());
        state.getItems().addAll("Maharashtra", "Assam", "Karnataka","TamilNadu","Kerla","Rajasthan");
        state.getSelectionModel().select("Maharashtra");
            //
            owner.getItems().removeAll(owner.getItems());
        owner.getItems().addAll("Self", "Other");
        owner.getSelectionModel().select("Self");
    }    
    
}