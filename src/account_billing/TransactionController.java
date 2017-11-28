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
import java.sql.ResultSet;
import java.sql.SQLException;
import static java.util.Collections.list;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;
import static jdk.nashorn.internal.objects.NativeJava.type;

/**
 * FXML Controller class
 *
 * @author ACER
 */
public class TransactionController implements Initializable 
{

    @FXML
    private ComboBox acc_type,acc_name;
    @FXML
    private Button displayButton;
    @FXML
    private DatePicker from_date,to_date;
    @FXML
    private AnchorPane pane;
    /**
     * Initializes the controller class.
     */
    
          @FXML
private void actinPerformed(ActionEvent event) throws SQLException, ClassNotFoundException
{
    
    
                                    String str = ""+acc_type.getSelectionModel();
					
						try
                                                {
                                                    acc_name.getItems().clear();								//acc_name.removeAllItems();
					    		//create list for dictionary this in your case might be done via calling a method which queries db and returns results as arraylist
					    	    Class.forName("oracle.jdbc.driver.OracleDriver");
							    Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
								java.sql.Statement stm = c.createStatement();
								ResultSet rs;
								if(acc_type.equals("All"))
                                                                                                                                            {
									 rs = stm.executeQuery("select name from Accounts" );
								}
								else
								rs = stm.executeQuery("select name from Accounts where Accont_type='"+acc_name.getSelectionModel().getSelectedItem()+"'");
								   				
								while(rs.next())
								{
									acc_name.getItems().addAll(rs.getString("name"));
								}
								//}
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
    
// @FXML
//    private void transactionUIMenu(ActionEvent event) throws Exception{
//        Parent parent = FXMLLoader.load(getClass().getResource("TransactionUI.fxml"));
//        pane.getChildren().setAll(parent);
//    }
     @FXML
    private void displyButtonAction(ActionEvent event) throws Exception
    {
        Parent parent = FXMLLoader.load(getClass().getResource("TransactionUI.fxml"));
        pane.getChildren().setAll(parent);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         // Add Items to combobox
        acc_type.getItems().removeAll(acc_type.getItems());
        acc_type.getItems().addAll("Supplier Account", "Customers Account", "Expense Account","Asset Account","Loan Account","Investment Account","Other Income Account","Capital Bank Account");
        acc_type.getSelectionModel().select("All");
        //
//        // Add Items to combobox
//        acc_name.getItems().removeAll(acc_name.getItems());
//        acc_name.getItems().addAll("B.K. sharma", "Pallavi Creations", "Shree Furniture","Mamta Traders");
//        acc_name.getSelectionModel().select("All");
    }   
    
    
}
