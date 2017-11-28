package updatework;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class ResisterDetailsController implements Initializable
{

            @FXML
            private TextField owner_name;

            @FXML
            private TextField mobile_Number;
            @FXML
            private TextField email;

            @FXML
            private PasswordField password;
            @FXML
            private PasswordField re_Password;




            @FXML
            private RadioButton male;
            @FXML
            private ToggleGroup gender;
            @FXML
            private RadioButton female;

          private String gen="Male";

         JOptionPane jp=new JOptionPane();
        Alert al= new Alert(AlertType.WARNING);
        
    @FXML
    private AnchorPane anchor;

                        @Override
                        public void initialize(URL url, ResourceBundle rb)
                        {

                        }    
// System.out.println("=================>  = ");
                        @FXML
                        private void clickOnRegister(ActionEvent event) throws IOException, SQLException 
                        {
                              
                                                            if (female.isSelected()) 
                                                            {
                                                                gen="Female";
                                                                System.out.println("=================>  I main Gender = ");
                                                            }
                                                                    if(validateField()  & validateEmail() & validateNumber() & validatePassword())
                                                                    {

                                                                            if(password.getText().equals(re_Password.getText()) ) 
                                                                            {
                                                                                                    try
                                                                                                       {
                                                                                                            System.out.println("=================> Data Base Connection = ");
                                                                                                                   Class.forName("oracle.jdbc.driver.OracleDriver");
                                                                                                                   Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
                                                                                                                   Statement stm = c.createStatement();

                                                                                                            System.out.println("=================> Connection Sucess  = ");

                                                                                                                   ResultSet rs2 = stm.executeQuery("select * from OSIER_ACCOUNT where  email='"+email.getText()+"'");

                                                                                                                 if(rs2.next())       // he is alrady register then go to login page  with that check all business and other details complited or not.
                                                                                                                 {
                                                                                                                    System.out.println("=================> Result set rs2  = ");

                                                                                                                                             al.setTitle("Validation");
                                                                                                                                              al.setHeaderText(null);
                                                                                                                                             al.setContentText("You have  Already OSIER ACCOUNT is Created ");
                                                                                                                                             al.show();
                                                                                                                                             
                                                                                                                                                 Parent root = FXMLLoader.load(getClass().getResource("/account_billing/Login.fxml"));

                                                                                                                                                                Scene scene = new Scene(root);
                                                                                                                                                                 Stage stage=new Stage();
                                                                                                                                                                stage.setScene(scene);
                                                                                                                                                                stage.show();

                                                                                                                                                                //Login
                                                                                                                             
                                                                                                                 }
                                                                                                                 else
                                                                                                                {
/*  CREATE TABLE "SYSTEM"."OSIER_ACCOUNT" 
("OWNER_NAME" VARCHAR2(20 BYTE) NOT NULL ENABLE, 
"MOBILE_NUMBER" VARCHAR2(10 BYTE) NOT NULL ENABLE, 
"EMAIL" VARCHAR2(20 BYTE) NOT NULL ENABLE, 
"GENDER" VARCHAR2(6 BYTE) NOT NULL ENABLE, 
"PASSWORD" VARCHAR2(20 BYTE) NOT NULL ENABLE, 
"FLAG" NUMBER(2,0) NOT NULL ENABLE, 
CONSTRAINT "OSIER_ACCOUNT_PK" PRIMARY KEY ("EMAIL")
*/                                                                                                            System.out.println("=================> Preparstatement Query  = ");

                                                                                                                                   PreparedStatement ps  =c.prepareStatement("insert into OSIER_ACCOUNT values(?,?,?,?,?,?)");// addd coloum for flag


                                                                                                                                   ps.setString(1,owner_name.getText());	
                                                                                                                                   ps.setString(2,mobile_Number.getText());
                                                                                                                                   ps.setString(3,email.getText());
                                                                                                                                   ps.setString(4,gen);       
                                                                                                                                   ps.setString(5,password.getText());
                                                                                                                                   ps.setInt(6,1);
/*

CREATE TABLE "SYSTEM"."PASS" 
 (	"NAME" VARCHAR2(20 BYTE), 
      "PAS" VARCHAR2(20 BYTE)
 )                                                                                                                 
*/                                                                                                                    System.out.println("=================> preprsttatement query 2  = ");

                                                                                                                                       PreparedStatement ps1  =c.prepareStatement("insert into PASS values(?,?)");    
                                                                                                                                       ps1.setString(1, email.getText());
                                                                                                                                       ps1.setString(2, password.getText());
                                                                                                                                       ps1.executeUpdate();

                                                                                                                                   owner_name.setEditable(true);
                                                                                                                                 
                                                                                                                                   email.setEditable(true);
                                                                                                                                   mobile_Number.setEditable(true);
                                                                                                                                   password.setEditable(true);
                                                                                                                                   re_Password.setEditable(true);
                                                                                                            System.out.println("=================> befor apdate  = ");

                                                                                                                                    int result=ps.executeUpdate();
                                                                                                            System.out.println("=================> after update = ");

                                                                                                                                                       if(result > 0 )
                                                                                                                                                       {
                                                                                                                                                       
                                                                                                                                             System.out.println("=================> In Update Reselet   = ");

                                                                                                                                                    Parent parent = FXMLLoader.load(getClass().getResource("/updatework/RegisterSuccessBox.fxml"));
                                                                                                                                                    anchor.getChildren().setAll(parent);
//                                                                                                                                                           
//                                                                                                                                                           Parent parent = FXMLLoader.load(getClass().getResource("RegisterSuccessBox.fxml"));
//                                                                                                                                                          Scene scene = new Scene(parent);
//                                                                                                                                                          Stage stage = new Stage();
//
//                                                                                                                                                          stage.setTitle("Osier Account");
//                                                                                                                                                          stage.setScene(scene);
//                                                                                                                                                          stage.show();
                                                                                                                                                          
                                                                                                                                                           
                                                                                                                                                       }
                                                                                                                                                       else
                                                                                                                                                       {
                                                                                                                                                    System.out.println("=================> In Update elsel   = ");
                                                                                                                                                                  al.setTitle("SQLException");
                                                                                                                                                                   al.setHeaderText(null);
                                                                                                                                                                   al.setContentText("You have not  OSIER ACCOUNT Created  ");
                                                                                                                                                                    al.show();
                                                                                                                                                       }
                                                                                                                 }

                                                                                                           stm.close();
                                                                                                           c.close();
                                                                                                   }
                                                                                                   catch(ClassNotFoundException cnf)
                                                                                                   {   
                                                                                                                       System.out.println("Cnf Exception");
                                                                                                   }
                                                                                                   catch(SQLException sql)
                                                                                                   {
                                                                                                                         al.setTitle("Validation");
                                                                                                                         al.setHeaderText(null);
                                                                                                                        al.setContentText("Problem in query or database ");
                                                                                                                        al.show();
                                                                                                   }
                                                                             }
                                                                            else
                                                                            {
                                                                                                               al.setTitle("Validation");
                                                                                                               al.setHeaderText(null);
                                                                                                               al.setContentText("Both password must not same");
                                                                                                               al.show();
                                                                            }
                                                             
                                                            }
                                                            else
                                                            {
                                                                        System.out.println(" validation else");
                                                             }
//                                                                    
//                                                            owner_name.setText("");
//                                                            email.setText("");
//                                                            mobile_Number.setText("");
//                                                            password.setText("");
//                                                            re_Password.setText("");
                        }

                        @FXML
                        private void clickOnCancel(ActionEvent event)
                        {

                                                  System.exit(0);

                        }
                                                  
                       /// Validation Method here below

                                                private boolean validateField()
                                                {
                                                                if(owner_name.getText().isEmpty() |email.getText().isEmpty() |mobile_Number.getText().isEmpty()|password.getText().isEmpty() |re_Password.getText().isEmpty())
                                                                   {

                                                                       al.setTitle("Validate Fields");
                                                                       al.setHeaderText(null);
                                                                       al.setContentText("Please Enter Into the fields ");
                                                                       al.showAndWait();
                                                                       return false;
                                                                   }
                                            //                    if(date.getEiditor().getText().isEmapty())
                                            //                    {
                                            //                          Alert al= new Alert(AlertType.WARNING);
                                            //                           al.setTitle("Validate Fields");
                                            //                           al.setHeaderText(null);
                                            //                           al.setContentText("Please Enter Into the fields ");
                                            //                           al.showAndWait();
                                            //                           return false;
                                            //                    }
                                            
                                                            return true;
                                                }  




//                                                private boolean validateFirstName()
//                                                {
//                                                            Pattern p = Pattern.compile("[a-zA-Z]+");
//                                                            Matcher m =p.matcher(owner_name.getText());
//                                                            if(m.find() && m.group().equals(owner_name.getText()))
//                                                            {
//                                                                return true;
//                                                            }else
//                                                            {
//
//                                                                al.setTitle("Validate owner name");
//                                                                al.setHeaderText(null);
//                                                                al.setContentText("Owner Name Must be start with character ");
//                                                                al.showAndWait();
//                                                                return false;
//                                                            }
//                                                }

                                                 private boolean validateEmail()
                                                {
                                                            Pattern p = Pattern.compile("[a-zA-z0-9][a-zA-z0-9._]*@[a-zA-z0-9]+([.][a-zA-Z]+)+");
                                                            Matcher m =p.matcher(email.getText());
                                                            
                                                            if(m.find() && m.group().equals(email.getText()))
                                                            {
                                                                return true;
                                                            }
                                                            else
                                                            {

                                                                al.setTitle("Validate Email");
                                                                al.setHeaderText(null);
                                                                al.setContentText("Please Enter Valid Email ");
                                                                al.showAndWait();
                                                                return false;
                                                            }
                                                }
                                                 
                                          //"[a-zA-z0-9][a-zA-z0-9._]*@[a-zA-z0-9]+([.][a-zA-Z]+)+"      
                                                 
                                                 private boolean validatePassword()
                                                {
                                                            Pattern p = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,15})");
                                                            Matcher m =p.matcher(password.getText());
                                                            
                                                            if(m.matches())
                                                            {
                                                                return true;
                                                            }
                                                            else
                                                            {

                                                                al.setTitle("Validate Password");
                                                                al.setHeaderText(null);
                                                                al.setContentText("Password must contain at list one(Digit , Lowercase , Uppercase ,special character) and length between 6-15 ) ");
                                                                al.showAndWait();
                                                                return false;
                                                            }
                                                }
                                                 
                                                 private boolean validateNumber()
                                                {
                                                            Pattern p = Pattern.compile("^(?:(?:\\+|0{0,2})91(\\s*[\\-]\\s*)?|[0]?)?[789]\\d{9}$");
                                                            Matcher m =p.matcher(mobile_Number.getText());
                                                            if(m.find() && m.group().equals(mobile_Number.getText()))
                                                            {
                                                                return true;
                                                            }
                                                            else
                                                            {

                                                                al.setTitle("Validate Mobile Number");
                                                                al.setHeaderText(null);
                                                                al.setContentText("Please Enter Valid Mobile Number ");
                                                                al.showAndWait();
                                                                return false;
                                                            }
                                                }
    
}