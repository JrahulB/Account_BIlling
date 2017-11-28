/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account_billing;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class EditEmployeeController implements Initializable {
    @FXML
    private Label ename,eaddress,edob,ejob,equal,esalary,epho,id1;
    @FXML
    private Button load,change;
    @FXML
    private TextField name,address,job,qual,sal,pho,id;
     JOptionPane jp = new JOptionPane();
     @FXML
    private AnchorPane pane;
     @FXML
     int t;
     @FXML
     private DatePicker dob;
    private Object datePicker;
    /**
     * Initializes the controller class.
     */
     @FXML
private void loadactinPerformed(ActionEvent event) throws SQLException, ClassNotFoundException
{
   try
			{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
				Statement stm = c.createStatement();
                                int t = 0;
				ResultSet rs = stm.executeQuery("select * from emp where name='"+name.getText()+"'");
				while(rs.next())
				{	
					t=1;	
		
			   
					id.setText(rs.getString("id"));
					id.setEditable(false);
			                                  name.setText(rs.getString("name"));
//                                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");
//                                        LocalDate date = datePicker.getValue();
//                                         if (date != null) {
//                                      display.setText(formatter.format(date));
//                                          } else {
//                                          display.setText("");
//                                          }
					//dob.(rs.getString("dob"));
					//dob.setValue(1,rs.getDate("dob"));
                                        java.sql.Date deadlineDatePrompt = rs.getDate("DOB");
                                        dob.setValue(deadlineDatePrompt.toLocalDate());
					qual.setText(rs.getString("Qual"));
					job.setText(rs.getString("JOB"));
				
					sal.setText(rs.getString("SAL"));
					pho.setText(rs.getString("PHO"));
					
					
			        
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
    	try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
				Statement stm = c.createStatement();
				if(pho.getText().length()!=10)
				jp.showMessageDialog(null,"Phone Number Must Have 10 Digits","INFORMATION",jp.ERROR_MESSAGE);
				else
				{
					ResultSet rs1 = stm.executeQuery("select * from emp where name='"+name.getText()+"'");
					while(rs1.next())
					{	
                                            t = 1;
					}
					if(t==1)
					{
						t=0;
						if((name.getText()).length()!=0)
						{
							PreparedStatement ps=c.prepareStatement ("Update emp set name=? where name='"+name.getText()+"'");	
							ps.setString(2,name.getText());	ps.executeUpdate();
						}
						//if((dob.gets))
						{
							PreparedStatement ps=c.prepareStatement ("Update emp set dob=(TO_DATE('"+((TextField)dob.getEditor()).getText()+"', 'DD/MM/YYYY')) where name="+name.getText());	
							//ps.setString(3, (String) dob.getSelectedmodel().getSelectedItem())
                                                                ps.executeUpdate();
                                                }
						if((qual.getText()).length()!=0)
						{
							PreparedStatement ps=c.prepareStatement ("Update emp set qual=? where name='"+name.getText()+"'");	
							ps.setString(4,qual.getText());ps.executeUpdate();
						}
						
						if((job.getText()).length()!=0)
						{
							PreparedStatement ps=c.prepareStatement ("Update emp set job=? where name='"+name.getText()+"'");	
							ps.setString(5,job.getText());ps.executeUpdate();
						}
						if((sal.getText()).length()!=0)
						{
							PreparedStatement ps=c.prepareStatement ("Update emp set sal=? where name='"+name.getText()+"'");	
							ps.setString(6,sal.getText());ps.executeUpdate();
						}
						
						if((pho.getText()).length()!=0)
						{
							PreparedStatement ps=c.prepareStatement ("Update emp set pho=? where name='"+name.getText()+"'");	
							ps.setString(7,pho.getText());ps.executeUpdate();
						}
						
						jp.showMessageDialog(null,"Record Updated Successfully","SUCCESS",jp.INFORMATION_MESSAGE);
						id.setText(null);
						job.setText(null);
						name.setText(null);
						sal.setText(null);
						pho.setText(null);
						//dob.setText(null);
						qual.setText(null);	
						id.setEditable(true);
					}
					else
					{
						jp.showMessageDialog(null,"Sorry, No Such Record exisits","INFORMATION",jp.ERROR_MESSAGE);
						t=0;
		
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
				JOptionPane.showMessageDialog(null,sql,"EXCEPTION",JOptionPane.ERROR_MESSAGE);
			}
    
    
}

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
