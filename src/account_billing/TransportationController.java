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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class TransportationController implements Initializable {
     @FXML
    private ComboBox transportation,comboBox;
    @FXML
    private Button submit;
    @FXML
    private TextField name;
    JOptionPane jp = new JOptionPane();
            @FXML
private void trans1Action(ActionEvent event) throws SQLException, ClassNotFoundException{
                       try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			        Statement stm = c.createStatement();
		
			
                       int t = 0;
			/*if(((tax.getText().length()!=0)&&(Integer.parseInt(cgstt.getText())>100||Integer.parseInt(tax.getText())<0)))//final price of product is 
			jp.showMessageDialog(this,"Tax Must be in between 1 to 100","INFORMATION",jp.ERROR_MESSAGE);*/
			if(name.getText().length()==0 ){
				jp.showMessageDialog(null,"Fields should not be null","INFORMATION",jp.ERROR_MESSAGE);
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
//				ResultSet rs2 = stm.executeQuery("insert into trasportation where  name='"+name.getText()+"'");//name ='"+name.getText()+"'
//				if(rs2.next()){
//					jp.showMessageDialog(null,"Record Already Present","INFORMATION",jp.ERROR_MESSAGE);
//				}
//				else{
					PreparedStatement ps  =c.prepareStatement("insert into transportation values(?,?)");
					//if((transportation.getSelectionModel().getSelectedItem()))
					ps.setString(1,transportation.getSelectionModel().getSelectedItem().toString());
					//else
						
					if((name.getText()).length()!=0)
					ps.setString(2,name.getText());
					else
					 ps.setString(2,"");    
				        // name.setEditable(true);	
					 ps.executeUpdate();
					jp.showMessageDialog(null," Added Successfully","SUCCESS",jp.INFORMATION_MESSAGE);
				//}
				
				
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
         transportation.getItems().addAll("Air", "Road", "Train","courier");
         transportation.setEditable(true);
         new AutoCompleteComboBoxListener(transportation);
    }    
    
}
