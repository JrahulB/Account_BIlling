/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account_billing;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author ACER
 */
public class FXMLDocumentController implements Initializable
{
    
    @FXML
    private Label label;
    @FXML
    private BorderPane pane;
     @FXML
    private Pane framepane;
     @FXML
    private Pane AnchorPane;
    @FXML
   private Button add_btn;
    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception
    {
        System.out.println("You clicked me!");
        Parent parent = FXMLLoader.load(getClass().getResource("addItems.fxml"));
        framepane.getChildren().setAll(parent); 
    }
   
    
  
    
  @FXML
    private void BillMenu(ActionEvent event) throws Exception
    {
        Parent parent = FXMLLoader.load(getClass().getResource("Bill_Counter.fxml"));
//        framepane.getChildren().setAll(parent);
    }
//     
//    @FXML
//    private void addBill(ActionEvent event) throws Exception{
//        Parent parent = FXMLLoader.load(getClass().getResource("Bill_Counter.fxml"));
//        framepane.getChildren().setAll(parent);
//
//    }
    @FXML
    private void addItemMenu(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("addItems.fxml"));
        framepane.getChildren().setAll(parent);
    }
     @FXML
    private void addAccountMenu(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("AddAccount.fxml"));
        framepane.getChildren().setAll(parent);
    }
    @FXML
    private void dayWiseAction(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("DayWiseSale.fxml"));
        framepane.getChildren().setAll(parent);
    }
     @FXML
    private void dayWiseMenu(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("DayWiseSale.fxml"));
        framepane.getChildren().setAll(parent);
    }
     @FXML
    private void daytodayAction(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("DayToDaySale.fxml"));
        framepane.getChildren().setAll(parent);
    }
     @FXML
    private void daytodayMenu(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("DayToDaySale.fxml"));
        framepane.getChildren().setAll(parent);
    }
     @FXML
    private void transactionAction(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("Transaction.fxml"));
        framepane.getChildren().setAll(parent);
    }
     @FXML
    private void transactionMenu(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("Transaction.fxml"));
        framepane.getChildren().setAll(parent);
    }
    @FXML
    private void addItemKeyEvent(KeyEvent event) throws Exception{
        KeyCode keyCode = event.getCode();
        Parent parent = FXMLLoader.load(getClass().getResource("addItems.fxml"));
        framepane.getChildren().setAll(parent);
   }
     @FXML
    private void addAccount(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("AddAccount.fxml"));
        framepane.getChildren().setAll(parent);
    }
     @FXML
    private void nilAction(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("Nill_Stock.fxml"));
        framepane.getChildren().setAll(parent);
    }
     @FXML
    private void nilMenu(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("Nill_Stock.fxml"));
        framepane.getChildren().setAll(parent);
    }
     @FXML
    private void employeeAction(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("Add Employee.fxml"));
        framepane.getChildren().setAll(parent);
    }
     @FXML
    private void employeeMenu(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("Add Employee.fxml"));
        framepane.getChildren().setAll(parent);
    }
     @FXML
    private void cleanupAction(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("CleanUp.fxml"));
        framepane.getChildren().setAll(parent);
    }
    @FXML
    private void cleanupMenu(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("CleanUp.fxml"));
        framepane.getChildren().setAll(parent);
    }
     @FXML
    private void backupMenu(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("BackUp.fxml"));
        framepane.getChildren().setAll(parent);
    }
    @FXML
    private void backupAction(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("BackUp.fxml"));
        framepane.getChildren().setAll(parent);
    }
    @FXML
    private void fundMenu(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("Fund_Transfer.fxml"));
        framepane.getChildren().setAll(parent);
    }
     @FXML
    private void fundAction(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("Fund_Transfer.fxml"));
        framepane.getChildren().setAll(parent);
    }
   
    @FXML
    private void genbilMenu(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("GenBill.fxml"));
        framepane.getChildren().setAll(parent);
    }
     @FXML
    private void genbillAction(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("GenBill.fxml"));
        framepane.getChildren().setAll(parent);
    }
   
     @FXML
    private void balstockMenu(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("balance_Stock.fxml"));
        framepane.getChildren().setAll(parent);
    }
     @FXML
    private void balstockAction(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("Balance_Stock.fxml"));
        framepane.getChildren().setAll(parent);
    }
    @FXML
    private void empattMenu(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("Empatt.fxml"));
        framepane.getChildren().setAll(parent);
    }
     @FXML
    private void empattAction(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("Empatt.fxml"));
        framepane.getChildren().setAll(parent);
    }
    @FXML
    private void deleteMenu(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("Delete.fxml"));
        framepane.getChildren().setAll(parent);
    }
     @FXML
    private void deleteAction(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("Delete.fxml"));
        framepane.getChildren().setAll(parent);
    }
     @FXML
    private void InvoiceAction(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("InvoceBilling.fxml"));
        framepane.getChildren().setAll(parent);
    }
     
    @FXML
    private void changePassMenu(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("ChangePassword.fxml"));
        framepane.getChildren().setAll(parent);
    }
     @FXML
    private void ChangePasswordAction(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("ChangePassword.fxml"));
        framepane.getChildren().setAll(parent);
    }
     @FXML
    private void personalSettingAction(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("PersonalSettings.fxml"));
        framepane.getChildren().setAll(parent);
    }
     @FXML
    private void personalSettingMenu(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("PersonalSettings.fxml"));
        framepane.getChildren().setAll(parent);
    }
      @FXML
    private void TransportationMenu(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("Transportation.fxml"));
        framepane.getChildren().setAll(parent);
    }
     @FXML
    private void TransportationAction(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("Transportation.fxml"));
        framepane.getChildren().setAll(parent);
    }
    @FXML
    private void employee1Action(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("Editemp.fxml"));
        framepane.getChildren().setAll(parent);
    }
     @FXML
    private void editempMenu(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("Editemp.fxml"));
        framepane.getChildren().setAll(parent);
    }
    @FXML
    private void eempAction(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("Edit Employee.fxml"));
        framepane.getChildren().setAll(parent);
    }
     @FXML
    private void eempMenu(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("Edit Employee.fxml"));
        framepane.getChildren().setAll(parent);
    }
    @FXML
    private void edititem1Action(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("Edititem1.fxml"));
        framepane.getChildren().setAll(parent);
    }
     @FXML
    private void edititemMenu(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("Edititem1.fxml"));
        framepane.getChildren().setAll(parent);
    }
    @FXML
    private void eitemAction(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("EditItem.fxml"));
        framepane.getChildren().setAll(parent);
    }
     @FXML
    private void eitemMenu(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("EditItem.fxml"));
        framepane.getChildren().setAll(parent);
    }
     @FXML
    private void editAccout1Action(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("EditAccount1.fxml"));
        framepane.getChildren().setAll(parent);
    }
     @FXML
    private void editAccountMenu(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("EditAccount1.fxml"));
        framepane.getChildren().setAll(parent);
    }
    @FXML
    private void eAccountAction(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("EditAccount.fxml"));
        framepane.getChildren().setAll(parent);
    }
     @FXML
    private void eAccountMenu(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("EditAccount.fxml"));
        framepane.getChildren().setAll(parent);
    }
    
     @FXML
    private void canBillAction(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("CanBill.fxml"));
        framepane.getChildren().setAll(parent);
    }
     @FXML
    private void canBillMenu(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("CanBill.fxml"));
        framepane.getChildren().setAll(parent);
    }
    @FXML
    private void installAction(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("Install.fxml"));
        framepane.getChildren().setAll(parent);
    }
     @FXML
    private void installMenu(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("Install.fxml"));
        framepane.getChildren().setAll(parent);
    }
     
    
    @FXML
    private void register_Details_Menu(ActionEvent event) throws Exception{
        // Parent root = FXMLLoader.load(getClass().getResource("/updatework/License_Agreement.fxml"));
         
        Parent parent = FXMLLoader.load(getClass().getResource("/updatework/Login_Update_Register_details.fxml"));
        framepane.getChildren().setAll(parent);
    }
    
    @FXML
    private void business_Details_Menu(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("/updatework/Login_Update_Business_Details.fxml"));
        framepane.getChildren().setAll(parent);
    }
    
    @FXML
    private void other_Details_Menu(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("/updatework/Login_Update_Other_Details.fxml"));
        framepane.getChildren().setAll(parent);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
}
