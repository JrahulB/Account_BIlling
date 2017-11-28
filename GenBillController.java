/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account_billing;

import com.osiersystems.pojos.Order;
import com.osiersystems.pojos.AutoCompleteComboBoxListener;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import javax.swing.JOptionPane;
import org.controlsfx.control.textfield.TextFields;
import org.ietf.jgss.GSSName;
/**
 * FXML Controller class
 *
 * @author user
 */
public class GenBillController implements Initializable {

    @FXML
    private TextField srno,date,mob_no,cost,quantity1,total1,stock1,net_total,cgst,sgst,address,pan_no,hsn_code,total_qty,total_rate,c_rate,total_amount,s_rate,s_amount,total_hsn;
    @FXML
    private ComboBox units1,cus_name,trans_mode;
    @FXML
    private Label label_cgst,label_sgst;
     @FXML
    private ComboBox<String> items1;
    @FXML
    private TextField auto;
    //Configure the table
    @FXML
    private TableView<Order> table;
    @FXML
    private TableColumn<Order, String> items;
    @FXML
    private TableColumn<Order, String> units;
    @FXML
    private TableColumn<Order, Integer> quantity;
    @FXML
    private TableColumn<Order, Integer> rate;
    @FXML
    private TableColumn<Order, Integer> total;
    @FXML
    private TableColumn<Order, Integer> table_cgst;
     @FXML
    private TableColumn<Order, Integer> cgst_rate;
      @FXML
    private TableColumn<Order, Integer> cgst_amount;
    @FXML
    private TableColumn<Order, Integer> table_sgst;
    @FXML
    private TableColumn<Order, Integer> sgst_rate;
      @FXML
    private TableColumn<Order, Integer> sgst_amount;
    @FXML
    private TableColumn<Order, Integer> hsncode;
   private  ObservableList<Order> list = FXCollections.observableArrayList();
    int lst_num;
    JOptionPane jp = new JOptionPane();
    
    //Add Button Action part 
     @FXML
    private void tableEntry(ActionEvent event) throws Exception{
      //add rows to table
      if(mob_no.getText().isEmpty())
             	{
                    jp.showMessageDialog(null,"Please Add Customer Name"," ",jp.INFORMATION_MESSAGE);
                    cost.setText(null);
                    quantity1.setText(null);
                    total1.setText(null);
                    stock1.setText(null);
             	}
                list.add(new Order(
                     (String)items1.getSelectionModel().getSelectedItem(),
                      Integer.parseInt(quantity1.getText()),
                     (String) units1.getSelectionModel().getSelectedItem(),
                      Integer.parseInt(cost.getText()),
                     (Integer.parseInt( total1.getText())),
                     (Integer.parseInt( label_cgst.getText())),   
                     (Float.parseFloat(cgst.getText())),
                     (Integer.parseInt( label_sgst.getText())),   
                     (Float.parseFloat( sgst.getText())),
                     Integer.parseInt(hsn_code.getText())  
                ));
                table.setItems(list);
                //Net Total calculation from total column
                int row = table.getItems().size();
                float sum = 0, cg_rate=0, cg_amt=0,sg_rate=0, sg_amt=0 ;
                int qt=0,tot_rate=0;
		for(int i=0; i< row; i++){
                    sum = sum + table.getItems().get(i).getAmount();
                    qt = qt + table.getItems().get(i).getQuantity();
                    tot_rate= tot_rate + table.getItems().get(i).getPrice();
                    cg_rate = cg_rate + table.getItems().get(i).getCgstrate();
                    cg_amt = cg_amt + table.getItems().get(i).getProdcgst();
                    sg_rate = sg_rate + table.getItems().get(i).getSgstrate();
                    sg_amt = sg_amt + table.getItems().get(i).getProdsgst();
                }
                net_total.setText(""+sum);
                total_qty.setText(""+qt);
                total_rate.setText(""+tot_rate);
                c_rate.setText(""+cg_rate);
                total_amount.setText(""+cg_amt);
                s_rate.setText(""+sg_rate);
                s_amount.setText(""+sg_amt);
                
                cost.clear();
                quantity1.clear();
                total1.clear();
                stock1.clear();
                hsn_code.clear();
                cgst.clear();
                sgst.clear();
    }
    ///Print Action will add entries in bill ,customer,daily table ////
     @FXML
    private void printAction(ActionEvent event) throws Exception{
      //Updating Customer Table
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
		Statement stm = c.createStatement();
		PreparedStatement ps  = c.prepareStatement("insert into customer values(?,?,TO_DATE('"+date.getText()+"', 'YYYY/MM/DD'),?,?,?)");
						
		ps.setString(1,"");
		//if((cus_name.getText()).length()!=0)
		ps.setString(1,cus_name.getSelectionModel().getSelectedItem().toString());	
		if((net_total.getText()).length()!=0)
		ps.setString(2,net_total.getText());
                else
		ps.setString(2,"");
		if(mob_no.getText().length()!=0)
		ps.setString(3, mob_no.getText());
		else
		ps.setString(3,"");
                if(address.getText().length()!=0)
		ps.setString(4, address.getText());
		else
		ps.setString(4,"");
                if(pan_no.getText().length()!=0)
		ps.setString(5, pan_no.getText());
		else
		ps.setString(5,"");
		ps.executeUpdate();
                
               //////////Updating Customer bill /////////////
							
		int count = table.getItems().size();
                ///GST Calculation 
		String strng = "";
		PreparedStatement ps11 = c.prepareStatement("select gst from  shop_details");
		ResultSet rs1 = ps11.executeQuery();
		while(rs1.next()){
                    strng = ""+rs1.getString("gst");
		}	
                System.out.println("gst=="+strng);
                float totcal = (Float.parseFloat(net_total.getText()))*((Float.parseFloat(strng))/100);
                float tmp = Math.round(totcal);
		float tot = (Float.parseFloat(net_total.getText()))+(totcal);
				    		
                PreparedStatement ps2  = c.prepareStatement("insert into bill values(?,?,?,TO_DATE('"+date.getText()+"', 'YYYY/MM/DD'),?,?,?)");
	
		ps2.setString(1, "");
		if((srno.getText()).length()!=0)
		ps2.setString(1,srno.getText());	
		else
		ps2.setString(2, "");
		//if(cus_name.getText().length()!=0)
		ps2.setString(2, cus_name.getSelectionModel().getSelectedItem().toString());
		if((mob_no.getText()).length()!=0)
		ps2.setString(3,mob_no.getText());	
		else
		ps2.setString(3,"");
		if((net_total.getText()).length()!=0)
		ps2.setString(4,net_total.getText());
		else
		ps2.setString(4,"");
		ps2.setFloat(5, tot);
		ps2.setInt(6,count);					
		ps2.executeUpdate();
                
                ///////////////inserting table values in daily table ///////
							
		PreparedStatement pss  = c.prepareStatement("insert into daily values(?,?,?,?,?,?,?,?,?,?,TO_DATE('"+date.getText()+"', 'YYYY/MM/DD'))");
													
		pss.setString(1, srno.getText());
											      
		pss.setString(2,"");
										        
		pss.setString(2, cus_name.getSelectionModel().getSelectedItem().toString());
                int row = table.getItems().size();
		for(int i=0; i< row; i++){
                  
                 pss.setString(3, table.getItems().get(i).getItems().toString());
                 pss.setString(4, Integer.toString(table.getItems().get(i).getQuantity()));
                 pss.setString(5, table.getItems().get(i).getUnits().toString());
                 pss.setString(6, Integer.toString(table.getItems().get(i).getPrice()));
                 pss.setString(7, Integer.toString(table.getItems().get(i).getAmount()));
                 pss.setString(8, Float.toString(table.getItems().get(i).getProdcgst()));
                 pss.setString(9, Float.toString(table.getItems().get(i).getProdsgst()));
                 pss.setString(10, Integer.toString(table.getItems().get(i).getHsnprod()));
                  pss.execute();   
            }	
                //Insert Into Invoice table for retriving values on Invoice
                PreparedStatement ps3  = c.prepareStatement("insert into invoice values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
                 ps3.setString(1, srno.getText());					        
		ps3.setString(2, cus_name.getSelectionModel().getSelectedItem().toString());
                if((label_cgst.getText()).length()!=0)
		ps3.setString(3,label_cgst.getText());
		else
		ps2.setString(3,"");
                
		for(int i=0; i< row; i++){
                  
                 ps3.setString(4, table.getItems().get(i).getItems().toString());
                 ps3.setString(5, Integer.toString(table.getItems().get(i).getQuantity()));
                 ps3.setString(6, table.getItems().get(i).getUnits().toString());
                 ps3.setString(7, Integer.toString(table.getItems().get(i).getPrice()));
                 ps3.setString(8, Integer.toString(table.getItems().get(i).getAmount()));
                 ps3.setString(9, Integer.toString(table.getItems().get(i).getCgstrate()));
                 ps3.setString(10, Float.toString(table.getItems().get(i).getProdcgst()));
                 ps3.setString(11, Integer.toString(table.getItems().get(i).getSgstrate()));
                 ps3.setString(12, Float.toString(table.getItems().get(i).getProdsgst()));
                 ps3.setString(13, Integer.toString(table.getItems().get(i).getHsnprod()));
                  ps3.execute();   
            }	
                //insert into total table ....column wise total
                String str = net_total.getText();
               String str2 = total_rate.getText();
               String str3 = s_amount.getText();
               //Total calculation with tax
              // float str4 = Float.parseFloat(str + str2 + str3) ;
               //Tax total calculation
               float str5 = Float.parseFloat(str2 )+ Float.parseFloat(str3) ;
               System.out.println("total after tax=="+str5);
                
                PreparedStatement pss9  = c.prepareStatement("insert into total values(?,?,?,?,?,?,?,?,?)");
               if((total_qty.getText()).length()!=0)
		pss9.setString(1,total_qty.getText());
		else
		pss9.setString(1,"");
               if((total_rate.getText()).length()!=0)
		pss9.setString(2,total_rate.getText());
		else
		pss9.setString(2,"");
               if((net_total.getText()).length()!=0)
		pss9.setString(3,net_total.getText());
		else
		pss9.setString(3,"");
               if((c_rate.getText()).length()!=0)
		pss9.setString(4,c_rate.getText());
		else
		pss9.setString(4,"");
               if((total_amount.getText()).length()!=0)
		pss9.setString(5,total_amount.getText());
		else
		pss9.setString(5,"");
               if((s_rate.getText()).length()!=0)
		pss9.setString(6,s_rate.getText());
		else
		pss9.setString(6,"");
               if((s_amount.getText()).length()!=0)
		pss9.setString(7,s_amount.getText());
		else
		pss9.setString(7,"");
                pss9.setString(8, srno.getText());					        
		pss9.setString(9, cus_name.getSelectionModel().getSelectedItem().toString());
                pss9.execute();
               
		c.close();
		stm.close();
		//BGenerate bill = new BGenerate(cus_name.getSelectionModel().getSelectedItem().toString(),srno.getText(),net_total.getText());
                PrintInvoice bill = new PrintInvoice(cus_name.getSelectionModel().getSelectedItem().toString(),srno.getText(),net_total.getText(),date.getText());
                //Parent parent = FXMLLoader.load(getClass().getResource("Invoice.fxml"));
               // framepane.getChildren().setAll(parent);
              //InvoiceController ctrl = new InvoiceController();
               //ctrl.setCellIndex(cus_name.getText());
              // parent.setController(ctrl);
              //  InvoiceController controller=parent.<InvoiceController>getController();
                }
		catch(ClassNotFoundException cnf)
                {
                    cnf.printStackTrace();
                    System.out.println("Cnf Exception");
                }
				
		catch(SQLException sql)
		{
                    sql.printStackTrace();
		}
            
    }
  
    @FXML
    private void itmesAction(ActionEvent event) throws Exception{
       try{
				
				cost.setText(null);
				quantity1.setText(null);
				total1.setText(null);
				stock1.setText(null);
                                //units1.setSelectionModel(null);
				
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				Connection c1 =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
				PreparedStatement ps1 = c1.prepareStatement("select * from items where name ='"+items1.getSelectionModel().getSelectedItem()+"' ");
				ResultSet rs2 = ps1.executeQuery();
				while(rs2.next())
				{
					cost.setText(rs2.getString("mrp"));
					cost.setEditable(true);
                                        hsn_code.setText(rs2.getString("gst_code"));
                                        label_cgst.setText(rs2.getString("cgst"));
                                        label_sgst.setText(rs2.getString("sgst"));
					rs2.next();
				}
                                
			c1.close();
			ps1.close();
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
    } 
    
    //calculating total based on quantity and cost
     @FXML
    private void quantityAction(ActionEvent event) throws Exception{
         String str = (String) items1.getSelectionModel().getSelectedItem();
                    try {
                            Class.forName("oracle.jdbc.driver.OracleDriver");
                            Connection c1 =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
                            PreparedStatement ps1 = c1.prepareStatement("select stock from items where name= '"+str+"'");
                            ResultSet rs = ps1.executeQuery();
                            while(rs.next())
                            {
				if(Integer.parseInt(rs.getString("stock"))-Integer.parseInt(quantity1.getText()) < 0)
                               
				{
                                    jp.showMessageDialog(null,"OUT OF STOCK !\n You have at least "+rs.getString("stock")+" items to sell !"," ",jp.INFORMATION_MESSAGE);
                                    total1.setText(null);
				    stock1.setText(null);
									
				}else
				{
                                    stock1.setText(""+(Integer.parseInt(rs.getString("stock"))-Integer.parseInt(quantity1.getText())));
                                    stock1.setEditable(true);
                                    int  count = Integer.parseInt(cost.getText()) * Integer.parseInt(quantity1.getText());
                                    total1.setText("" + count);
				}
                            }
                            c1.close();
                            ps1.close();
						
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
    }
    //Customer combobox Action
     @FXML
    private void customerAction(ActionEvent event) throws Exception{
        try{
        	Class.forName("oracle.jdbc.driver.OracleDriver");
				
				Connection c1 =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
				PreparedStatement ps1 = c1.prepareStatement("select * from account where name ='"+cus_name.getSelectionModel().getSelectedItem()+"' ");
				ResultSet rs2 = ps1.executeQuery();
				while(rs2.next())
				{
					mob_no.setText(rs2.getString("mob_no"));
					address.setText(rs2.getString("address"));
                                        pan_no.setText(rs2.getString("gst_no"));
					rs2.next();
				}
                                
			c1.close();
			ps1.close();
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
    }
    /*Total field action part
        
    */
     @FXML
    private void totalAction(ActionEvent event) throws Exception{
        ///GST Calculation 
        String strng = "";
        String strng2 = "";
        try {
                            Class.forName("oracle.jdbc.driver.OracleDriver");
                            Connection c1 =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
		
		PreparedStatement ps11 = c1.prepareStatement("select * from items where name ='"+items1.getSelectionModel().getSelectedItem()+"' ");
		ResultSet rs1 = ps11.executeQuery();
		while(rs1.next()){
                    strng = ""+rs1.getString("cgst");
                    strng2 = ""+rs1.getString("sgst");
		}
                c1.close();
                            ps11.close();
						
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
        float totcal = (Float.parseFloat(total1.getText()))*((Float.parseFloat(strng))/100);
                float tmp = Math.round(totcal);
                //sgst calculations
                float totsgst = (Float.parseFloat(total1.getText()))*((Float.parseFloat(strng2))/100);
                float tmpsgst = Math.round(totsgst);
		//float tot = (Float.parseFloat(total1.getText()))+(totcal);
                cgst.setText(""+tmp);
                sgst.setText(""+tmpsgst);
    }
    //delet Button Action...Which Delets Selected Row from Table
     @FXML
    private void deleteButtonAction(ActionEvent event){
        int delete = table.getSelectionModel().getSelectedIndex();
         table.getItems().remove(delete);
         //Net Total calculation from total column
                int row = table.getItems().size();
                float sum = 0 ;
		for(int i=0; i< row; i++){
                    sum = sum + table.getItems().get(i).getAmount();
                }
                net_total.setText(""+sum);
                cost.clear();
                quantity1.clear();
                total1.clear();
                stock1.clear();
    }
     /*when table row is selected value is set to textfields and
        * Comboboxes 
        */
    private void setCellValueFromTableToTextfield(){
        table.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                Order list = table.getItems().get(table.getSelectionModel().getSelectedIndex());
                items1.getSelectionModel().select(list.getItems());
                cost.setText(""+list.getPrice());
                quantity1.setText(""+list.getQuantity());
                units1.getSelectionModel().select(list.getUnits());
                total1.setText(""+list.getAmount());
                 table.setFixedCellSize(20.0);
            }
        });
    }
    
    @FXML
    private void updateButtonAction(ActionEvent event){
        int i = table.getSelectionModel().getSelectedIndex();
         list.add(new Order(
                     (String)items1.getSelectionModel().getSelectedItem(),
                      Integer.parseInt(quantity1.getText()),
                     (String) units1.getSelectionModel().getSelectedItem(),
                      Integer.parseInt(cost.getText()),
                     (Integer.parseInt( total1.getText())),
                     (Integer.parseInt(label_cgst.getText())),
                     (Float.parseFloat( cgst.getText())),
                     (Integer.parseInt(label_sgst.getText())),
                     (Float.parseFloat( sgst.getText())),
                     Integer.parseInt(hsn_code.getText())
                ));
                  if(i > 0){
                    // table.edit(i, );
                  }
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //inializing table values
        items.setCellValueFactory(new PropertyValueFactory<>("items"));
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        units.setCellValueFactory(new PropertyValueFactory<>("units"));
        rate.setCellValueFactory(new PropertyValueFactory<>("price"));
        total.setCellValueFactory(new PropertyValueFactory<>("amount"));
        cgst_rate.setCellValueFactory(new PropertyValueFactory<>("cgstrate"));
        cgst_amount.setCellValueFactory(new PropertyValueFactory<>("prodcgst"));
        sgst_rate.setCellValueFactory(new PropertyValueFactory<>("cgstrate"));
        sgst_amount.setCellValueFactory(new PropertyValueFactory<>("prodsgst"));
        hsncode.setCellValueFactory(new PropertyValueFactory<>("hsnprod"));
        // set date to textfield
        Date date1 = new Date(System.currentTimeMillis());
	date.setText(date1.toString());
        //set srno from bill table
        try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection c1 =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
	
		ArrayList<Integer> ar = new ArrayList<Integer>();
		PreparedStatement ps1 = c1.prepareStatement("select bid from bill");
		
		ResultSet rs = ps1.executeQuery();
		while(rs.next())
		{
			ar.add(rs.getInt("BID"));
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
		srno.setText(""+(lst_num+1));
		srno.setEditable(false);
		}
		 catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //set items to combobox from items table from database
         try{
    		// String[] str = { };
    	    Class.forName("oracle.jdbc.driver.OracleDriver");
		    Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			Statement stm = c.createStatement();
			ResultSet rs = stm.executeQuery("select name from Items");
			   				
			while(rs.next())
			{
				items1.getItems().addAll(rs.getString("name"));
			}
                        //Adding Customer names into customer combobox from account tabe
                        ResultSet rs1 = stm.executeQuery("select name from account");
			   				
			while(rs1.next())
			{
				cus_name.getItems().addAll(rs1.getString("name"));
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
         //making itemsand customer combobox editable
         items1.setEditable(true);
         cus_name.setEditable(true);
         // Add units to unit combobox
        units1.getItems().removeAll(units1.getItems());
        units1.getItems().addAll("Dozens", "Gms", "kgs.","Meter","Pcs.","Tonne");
        units1.setEditable(true);
        //Auto Suggestor for items,customer  and units Combobox
        new AutoCompleteComboBoxListener(units1);
        new AutoCompleteComboBoxListener(items1);
         new AutoCompleteComboBoxListener(cus_name);
        /*when table row is selected value is set to textfields and
        * Comboboxes 
        */
        setCellValueFromTableToTextfield();
    }    
    
}
