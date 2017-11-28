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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class Other_DetailsController implements Initializable 
{
    @FXML
    private TextField Mother_name;
    @FXML
    private TextField Lucky_number;
    @FXML
    private TextField Favorite_colour;
    @FXML
    private TextField Best_friend_name;
    @FXML
    private TextField School_name;
   JOptionPane jp=new JOptionPane();
    /*
     
  CREATE TABLE "SYSTEM"."QUES" 
   (	"AN1" VARCHAR2(10 BYTE), 
	"AN2" VARCHAR2(10 BYTE), 
	"AN3" VARCHAR2(10 BYTE), 
	"AN4" VARCHAR2(20 BYTE), 
	"AN5" VARCHAR2(20 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SYSTEM" ;

                                */
    @FXML
    private AnchorPane anchor;
    
                               @Override
                               public void initialize(URL url, ResourceBundle rb)
                               {
                                   // TODO

                               }    

                               public boolean validateField()
                               {
                               
                                            if(Mother_name.getText().isEmpty() |Lucky_number.getText().isEmpty() |Favorite_colour.getText().isEmpty() |Best_friend_name.getText().isEmpty() | School_name.getText().isEmpty())
                                            {

                                                                 Alert alert=new Alert(Alert.AlertType.WARNING);
                                                                 alert.setTitle("validating field");
                                                                 alert.setHeaderText(null);
                                                                 alert.setContentText("All fields are mandatory");
                                                                 alert.showAndWait();
                                                                            return false;
                                            }
                                                                 return true;
                               }

                               @FXML
                               private void clickOnSubmit(ActionEvent event) throws ClassNotFoundException, SQLException, IOException 
                               {
                               
                                                                Class.forName("oracle.jdbc.driver.OracleDriver");
                                                                Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
                                                                Statement stm = c.createStatement();
/*

CREATE TABLE "SYSTEM"."OTHER_DETAILS" 
 ("MOTHER_NAME" VARCHAR2(20 BYTE) NOT NULL ENABLE, 
"LUCKY_NUMBER" VARCHAR2(20 BYTE) NOT NULL ENABLE, 
"FAVORITE_COLOUR" VARCHAR2(20 BYTE) NOT NULL ENABLE, 
"BEST_FRIEND_NAME" VARCHAR2(20 BYTE) NOT NULL ENABLE, 
"SCHOOL_NAME" VARCHAR2(20 BYTE) NOT NULL ENABLE, 
"FLAG" NUMBER(3,0) NOT NULL ENABLE, 
 CONSTRAINT "OTHER_DETAILS_PK" PRIMARY KEY ("FLAG")                                                                
*/                                                        
                                                                   if(validateField())
                                                                   {
                                                                                        PreparedStatement ps=c.prepareStatement("insert into OTHER_DETAILS values(?,?,?,?,?,?)");
                                                                                        ps.setString(1,Mother_name.getText());
                                                                                        ps.setString(2, Lucky_number.getText());
                                                                                        ps.setString(3, Favorite_colour.getText());
                                                                                        ps.setString(4,Best_friend_name.getText());
                                                                                        ps.setString(5,School_name.getText());
                                                                                        ps.setInt(6,3);
                                                                               
                                                                                        int result=     ps.executeUpdate();
                                                                                         
                                                                                                                if(result > 0 )
                                                                                                                {
                                                                                                                    
                                                                                                                    
                                                                                                                                             Parent parent = FXMLLoader.load(getClass().getResource("/updatework/Done_Window.fxml"));
                                                                                                                                              anchor.getChildren().setAll(parent);
//                                                                                                                              Parent parent = FXMLLoader.load(getClass().getResource("/updatework/Done_Window.fxml"));
//                                                                                                                              Scene scene = new Scene(parent);
//                                                                                                                              Stage stage = new Stage();
//
//                                                                                                                              stage.setTitle("Other details");
//                                                                                                                              stage.setScene(scene);
//                                                                                                                              stage.show();

                                                                                                                }
                                                                                                                    else
                                                                                                                  {
                                                                                                                   jp.showMessageDialog(null,"You have not inserted business details","Validation",jp.ERROR_MESSAGE);

                                                                                                                  }

                                                                    }

                               }
                               
                               
                               @FXML
                               private void clickOnCancel(ActionEvent event) 
                               {
                                
                                                System.exit(0);

                               }

}
