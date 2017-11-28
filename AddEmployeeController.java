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
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ACER
 */
public class AddEmployeeController implements Initializable {
    @FXML
    private TextField id,name,address,salary,job,qualification,phone;
    @FXML
    private DatePicker birthday;
    JOptionPane jp = new JOptionPane();
    int lst_num;
    int t=0,flag=0;
    java.text.SimpleDateFormat sdf =  new java.text.SimpleDateFormat("dd-MMM-yyyy");
    @FXML
    private void addEmployee(ActionEvent event) throws SQLException, ClassNotFoundException{
        //inserting Employee Records in emp table
        flag=0;
        try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			Statement stm = c.createStatement();
			t=0;
			if(phone.getText().length()!=10)
			jp.showMessageDialog(null,"Phone Number Must Have 10 Digits","INFORMATION",jp.ERROR_MESSAGE);
			else
			{
					t=0;
					
					PreparedStatement ps  = c.prepareStatement("insert into emp values(?,?,TO_DATE('"+((TextField)birthday.getEditor()).getText()+"', 'MM/DD/YYYY'),?,?,?,?,?)");
					
					
					if((id.getText()).length()!=0)
					ps.setString(1,id.getText());
					else
					ps.setString(1,"");
					if((name.getText()).length()!=0)
					ps.setString(2,name.getText());	
					else
					ps.setString(2,"");	
					//if((birthday.getAccessibleText()).length()!=0)
					//ps.setString(3,((TextField)birthday.getEditor()).getText());
					//else
					//ps.setString(3,"");
					if((qualification.getText()).length()!=0)
					ps.setString(3,qualification.getText());
					else
					ps.setString(3,"");
					if((job.getText()).length()!=0)
					ps.setString(4,job.getText());
					else
					ps.setString(4,"");
					if((salary.getText()).length()!=0)
					ps.setString(5,salary.getText());
					else
					ps.setString(5,"");
					if((phone.getText()).length()!=0)
					ps.setString(6,phone.getText());
					else
					ps.setString(6,"");
                                        if((address.getText()).length()!=0)
					ps.setString(7,address.getText());
					else
					ps.setString(7,"");
					
					id.setEditable(true);
					name.setEditable(true);
					//birthday.setEditable(true);
					qualification.setEditable(true);
					job.setEditable(true);
					salary.setEditable(true);
					phone.setEditable(true);
                                        address.setEditable(true);

					
					ps.executeUpdate();
					jp.showMessageDialog(null,"Employee Added Successfully","SUCCESS",jp.INFORMATION_MESSAGE);
					flag=1;
                        }
			c.close();
			stm.close();
		
			}
			catch(ClassNotFoundException cnf)
			{
                            cnf.printStackTrace();
                            System.out.println("Cnf Exception");
			}
			catch(SQLException sql)
			{
                            sql.printStackTrace();
                            jp.showMessageDialog(null,sql,"EXCEPTION",jp.ERROR_MESSAGE);
			}
                        if(flag==1)
			{
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
									
				PreparedStatement ps  = c.prepareStatement("CREATE TABLE e"+id.getText()+"(DAY DATE,PRE NUMBER,PRIMARY KEY(DAY))");
				ps.executeUpdate();
			}
			catch(ClassNotFoundException cnf)
			{
				jp.showMessageDialog(null,cnf,"EXCEPTION",jp.ERROR_MESSAGE);
				System.out.println("Cnf Exception");
			}
			catch(SQLException sql)
			{
				sql.printStackTrace();
				jp.showMessageDialog(null,sql,"EXCEPTION",jp.ERROR_MESSAGE);
			}
			}
			
			id.setText(null);
			name.setText(null);
                        address.setText(null);
			birthday.setValue(null);
			qualification.setText(null);
			job.setText(null);
			salary.setText(null);
			phone.setText(null);
                       //After Adding Employee next time ID is incrementing
                       try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection c1 =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
		
			ArrayList<Integer> ar = new ArrayList<Integer>();
			PreparedStatement ps1 = c1.prepareStatement("select id from emp");
			
			ResultSet rs = ps1.executeQuery();
			while(rs.next())
			{
				ar.add(rs.getInt("id"));
			}
		    Collections.sort(ar);
		    if(ar.size()>0)
		    {
			lst_num = ar.get(ar.size()-1);
		    }
			else
			{
				lst_num=0;
			}
			id.setText(""+(lst_num+1));
			id.setEditable(false);
			}
			 catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // initializing ID to Id text field from emp table
        try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection c1 =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
	
		ArrayList<Integer> ar = new ArrayList<Integer>();
		PreparedStatement ps1 = c1.prepareStatement("select id from emp");
		
		ResultSet rs = ps1.executeQuery();
		while(rs.next())
		{
			ar.add(rs.getInt("id"));
		}
	    Collections.sort(ar);
	    if(ar.size()>0)
	    {
		lst_num = ar.get(ar.size()-1);
	    }
		else
		{
			lst_num=0;
		}
		id.setText(""+(lst_num+1));
		id.setEditable(false);
		}
		 catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }    
    
}
