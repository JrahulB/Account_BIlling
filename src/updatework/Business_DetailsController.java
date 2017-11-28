/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package updatework;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author G1 NOTEBOOK
 */
public class Business_DetailsController implements Initializable 
{
    

    @FXML
    private TextField business_Registraction_No;
    @FXML
    private TextField gst_No;
    @FXML
    private TextField bank_Name;
    @FXML
    private TextField account_No;
    @FXML
    private TextField confim_Account_No;
    @FXML
    private TextField ifsc_No;
    @FXML
    private TextField confirm_Ifsc_No;
    @FXML
    private TextField Business_name;
    @FXML
    private TextArea Business_address;
    
   JOptionPane jp=new JOptionPane();
             Alert alert=new Alert(Alert.AlertType.WARNING);
    @FXML
    private AnchorPane anchor;
                       @Override
                        public void initialize(URL url, ResourceBundle rb) 
                        {
                                System.out.println("in initialize");
                        }  

                       
                        @FXML
                        public void clickOnSubmit(ActionEvent event) throws ClassNotFoundException, SQLException, IOException 
                        {
                                                   
                                                   
                                                         Class.forName("oracle.jdbc.driver.OracleDriver");
                                                        Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
                                                        Statement stm = c.createStatement();

                                                                  if(validateField() & validateIfscNumber())
                                                                  {
                                                                      
                                                                  
                                                                       if((account_No.getText().equals(confim_Account_No.getText())) &&(ifsc_No.getText().equals(confirm_Ifsc_No.getText()))) 
                                                                       {

/*
CREATE TABLE "SYSTEM"."BUSINESS_DETAILS" 
(	"BUSINESS_NAME" VARCHAR2(20 BYTE) NOT NULL ENABLE, 
  "BUSINESS_ADDRESS" VARCHAR2(50 BYTE) NOT NULL ENABLE, 
  "BANK_NAME" VARCHAR2(20 BYTE) NOT NULL ENABLE, 
  "ACCOUNT_NO" NUMBER(16,0) NOT NULL ENABLE, 
  "IFSC_NO" NUMBER(16,0) NOT NULL ENABLE, 
  "BUSINESS_REGISTRACTION_NO" NUMBER(16,0) NOT NULL ENABLE, 
  "GST_NO" VARCHAR2(16 BYTE) NOT NULL ENABLE, 
  "FLAG" NUMBER(3,0) NOT NULL ENABLE, 
   CONSTRAINT "BUSINESS_DETAILS_PK" PRIMARY KEY ("BUSINESS_REGISTRACTION_NO");                                                                                                
*/                             
                                                                                             PreparedStatement ps=c.prepareStatement("insert into BUSINESS_DETAILS values(?,?,?,?,?,?,?,?)");
                                                                                             
                                                                                             System.out.println("after prepare");
                                                                                             
                                                                                            ps.setString(1,Business_name.getText());
                                                                                            ps.setString(2,Business_address.getText());
                                                                                            ps.setString(3,bank_Name.getText());
                                                                                            ps.setString(4,account_No.getText());
                                                                                            ps.setString(5,ifsc_No.getText());
                                                                                            ps.setString(6,business_Registraction_No.getText());
                                                                                            ps.setString(7,gst_No.getText());
                                                                                            ps.setInt(8,2);
                                                                                         
                                                                                            
                                                                                      

                                                                                            int result=  ps.executeUpdate();

                                                                                                                                if(result > 0 )
                                                                                                                                  {
                                                                                                                                      
                                                                                                                                             Parent parent = FXMLLoader.load(getClass().getResource("/updatework/Other_Details.fxml"));
                                                                                                                                            anchor.getChildren().setAll(parent);
//                                                                                                                                                Parent parent = FXMLLoader.load(getClass().getResource("/updatework/Other_Details.fxml"));
//                                                                                                                                                Scene scene = new Scene(parent);
//                                                                                                                                                Stage stage = new Stage();
//
//                                                                                                                                                stage.setTitle("Other details");
//                                                                                                                                                stage.setScene(scene);
//                                                                                                                                                stage.show();

                                                                                                                                  }
                                                                                                                                   else
                                                                                                                                    {
                                                                                                                                    
                                                                                                                                               alert.setTitle("Validation");
                                                                                                                                                alert.setHeaderText(null);
                                                                                                                                                alert.setContentText("You have not inserted business details ");
                                                                                                                                                alert.showAndWait();
                                                                                                                                       }
                                                                                              
                                                                                           
                                                                  }//inner if
                                                                 else
                                                                  {
                                                                                         
                                                                                          
                                                                                           alert.setTitle("Validation");
                                                                                          alert.setHeaderText(null);
                                                                                          alert.setContentText("fields are not matching ");
                                                                                          alert.showAndWait();
                                                                    }//inner else
                                                                            System.out.println("before end of outer if");
                                                              }
                                                            else
                                                            {
                                                            }//outer if
                                                                  
//                                                                  Business_name.setText("");
//                                                                   Business_address.setText("");
//                                                                    business_Registraction_No.setText("");
//                                                                     gst_No.setText("");
//                                                                     bank_Name.setText("");
//                                                                       account_No.setText("");
//                                                                      confim_Account_No.setText("");
//                                                                       ifsc_No.setText("");
//                                                                       confirm_Ifsc_No.setText("");
                                           
                        }//method close
                        
                         @FXML
                        public  void clickOnCancel(ActionEvent event) 
                        {
                        
                                                    System.exit(0);
                        }
                        
                          public boolean validateField()
                         {
                                      
                                            
                                              if(Business_name.getText().isEmpty() | Business_address.getText().isEmpty() | business_Registraction_No.getText().isEmpty() | gst_No.getText().isEmpty() | bank_Name.getText().isEmpty()  | account_No.getText().isEmpty() | confim_Account_No.getText().isEmpty() | ifsc_No.getText().isEmpty() |confirm_Ifsc_No.getText().isEmpty() )
                                              {
                                                             
                                                                
                                                    
                                                             alert.setTitle("Validation");
                                                             alert.setHeaderText(null);
                                                             alert.setContentText("All fields are mandatory");
                                                             alert.showAndWait();
                                                             return false;
                                              }
                                                              return true;
                        }


                //[A-Z|a-z]{4}[0][\d]{6}$
               //[A-Z|a-z]{4}[0][a-zA-Z0-9]{6}$        
                                                private boolean validateIfscNumber()
                                                {
                                                            Pattern p = Pattern.compile("[A-Z|a-z]{4}[0][\\d]{6}$");
                                                            Matcher m =p.matcher(ifsc_No.getText());
                                                            if(m.find() && m.group().equals(ifsc_No.getText()))
                                                            {
                                                                return true;
                                                            }
                                                            else
                                                            {

                                                                alert.setTitle("Validation");
                                                                alert.setHeaderText(null);
                                                                alert.setContentText("You Entered Wrong IFSC Code ");
                                                                alert.showAndWait();
                                                                return false;
                                                            }
                                                }

     
}
