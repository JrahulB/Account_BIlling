/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package account_billing;

import java.awt.Font;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ACER
 */
public class EmployeeAttendanceController implements Initializable {
    JOptionPane jp = new JOptionPane();
    int t=0,in=0,i,x=70,y=140;
    int id[]=new int[50];
    Integer tem=new Integer(0);
    @FXML
   CheckBox emid[]=new CheckBox[50];
     @FXML
     private BorderPane pane;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Dynamically create checkboxes from employee id
      try
			{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			Statement stm = c.createStatement();
			ResultSet rs = stm.executeQuery("select * from emp");
			t=0;
			while(rs.next())
			{
				id[in++]=rs.getInt("id");
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
		
		for(i=0;i<in;i++)
		{
			tem=id[i];
			emid[i]=new CheckBox(tem.toString(tem));
		}
		for(i=0;i<in;i++)
		{
			//emid[i].setBounds(x,y+=30,50,20);
			//emid[i].setFont(new Font("Calibri", Font.BOLD, 20));
			pane.getChildren().setAll(emid);
			if(y>=600)
			{
				y=140;
				x+=60;
			}
		}
    }  
}


