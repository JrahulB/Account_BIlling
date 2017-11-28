/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account_billing;

import com.osiersystems.pojos.Order;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author ACER
 */
public class Bill_CounterController implements Initializable {
@FXML 
   private TableView table;

 
@FXML
private TableColumn <Order, Integer> srno;
@FXML
private TableColumn<Order, String> items;
@FXML
private TableColumn<Order, Integer> quantity;
@FXML
private TableColumn<Order, Integer> amount;
@FXML
private TableColumn<Order, Integer> rate;

//Button addItemBtn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        srno.setCellValueFactory(new PropertyValueFactory<Order, Integer>("srno"));
        items.setCellValueFactory(new PropertyValueFactory<Order, String>("items"));
         quantity.setCellValueFactory(new PropertyValueFactory<Order, Integer>("quantity"));
          amount.setCellValueFactory(new PropertyValueFactory<Order, Integer>("amount"));
           rate.setCellValueFactory(new PropertyValueFactory<Order, Integer>("rate"));
    }    
     @FXML
    private void addBill(ActionEvent event) throws Exception{
        
    }
    @FXML
    private void tableAction(ActionEvent event) throws Exception{
      // srno.setCellValueFactory(new PropertyValueFactory("firstName"));
//      srno.
//      items.getItems().add("Jeans");
//      quantity.getItems().add("1");
//      rate.getItems().add("1000");
//      amount.getItems().add("1000");
    }
}


