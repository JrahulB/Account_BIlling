/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package updatework;

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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javax.swing.JOptionPane;


/**
 * FXML Controller class
 *
 * @author G1 NOTEBOOK
 */
public class Register_Details_UpdateController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    int t;
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
    Alert al= new Alert(Alert.AlertType.WARNING);

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
     @FXML
     private void loadactinPerformed(ActionEvent event) throws SQLException, ClassNotFoundException{
         int t=0;
   System.out.println("in loadactionperfomed");
         try
	{
                            //  System.out.println("in try");
	    Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
	    Statement stm = c.createStatement();
                                //System.out.println("connection is established");
            t = 0;
	    ResultSet rs = stm.executeQuery("select * from osier_account where owner_name='"+owner_name.getText()+"'");
				//System.out.println("mother name"+Mother_name.getText());
                                
                while(rs.next())
		{
                                  //  System.out.println("in while");
		    t=1;	
		
		    owner_name.setText(rs.getString("owner_name"));
                    mobile_Number.setText(rs.getString("mobile_Number"));
                   email.setText(rs.getString("email"));
		          ;
                          if("male".equals(rs.getString("gender"))){
                              male.setSelected(true);
                              }
                          else{
                              female.setSelected(true);
                              
                          }
		   password.setText(rs.getString("password"));
                   // account_No.setText(rs.getString("account_No"));
		   // confim_Account_No.setText(rs.getString("account_No"));
		   // ifsc_No.setText(rs.getString("ifsc"));
                   // confirm_Ifsc_No.setText(rs.getString("ifsc"));
                                       //  System.out.println("School_name"+School_name.getText());
                                        //  System.out.println("Lucky_number"+Lucky_number.getText());
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

               
                    
 @FXML
private void changeactinPerformed(ActionEvent event) throws SQLException, ClassNotFoundException
       {
            int t = 0;
            
            if(validateField()  & validateEmail() & validateNumber() & validatePassword())
                {

                 if(password.getText().equals(re_Password.getText()) ) 
                     {
                                                                                                    
                               System.out.println(" iiii am   jjjj");
    	      try
	       {
		    Class.forName("oracle.jdbc.driver.OracleDriver");
		    Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
		    Statement stm = c.createStatement();		
				
				//{
					ResultSet rs1 = stm.executeQuery("select * from osier_account where owner_name='"+owner_name.getText()+"'");
					while(rs1.next())
					{	
                                            t = 1;
					}
					if(t==1)
					{
						t=0;
						if((owner_name.getText()).length()!=0)
						{
							PreparedStatement ps=c.prepareStatement("Update osier_account set owner_name=? where owner_name='"+owner_name.getText()+"'");	
							ps.setString(1,owner_name.getText());	
                                                        ps.executeUpdate();
						}
                                                
                                                if((mobile_Number.getText()).length()!=0)
						{
							PreparedStatement ps=c.prepareStatement("Update osier_account set mobile_Number=? where owner_name='"+owner_name.getText()+"'");	
							ps.setString(1,mobile_Number.getText());	
                                                        ps.executeUpdate();
						}
                                                
                                                
                                                if((email.getText()).length()!=0)
						{
							PreparedStatement ps=c.prepareStatement("Update osier_account set email=? where owner_name='"+owner_name.getText()+"'");	
							ps.setString(1,email.getText());	
                                                        ps.executeUpdate();
						}
                                                
                                                
                                                if(female.isSelected()){
                                                   gen="female";
                                                   PreparedStatement ps=c.prepareStatement("Update osier_account set gender=? where owner_name='"+owner_name.getText()+"'");	
							ps.setString(1,gen);	
                                                        ps.executeUpdate();
                                                   
                                                }
                                                
                                                 if((password.getText()).length()!=0)
						{
							PreparedStatement ps=c.prepareStatement("Update osier_account set password=? where owner_name='"+owner_name.getText()+"'");	
							ps.setString(1,password.getText());	
                                                        ps.executeUpdate();
						}
						
                                               jp.showMessageDialog(null,"Record Updated Successfully","SUCCESS",jp.INFORMATION_MESSAGE);
						/* acc_no.setText(null);
						ifsc.setText(null);
					        name.setText(null);
						gst_no.setText(null);
						address.setText(null);
						tel_no.setText(null);
                                               // acc_type.setText(null)
						mob_no.setText(null);
                                                pan.setText(null);
                                                aadhar.setText(null);
                                                bname.setText(null);   */
                                               
                        
					}
					else
					{
				         jp.showMessageDialog(null,"Sorry, No Such Record exisits","INFORMATION",jp.ERROR_MESSAGE);
				        }
					
				//}
			
			c.close();
			stm.close();
			}
                     
			catch(ClassNotFoundException cnf)
			{
				System.out.println("Cnf Exception");
			}
			catch(SQLException sql)
			{
				jp.showMessageDialog(null,sql,"EXCEPTION",jp.ERROR_MESSAGE);
			}
                     }else
                    {
                            al.setTitle("Validation");
                            al.setHeaderText(null);
                            al.setContentText("Password missmached");
                            al.showAndWait();

                    }
                }
              
              
              
       }
                       /// Validation Method here below

                                                public boolean validateField()
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

        
    
    
   
    
    
    @FXML
     public void clickOnCacel(ActionEvent event){
        
    }
    
}
