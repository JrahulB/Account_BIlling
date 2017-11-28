/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account_billing;

import java.beans.Statement;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ACER
 */
public class AddItemController implements Initializable {
     @FXML
      private ComboBox combobox;
     @FXML
     private TextField id,name,cost,cgst,sgst,stock;
     @FXML
     private Button add;
      @FXML
      JOptionPane jp = new JOptionPane();
      public void set(){
        combobox.setValue("GST");
      }
       @FXML
    private void addItem(ActionEvent event) throws Exception{
        try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			java.sql.Statement stm = c.createStatement();
		
			
            int t = 0;
			/*if(((tax.getText().length()!=0)&&(Integer.parseInt(cgstt.getText())>100||Integer.parseInt(tax.getText())<0)))//final price of product is 
			jp.showMessageDialog(this,"Tax Must be in between 1 to 100","INFORMATION",jp.ERROR_MESSAGE);*/
			if(name.getText().length()==0 && cost.getText().length()==0 && cost.getText().length()==0 && cgst.getText().length()==0 && sgst.getText().length()==0 ){//&& stockt.getText().length()==0){
				jp.showMessageDialog(null,"Fields should not be null","INFORMATION",jp.ERROR_MESSAGE);
			}
		
			else
			{
				
				ResultSet rs1 = stm.executeQuery("select * from item where id="+id.getText());
				while(rs1.next())
				{	
					t=1;
				}
			//if(t==0)
				//{
					//t=0;
				ResultSet rs2 = stm.executeQuery("select * from item where name ='"+name.getText()+"' and cost='"+cost.getText()+"'");
				if(rs2.next()){
					jp.showMessageDialog(null,"Record Already Present","INFORMATION",jp.ERROR_MESSAGE);
				}
				else{
					PreparedStatement ps  = c.prepareStatement("insert into item values(?,?,?,?,?,?)");
					if((id.getText()).length()!=0)
					ps.setString(1,id.getText());
					else
					ps.setString(1,"");
					if((name.getText()).length()!=0)
					ps.setString(2,name.getText());	
					else
					ps.setString(2,"");	
					if((cost.getText()).length()!=0)
					ps.setString(3,cost.getText());
					else
					ps.setString(3,"");
					if((cgst.getText()).length()!=0)
					ps.setString(4,cgst.getText());
					else
					ps.setString(4,"");
					if((sgst.getText()).length()!=0)
					ps.setString(5,sgst.getText());
					else
					ps.setString(5,"");
					if((stock.getText()).length()!=0)
					ps.setString(6,stock.getText());
					else
					ps.setString(6,"");
					
						id.setEditable(true);
						name.setEditable(true);
						cost.setEditable(true);
						cgst.setEditable(false);
						sgst.setEditable(false);
						stock.setEditable(true);
						
						id.setText(null);
						name.setText(null);
						cost.setText(null);
						//cgstt.setText(null);
						//sgstt.setText(null);
						//stockt.setText(null);
					
					
					ps.executeUpdate();
					jp.showMessageDialog(null,"Item Added Successfully","SUCCESS",jp.INFORMATION_MESSAGE);
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
        // TODO
        
    }    
    
}
