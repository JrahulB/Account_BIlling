/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account_billing;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author ACER
 */
public class TransactionController implements Initializable {

    @FXML
    private ComboBox acc_type,acc_name;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         // Add Items to combobox
        acc_type.getItems().removeAll(acc_type.getItems());
        acc_type.getItems().addAll("Supplier Account", "Customer", "Expense","Asset","Loan Account","Other Account","Capital Account");
        acc_type.getSelectionModel().select("All");
        //
        // Add Items to combobox
        acc_name.getItems().removeAll(acc_name.getItems());
        acc_name.getItems().addAll("B.K. sharma", "Pallavi Creations", "Shree Furniture","Mamta Traders");
        acc_name.getSelectionModel().select("All");
    }    
    
}
