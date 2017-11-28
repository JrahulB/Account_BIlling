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
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.runtime.options.Options;

/**
 * FXML Controller class
 *
 * @author user
 */
public class EditItemController implements Initializable {
@FXML
    private Button load,change;
  @FXML
    private ComboBox units,taxCat ;
      @FXML
      int t=0;
     // @FXML
      //final ObservableList Options = FXCollections.observableArrayList();
      @FXML
  private Label unit1,unit2,unit3,unit4,unit5;
      JOptionPane jp = new JOptionPane();
      @FXML
    private TextField name,stock,sale_price,purc_price,mrp,minPrice,self_val_price,hss_gst,sale_disc1,purc_disc,spec_sale_desc,purc_pure_disc,rcgst,rsgst,rgst,T_typ,tax_mrp; 
   // private ObservableList Options;
    /**
     * Initializes the controller class.
     */
    @FXML
private void loadactinPerformed(ActionEvent event) throws SQLException, ClassNotFoundException{
   try
			{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
				Statement stm = c.createStatement();
                                int t = 0;
				ResultSet rs = stm.executeQuery("select * from items where name='"+name.getText()+"'");
				while(rs.next())
				{	
					t=1;	
		
			   
					
			                name.setText(rs.getString("NAME"));
                                        stock.setText(rs.getString("STOCK"));
                                       units.getSelectionModel().select(rs.getString("UNIT"));
					sale_price.setText(rs.getString("SALE_PRICE"));
				        purc_price.setText(rs.getString("PURC_PRICE"));
					mrp.setText(rs.getString("MRP"));
					minPrice.setText(rs.getString("MIN_SAL"));
                                        self_val_price.setText(rs.getString("SELF_VAL"));
                                        hss_gst.setText(rs.getString("GST_CODE"));
                                        taxCat.getSelectionModel().select(rs.getString("TAX_CAT"));
                                       sale_disc1.setText(rs.getString("SALE_DIS"));
                                       purc_disc.setText(rs.getString("PURC_DIS"));
                                       // spec_sale_desc.setText(rs.getString("SPEC_SALE_DESC"));
                                       // purc_pure_disc.setText(rs.getString("purc_PURE_DESC"));
                                        //rcgst.setText(rs.getString("CGST"));
                                       // rsgst.setText(rs.getString("SGST"));
                                       // rgst.setText(rs.getString("GST"));
                                       // T_typ.setText(rs.getString("TAX_TYPE"));
                                       // tax_mrp.setText(rs.getString("TAX_MRP"));
                    
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
   //ComboBox
   
                    units.getSelectionModel().getSelectedItem();
                    unit1.setText("("+units.getSelectionModel().getSelectedItem()+")");
                    unit2.setText("("+units.getSelectionModel().getSelectedItem()+")");
                    unit3.setText("("+units.getSelectionModel().getSelectedItem()+")");
                    unit4.setText("("+units.getSelectionModel().getSelectedItem()+")");
                    unit5.setText("("+units.getSelectionModel().getSelectedItem()+")");
    
    
}
//comboBox Action     
                    @FXML
                    private void handleUnitComboBoxAction(ActionEvent event) {
                      
                  //  units.getSelectionModel().getSelectedItem();
                   // units.getItems().addAll("Dozens", "Gms", "kgs.","Meter","Pcs.","Tonne");
                    //units.getSelectionModel().select("Pcs.");
                    unit1.setText("("+units.getSelectionModel().getSelectedItem()+")");
                    
                    unit2.setText("("+units.getSelectionModel().getSelectedItem()+")");
                    unit3.setText("("+units.getSelectionModel().getSelectedItem()+")");
                    unit4.setText("("+units.getSelectionModel().getSelectedItem()+")");
                    unit5.setText("("+units.getSelectionModel().getSelectedItem()+")");

                    }
          
                    
//type catagory
                      @FXML
                    private void handleTaxComboBoxAction(ActionEvent event) {
                    if(taxCat.getSelectionModel().getSelectedIndex()== 0){
                            rcgst.setText("6");
                            rsgst.setText("6");
                            rgst.setText("12");
                        }
                        if(taxCat.getSelectionModel().getSelectedIndex()== 1){
                            rcgst.setText("9");
                            rsgst.setText("9");
                            rgst.setText("18");
                        }  
                        if(taxCat.getSelectionModel().getSelectedIndex()== 2){
                            rcgst.setText("14");
                            rsgst.setText("14");
                            rgst.setText("28");
                        }   
                                }
                    
 @FXML
private void changeactinPerformed(ActionEvent event) throws SQLException, ClassNotFoundException{
    	              try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
				Statement stm = c.createStatement();
				//if(pho.getText().length()!=10)
				//jp.showMessageDialog(null,"Phone Number Must Have 10 Digits","INFORMATION",jp.ERROR_MESSAGE);
				//else
				//{
					ResultSet rs1 = stm.executeQuery("select * from items where name='"+name.getText()+"'");
					while(rs1.next())
					{	
                                            t = 1;
					}
					if(t==1)
					{
						t=0;
						if((name.getText()).length()!=0)
						{
							PreparedStatement ps=c.prepareStatement ("Update items set name=? where name='"+name.getText()+"'");	
							ps.setString(1,name.getText());	ps.executeUpdate();
						}
						/*if((dob.getText()).length()!=0)
						{
							PreparedStatement ps=c.prepareStatement ("Update emp set dob=(TO_DATE('?', 'YYYY/MM/DD')) where id="+id.getText());	
							ps.setString(1,dob.getText());
							ps.executeUpdate();
						}*/
						if((stock.getText()).length()!=0)
						{
							PreparedStatement ps=c.prepareStatement ("Update items set stock=? where name='"+name.getText()+"'");	
							ps.setString(1,stock.getText());ps.executeUpdate();
						}
						
						if((sale_price.getText()).length()!=0)
						{
							PreparedStatement ps=c.prepareStatement ("Update items set sale_price=? where name='"+name.getText()+"'");	
							ps.setString(1,sale_price.getText());ps.executeUpdate();
						}
						if((purc_price.getText()).length()!=0)
						{
							PreparedStatement ps=c.prepareStatement ("Update items set purc_price=? where name='"+name.getText()+"'");	
							ps.setString(1,purc_price.getText());ps.executeUpdate();
						}
						
						if((mrp.getText()).length()!=0)
						{
							PreparedStatement ps=c.prepareStatement ("Update items set mrp=? where name='"+name.getText()+"'");	
							ps.setString(1,mrp.getText());ps.executeUpdate();
						}
                                                if((minPrice.getText()).length()!=0)
						{
							PreparedStatement ps=c.prepareStatement ("Update items set MIN_SAL=? where name='"+name.getText()+"'");	
							ps.setString(1,minPrice.getText());ps.executeUpdate();
						}
//                                                if((self_val_price.getText()).length()!=0)
//						{
//							PreparedStatement ps=c.prepareStatement ("Update items set self_value_price=? where name='"+name.getText()+"'");	
//							ps.setString(1,self_val_price.getText());ps.executeUpdate();
//						}
                                                if((hss_gst.getText()).length()!=0)
						{
							PreparedStatement ps=c.prepareStatement ("Update items set GST_CODE=? where name='"+name.getText()+"'");	
							ps.setString(1,hss_gst.getText());ps.executeUpdate();
						}
                                                if((sale_disc1.getText()).length()!=0)
						{
							PreparedStatement ps=c.prepareStatement ("Update items set sale_dis=? where name='"+name.getText()+"'");	
							ps.setString(1,sale_disc1.getText());ps.executeUpdate();
						}
                                                if((purc_disc.getText()).length()!=0)
						{
							PreparedStatement ps=c.prepareStatement ("Update items set purc_dis=? where name='"+name.getText()+"'");	
							ps.setString(1,purc_disc.getText());ps.executeUpdate();
						}
////                                                if((spec_sale_desc.getText()).length()!=0)
////						{
////							PreparedStatement ps=c.prepareStatement ("Update items set spec_sale_desc=? where name='"+name.getText()+"'");	
////							ps.setString(1,spec_sale_desc.getText());ps.executeUpdate();
////						}
//                                                //if((rcgst.getText()).length()!=0)
//						{
//							PreparedStatement ps=c.prepareStatement ("Update items set cgst=? where name='"+name.getText()+"'");	
//							ps.setString(1,rcgst.getText());ps.executeUpdate();
//						}
//                                               // if((rsgst.getText()).length()!=0)
//						{
//							PreparedStatement ps=c.prepareStatement ("Update items set sgst=? where name='"+name.getText()+"'");	
//							ps.setString(1,rgst.getText());ps.executeUpdate();
//						}
//                                                //if((rgst.getText()).length()!=0)
//						{
//							PreparedStatement ps=c.prepareStatement ("Update items set gst=? where name='"+name.getText()+"'");	
//							ps.setString(1,rgst.getText());ps.executeUpdate();
//						}
//						//if((T_typ.getText()).length()!=0)
//						{
//							PreparedStatement ps=c.prepareStatement ("Update items set tax_type=? where name='"+name.getText()+"'");	
//							ps.setString(1,T_typ.getText());ps.executeUpdate();
//						}
//                                               // if((tax_mrp.getText()).length()!=0)
//						{
//							PreparedStatement ps=c.prepareStatement ("Update items set tax_mrp=? where name='"+name.getText()+"'");	
//							ps.setString(1,tax_mrp.getText());ps.executeUpdate();
//						}
//                                              //  if((taxCat.getSelectionModel())
//						{
//							PreparedStatement ps=c.prepareStatement ("Update items set tax_cat=? where name='"+name.getText()+"'");	
//							ps.setString(1, (String) taxCat.getSelectionModel().getSelectedItem());ps.executeUpdate();
//						}
//                                                
//                                               // if((units.getText()).length()!=0)
//						{
//							PreparedStatement ps=c.prepareStatement ("Update items set UNIT=? where name='"+name.getText()+"'");	
//							ps.setString(1, (String) units.getSelectionModel().getSelectedItem());ps.executeUpdate();
//						}
                                                
                                                
						jp.showMessageDialog(null,"Record Updated Successfully","SUCCESS",jp.INFORMATION_MESSAGE);
						stock.setText(null);
						sale_price.setText(null);
						name.setText(null);
						purc_price.setText(null);
						mrp.setText(null);
						minPrice.setText(null);
						self_val_price.setText(null);
                                                hss_gst.setText(null);
                                                sale_disc1.setText(null);
                                                purc_disc.setText(null);
                                                rcgst.setText(null);
                                                rsgst.setText(null);
                                                rgst.setText(null);
                                                T_typ.setText(null);
                                                tax_mrp.setText(null);
                        
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
//@FXML
//public void fillComboBox(){
//    try{
//        String query = "Select name from items";
//        pst=conn.prepareStatement(query);
//        rs=ps.executeQuery();
//        
//        while(rs.next()){
//            Options.add(rs.getStrin("name"));
//        }
//            pst.close();
//            rs.close();
//    }catch(SQLException e){
//        
//        
//        
//    }
//}
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       //ComboBox comboBox = new ComboBox(Options);
        // ComboBox.setMaxHeight(30);
        units.setEditable(true);
        units.getItems().removeAll(units.getItems());
        units.getItems().addAll("Dozens", "Gms", "kgs.","Meter","Pcs.","Tonne");
        //units.getSelectionModel().select("PCS.");
                //Add items to tax category combobox
        taxCat.setEditable(true);
        taxCat.getItems().removeAll(taxCat.getItems());
        taxCat.getItems().addAll("GST 0%","GST 3%","GST 12%","GST 17%", "GST 18%", "GST 28%.","GST 5%");
        taxCat.getSelectionModel().select("GST 12%");
    }    
    
}
