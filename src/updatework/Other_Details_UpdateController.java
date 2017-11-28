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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author G1 NOTEBOOK
 */
public class Other_Details_UpdateController implements Initializable {
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
    
   // int t;
    
    JOptionPane jp=new JOptionPane();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("in initialize");
        // TODO
    }   
        @FXML
     private void loadactinPerformed(ActionEvent event) throws SQLException, ClassNotFoundException{
         int t=0;
   System.out.println("in loadactionperfomed");
         try
			{
                            System.out.println("in try");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
				Statement stm = c.createStatement();
                                System.out.println("connection is established");
                                 t = 0;
				ResultSet rs = stm.executeQuery("select * from other_details where Mother_name='"+Mother_name.getText()+"'");
				System.out.println("mother name"+Mother_name.getText());
                                
                                while(rs.next())
				{
                                    System.out.println("in while");
					t=1;	
		
			   
					
			                Mother_name.setText(rs.getString("Mother_name"));
                                       Lucky_number.setText(rs.getString("Lucky_number"));
                                      Favorite_colour.setText(rs.getString("Favorite_colour"));
				        Best_friend_name.setText(rs.getString("Best_friend_name"));
					School_name.setText(rs.getString("School_name"));
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
private void changeactinPerformed(ActionEvent event) throws SQLException, ClassNotFoundException{
    int t = 0;
    	              try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
				Statement stm = c.createStatement();
				
				//{
					ResultSet rs1 = stm.executeQuery("select * from other_details where  Mother_name='"+ Mother_name.getText()+"'");
					while(rs1.next())
					{	
                                            t = 1;
					}
					if(t==1)
					{
						t=0;
						if((Mother_name.getText()).length()!=0)
						{
							PreparedStatement ps=c.prepareStatement("Update other_details set Mother_name=? where Mother_name='"+Mother_name.getText()+"'");	
							ps.setString(1,Mother_name.getText());	
                                                        ps.executeUpdate();
						}
						
						
                                               if((Lucky_number.getText()).length()!=0)
						{
							PreparedStatement ps=c.prepareStatement("Update other_details set Lucky_number=? where Mother_name='"+Mother_name.getText()+"'");	
							ps.setString(1,Lucky_number.getText());
                                                        ps.executeUpdate();
						}
                                               
                                               if((Favorite_colour.getText()).length()!=0)
						{
							PreparedStatement ps=c.prepareStatement("Update other_details set Favorite_colour=? where Mother_name='"+Mother_name.getText()+"'");	
							ps.setString(1,Favorite_colour.getText());	
                                                        ps.executeUpdate();
						}
                                               
                                               if((Best_friend_name.getText()).length()!=0)
						{
							PreparedStatement ps=c.prepareStatement ("Update other_details set Best_friend_name=? where Mother_name='"+Mother_name.getText()+"'");	
							ps.setString(1,Best_friend_name.getText());	
                                                        ps.executeUpdate();
						}
                                               
                                               if((School_name.getText()).length()!=0)
						{
							PreparedStatement ps=c.prepareStatement ("Update other_details set School_name=? where Mother_name='"+Mother_name.getText()+"'");	
							ps.setString(1,School_name.getText());	
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

}

        
   
   
    

    @FXML
    private void clickOnCancel(ActionEvent event) {
        System.exit(0);
    }
    
}
