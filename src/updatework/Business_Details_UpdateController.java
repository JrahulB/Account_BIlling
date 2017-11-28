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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author G1 NOTEBOOK
 */
public class Business_Details_UpdateController implements Initializable {
    @FXML
    private TextField Business_name;
    @FXML
    private TextArea Business_address;
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
    int t;
JOptionPane jp=new JOptionPane();
 Alert alert=new Alert(Alert.AlertType.WARNING);   
/**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
       {
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
	    ResultSet rs = stm.executeQuery("select * from business_details where Business_name='"+Business_name.getText()+"'");
				//System.out.println("mother name"+Mother_name.getText());
                                
                while(rs.next())
		{
                                  //  System.out.println("in while");
		    t=1;	
		
		    Business_name.setText(rs.getString("Business_name"));
                    Business_address.setText(rs.getString("Business_address"));
                    business_Registraction_No.setText(rs.getString("business_Registration_No"));
		    gst_No.setText(rs.getString("gst_in_No"));
		    bank_Name.setText(rs.getString("bank_Name"));
                    account_No.setText(rs.getString("account_No"));
		    confim_Account_No.setText(rs.getString("account_No"));
		    ifsc_No.setText(rs.getString("ifsc"));
                    confirm_Ifsc_No.setText(rs.getString("ifsc"));
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
    	      try
	       {
		    Class.forName("oracle.jdbc.driver.OracleDriver");
		    Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
		    Statement stm = c.createStatement();		
				
				//{
                     if(validateField() & validateIfscNumber())
                    {
                                                                      
                                                                  
                            if((account_No.getText().equals(confim_Account_No.getText())) &&(ifsc_No.getText().equals(confirm_Ifsc_No.getText()))) 
                            {
					ResultSet rs1 = stm.executeQuery("select * from business_details where Business_name='"+Business_name.getText()+"'");
					while(rs1.next())
					{	
                                            t = 1;
					}
					if(t==1)
					{
						t=0;
						if((Business_name.getText()).length()!=0)
						{
							PreparedStatement ps=c.prepareStatement("Update business_details set Business_name=? where Business_name='"+Business_name.getText()+"'");	
							ps.setString(1,Business_name.getText());	
                                                        ps.executeUpdate();
						}
						
                                                if((Business_address.getText()).length()!=0)
						{
							PreparedStatement ps=c.prepareStatement("Update business_details set Business_address=? where Business_name='"+Business_name.getText()+"'");	
							ps.setString(1,Business_address.getText());	
                                                        ps.executeUpdate();
                                                        System.out.println("changed business address"+Business_address.getText());
						}
                                                   if((business_Registraction_No.getText()).length()!=0)
						{
							PreparedStatement ps=c.prepareStatement("Update business_details set business_Registration_No=? where Business_name='"+Business_name.getText()+"'");	
							ps.setString(1,business_Registraction_No.getText());	
                                                        ps.executeUpdate();
						}
						
                                                    if((gst_No.getText()).length()!=0)
						{
							PreparedStatement ps=c.prepareStatement("Update business_details set gst_in_No=? where Business_name='"+Business_name.getText()+"'");	
							ps.setString(1, gst_No.getText());	
                                                        ps.executeUpdate();
						}
						
                                                    
                                                    if((bank_Name.getText()).length()!=0)
						{
							PreparedStatement ps=c.prepareStatement("Update business_details set bank_Name=? where Business_name='"+Business_name.getText()+"'");	
							ps.setString(1,bank_Name.getText());	
                                                        ps.executeUpdate();
						}
						
						
                                                     if((account_No.getText()).length()!=0)
						{
							PreparedStatement ps=c.prepareStatement("Update business_details set account_No=? where Business_name='"+Business_name.getText()+"'");	
							ps.setString(1,account_No.getText());	
                                                        ps.executeUpdate();
						}
						
						 
                                                      if((ifsc_No.getText()).length()!=0)
						{
							PreparedStatement ps=c.prepareStatement("Update business_details set ifsc=? where Business_name='"+Business_name.getText()+"'");	
							ps.setString(1,ifsc_No.getText());	
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
                            }else
                            {
                                 alert.setTitle("Validation");
                                    alert.setHeaderText(null);
                                    alert.setContentText("Field missmach");
                                    alert.showAndWait(); 
                            }
                       }
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

}

        
    
    @FXML
     public void clickOnCancel(ActionEvent event)
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
