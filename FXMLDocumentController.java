/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account_billing;
import account_billing.BGenerate;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author ACER
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private BorderPane pane;
     @FXML
    private Pane framepane;
    @FXML
   private Button add_btn;
    //load Add Items Form on additem button click
    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("addItems.fxml"));
        framepane.getChildren().setAll(parent); 
    }
  @FXML
    private void BillMenu(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("GenBill.fxml"));
        framepane.getChildren().setAll(parent);
    }

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
    private void addItemKeyEvent(KeyEvent event) throws Exception{
        KeyCode keyCode = event.getCode();
        Parent parent = FXMLLoader.load(getClass().getResource("addItems.fxml"));
        framepane.getChildren().setAll(parent);
   }
    @FXML
    private void addAccountKeyEvent(KeyEvent event) throws Exception{
        //KeyCode keyCode = event.getCode();
         if (event.getCode() == KeyCode.B){
        Parent parent = FXMLLoader.load(getClass().getResource("AddAccount.fxml"));
        framepane.getChildren().setAll(parent);
         }
   }
    @FXML
    private void addTransactionKyEvent(KeyEvent event) throws Exception{
        KeyCode keyCode = event.getCode();
         if (event.getCode() == KeyCode.T){
        Parent parent = FXMLLoader.load(getClass().getResource("Transaction.fxml"));
        framepane.getChildren().setAll(parent);
         }
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
    private void balanceStockAction(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("Balance_Stock.fxml"));
        framepane.getChildren().setAll(parent);
    }
    @FXML
    private void balanceStockMenu(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("Balance_Stock.fxml"));
        framepane.getChildren().setAll(parent);
    }
     @FXML
    private void employeeAction(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("AddEmployee.fxml"));
        framepane.getChildren().setAll(parent);
    }
     @FXML
    private void employeeMenu(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("AddEmployee.fxml"));
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
    private void empattMenu(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("EmployeeAttendance.fxml"));
        framepane.getChildren().setAll(parent);
    }
     @FXML
    private void empattAction(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("EmployeeAttendance.fxml"));
        framepane.getChildren().setAll(parent);
    }
     @FXML
    private void deleteMenu(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("Delete.fxml"));
        framepane.getChildren().setAll(parent);
    }
     @FXML
    private void deleteAction(ActionEvent event) throws Exception{
       Parent parent = FXMLLoader.load(getClass().getResource("Install.fxml"));
        framepane.getChildren().setAll(parent);
    }
     @FXML
    private void changePasswordMenu(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("ChangePassword.fxml"));
        framepane.getChildren().setAll(parent);
    }
      @FXML
    private void personalSettingsMenu(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("PersonalSettings.fxml"));
        framepane.getChildren().setAll(parent);
    }
     @FXML
    private void generateBarcodeMenu(ActionEvent event) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("BarcodeGen.fxml"));
        framepane.getChildren().setAll(parent);
    }
      @FXML
    private void invoiceAction(ActionEvent event) throws Exception{
       // Parent parent = FXMLLoader.load(getClass().getResource("Invoice.fxml"));
       BGenerate bill = new BGenerate("sds","55","55");
        //framepane.getChildren().setAll(bill);
    }  
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
}
