/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account_billing;

import com.osiersystems.pojos.Balance;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class Balance_StockController implements Initializable {
     @FXML
    private TableView<Balance> table;
     @FXML
    private TableColumn<Balance, String> name;
     @FXML
    private TableColumn<Balance, Integer> stock;
     @FXML
    private TableColumn<Balance, Integer> rate;
     JOptionPane jp = new JOptionPane();
       int t=0;
     private  ObservableList<Balance> list = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        stock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        rate.setCellValueFactory(new PropertyValueFactory<>("price"));
        try
        {
          
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
            Statement stm = c.createStatement();
            t=0;
            ResultSet rs = stm.executeQuery("select * from items where stock!=0");
            while(rs.next())
            {
                t=1;
               list.add(new Balance(
                       rs.getString("name"),
                       rs.getInt("stock"),
                       rs.getInt("mrp")
               ));
              table.setItems(list);
              //table.getItems().addAll(list);
            }
				if(t==0)
				{
					jp.showMessageDialog(null,"Sorry, No Such Record exisits","INFORMATION",jp.ERROR_MESSAGE);
					t=0;
				}
		
		        	c.close();
				stm.close();
		}
		catch(ClassNotFoundException cnf)
		{
			jp.showMessageDialog(null,cnf,"EXCEPTION",jp.ERROR_MESSAGE);
			System.out.println("Cnf Exception");
		}
		catch(SQLException sql)
		{
			jp.showMessageDialog(null,sql,"EXCEPTION",jp.ERROR_MESSAGE);
		}
        
       
    }    
    
}
