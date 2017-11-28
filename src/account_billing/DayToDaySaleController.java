
package account_billing;

import com.osiersystems.pojos.Day;

//DATABASE 
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//JAVA 
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
//JAVAFX
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.util.StringConverter;

import javax.swing.JOptionPane;

public class DayToDaySaleController implements Initializable 
{
    @FXML
    private TableView<Day> table;
     @FXML
    private TableColumn<Day, Integer> Billno;
     @FXML
    private TableColumn<Day, String> customername;
     @FXML
    private TableColumn<Day, String> Itemname;
     @FXML
    private TableColumn<Day, Integer> quantity;
     @FXML
    private TableColumn<Day, Integer> total;

     
     JOptionPane jp = new JOptionPane();
    
    @FXML
    private DatePicker date ,date1;
    
    int t=0;
     int lst_num;
   String day;
    
   private  ObservableList<Day> list = FXCollections.observableArrayList();
    private Object item;
    @FXML
    private ComboBox day_to_day;
    /**
     * Initializes the controller class.
     */
     @FXML
    private void showMethod(ActionEvent event) throws Exception
    {
         try
	{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			Statement stm = c.createStatement();
			t=0;
			ResultSet rs;
                         //String day =null;
			if(day_to_day.getSelectionModel().getSelectedItem().equals("All"))
                                                                {
                         			
			   rs = stm.executeQuery("select  * from daily where D1 between '"+((TextField)date.getEditor()).getText()+"'and '"+((TextField)date1.getEditor()).getText()+"'");
			}
                                                            	else
			  rs = stm.executeQuery("select  * from daily where D1 between '"+((TextField)date.getEditor()).getText()+"'and '"+((TextField)date1.getEditor()).getText()+"'and items='"+day_to_day.getSelectionModel().getSelectedItem()+"'");

			while(rs.next())
                        {
                       t=1;
                      list.add(new Day(
                       rs.getInt("SRNO"),
                       rs.getString("CUSNAME"),
                       rs.getString("ITEMS"),
                        rs.getInt("QUANTITY"),
                       rs.getInt("TOTAL")
               ));
                      }
              table.setItems(list);
//			
			{
				//jp.showMessageDialog(null,"Sorry, No Such Record exisits","INFORMATION",jp.ERROR_MESSAGE);
				//this.t=0;
			}
                                                                c.close();
			stm.close();
	
		
	}
                    catch (ClassNotFoundException ex) 
                   {
                    Logger.getLogger(DayWiseSaleController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) 
                    {
                    Logger.getLogger(DayWiseSaleController.class.getName()).log(Level.SEVERE, null, ex);
                    }

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
           Billno.setCellValueFactory(new PropertyValueFactory<>("Billno"));
        customername.setCellValueFactory(new PropertyValueFactory<>("name"));
        Itemname.setCellValueFactory(new PropertyValueFactory<>("Itemname"));
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        total.setCellValueFactory(new PropertyValueFactory<>("total"));
      
        //set date Pattern to FromDate
      date.setConverter(new StringConverter<LocalDate>() 
                                                                                        {
                                                                                       String pattern = "dd-MMM-yyyy";
                                                                                       DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

                                                                                       {
                                                                                           date.setPromptText(pattern.toLowerCase());
                                                                                       }

                                                                                       @Override public String toString(LocalDate date) 
                                                                                       {
                                                                                           if (date != null) 
                                                                                           {
                                                                                               return dateFormatter.format(date);
                                                                                           } 
                                                                                           else 
                                                                                           {
                                                                                               return "";
                                                                                           }
                                                                                       }

                                                                                       @Override public LocalDate fromString(String string) 
                                                                                       {
                                                                                           if (string != null && !string.isEmpty()) 
                                                                                           {
                                                                                               return LocalDate.parse(string, dateFormatter);
                                                                                           }
                                                                                           else 
                                                                                           {
                                                                                               return null;
                                                                                           }
                                                                                       }
                        });
      
      
       //set date Pattern to FromDate
      date1.setConverter(new StringConverter<LocalDate>() 
                                                                                            {
                                                                                           String pattern = "dd-MMM-yyyy";
                                                                                           DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

                                                                                           {
                                                                                               date1.setPromptText(pattern.toLowerCase());
                                                                                           }

                                                                                           @Override public String toString(LocalDate date) 
                                                                                           {
                                                                                               if (date != null) 
                                                                                               {
                                                                                                   return dateFormatter.format(date);
                                                                                               }
                                                                                               else 
                                                                                               {
                                                                                                   return "";
                                                                                               }
                                                                                           }

                                                                     @Override public LocalDate fromString(String string) 
                                                                     {
                                                                         if (string != null && !string.isEmpty()) 
                                                                         {
                                                                             return LocalDate.parse(string, dateFormatter);
                                                                         }
                                                                         else
                                                                         {
                                                                             return null;
                                                                         }
                                                                     }
                                                     });
	
        
        //set srno from bill table
        try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection c1 =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
	
		ArrayList<Integer> ar = new ArrayList<Integer>();
		PreparedStatement ps1 = c1.prepareStatement("select D1 from daily");
		
		ResultSet rs = ps1.executeQuery();
		while(rs.next())
		{
			//ar.add(rs.getInt("D1"));
		}
	  
		}
		 catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //set items to combobox from items table from database
         try{
    		
    	    Class.forName("oracle.jdbc.driver.OracleDriver");
		    Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			Statement stm = c.createStatement();
			ResultSet rs = stm.executeQuery("select name from items");
			   				
			while(rs.next())
			{
				day_to_day.getItems().addAll(rs.getString("name"));
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
    		System.out.println("DB connectivity issue");
    	}
         // Add units to unit combobox
      //  day_wise.getItems().removeAll(day_wise.getItems());
        //day_wise.getItems().addAll("Dozens", "Gms", "kgs.","Meter","Pcs.","Tonne");
       // items1.getItems().addAll("jeans","shirt");

         // items1.getSelectionModel().select("jeans");
        
    }    
    }    
    
