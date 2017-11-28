/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account_billing;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author ACER
 */
public class Account_Billing extends Application
{
    
    @Override
    public void start(Stage stage) throws Exception 
    {
        
    // Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
     // Parent root = FXMLLoader.load(getClass().getResource("/updatework/ResisterDetails.fxml"));
        
        // I am chacking git hub operation
        
     Parent root = FXMLLoader.load(getClass().getResource("/updatework/License_Agreement.fxml"));
            
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
