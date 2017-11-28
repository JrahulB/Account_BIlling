/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account_billing;

import java.io.IOException;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ACER
 */
public class AddItemsController implements Initializable {
     @FXML
    private TextField name,stock,sale_price,purc_price,mrp,minPrice,set_val_price,hss_gst,sale_dis1,purc_dis,spec_sale_desc,spec_pure_disc,cgst,sgst,gst,tax_typ,tax_mrp; 
    @FXML
    private Button save;
     @FXML
    private ComboBox comboBox,tax_cat ;
      @FXML
    private Label unit1,unit2,unit3,unit4 ;
      JOptionPane jp = new JOptionPane();
       @FXML
       private AnchorPane anchor;
        
          @FXML
private void addItem(ActionEvent event) throws SQLException, ClassNotFoundException{
    try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			Statement stm = c.createStatement();
		
			
int t = 0;
			/*if(((tax.getText().length()!=0)&&(Integer.parseInt(cgstt.getText())>100||Integer.parseInt(tax.getText())<0)))//final price of product is 
			jp.showMessageDialog(this,"Tax Must be in between 1 to 100","INFORMATION",jp.ERROR_MESSAGE);*/
			if(name.getText().length()==0 &&mrp.getText().length()==0 &&mrp.getText().length()==0 ){//&&cgst.getText().length()==0 &&sgstt.getText().length()==0 &&stockt.getText().length()==0){
				jp.showMessageDialog(null,"Fields should not be null","INFORMATION",jp.ERROR_MESSAGE);
			}
		
			else
			{
				
//				ResultSet rs1 = stm.executeQuery("select * from item where id="+mrp.getText());
//				while(rs1.next())
//				{	
//					t=1;
//				}
			//if(t==0)
				//{
					//t=0;
				ResultSet rs2 = stm.executeQuery("select * from items where  name='"+name.getText()+"'");//name ='"+name.getText()+"'
				if(rs2.next()){
					jp.showMessageDialog(null,"Record Already Present","INFORMATION",jp.ERROR_MESSAGE);
				}
				else{
					PreparedStatement ps  =c.prepareStatement("insert into items values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
					if((name.getText()).length()!=0)
					ps.setString(1,name.getText());
					else
					ps.setString(1,"");
					ps.setString(2, (String) comboBox.getSelectionModel().getSelectedItem());		
					if((stock.getText()).length()!=0)
					ps.setString(3,stock.getText());
					else
					ps.setString(3,"");
					if((sale_price.getText()).length()!=0)
					ps.setString(4,sale_price.getText());
                                        else
					ps.setString(4,"");
					if((purc_price.getText()).length()!=0)
					ps.setString(5,purc_price.getText());
					 else
					ps.setString(5,"");
					if((mrp.getText()).length()!=0)
					ps.setString(6,mrp.getText());
					 else
					ps.setString(6,"");
					if((minPrice.getText()).length()!=0)
					ps.setString(7,minPrice.getText());
                                         else
					ps.setString(7,"");
					if((set_val_price.getText()).length()!=0)
					ps.setString(8,set_val_price.getText());
                                         else
					ps.setString(8,"");
					if((hss_gst.getText()).length()!=0)
					ps.setString(9,hss_gst.getText());
                                         else
					ps.setString(9,"");
					ps.setString(10, (String) tax_cat.getSelectionModel().getSelectedItem());
                                        if((cgst.getText()).length()!=0)
					ps.setString(11,cgst.getText());
                                         else
                                         ps.setString(11,"");
					if((sgst.getText()).length()!=0)
					ps.setString(12,sgst.getText());
                                        else
                                        ps.setString(12,"");
					if((gst.getText()).length()!=0)
					ps.setString(13,gst.getText());
                                        else
                                        ps.setString(13,"");
					if((tax_mrp.getText()).length()!=0)
					ps.setString(14,tax_mrp.getText());
                                        else
                                        ps.setString(14,"");
					if((tax_typ.getText()).length()!=0)
					ps.setString(15,tax_typ.getText());
                                        else
                                        ps.setString(15,"");
					if((sale_dis1.getText()).length()!=0)
					ps.setString(16,sale_dis1.getText());
                                        else
                                         ps.setString(16,"");
					if((purc_dis.getText()).length()!=0)
					ps.setString(17,purc_dis.getText());
                                        else
                                        ps.setString(17,"");    
				   
						minPrice.setEditable(true);
						name.setEditable(true);
						mrp.setEditable(true);
						sale_price.setEditable(true);
						purc_price.setEditable(true);
						stock.setEditable(true);
						
						minPrice.setText(null);
						name.setText(null);
						mrp.setText(null);
						//cgstt.setText(null);
						//sgstt.setText(null);
						stock.setText(null);
					
					
					ps.executeUpdate();
					jp.showMessageDialog(null,"Item Added Successfully","SUCCESS",jp.INFORMATION_MESSAGE);
				}
				/*else
				{
					jp.showMessageDialog(this,"Sorry, Record ID is Already Exists","INFORMATION",jp.ERROR_MESSAGE);
					t=0;
				}*/
				
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
                    private void handleUnitComboBoxAction(ActionEvent event) {
                    comboBox.getSelectionModel().getSelectedItem();
                    unit1.setText("("+comboBox.getSelectionModel().getSelectedItem()+")");
                    unit2.setText("("+comboBox.getSelectionModel().getSelectedItem()+")");
                    unit3.setText("("+comboBox.getSelectionModel().getSelectedItem()+")");
                    unit4.setText("("+comboBox.getSelectionModel().getSelectedItem()+")");

                    }

                    @FXML
                    private void handleTaxComboBoxAction(ActionEvent event) {
                        if(tax_cat.getSelectionModel().getSelectedIndex()== 0){
                            cgst.setText("6");
                            sgst.setText("6");
                            gst.setText("12");
                        }
                        if(tax_cat.getSelectionModel().getSelectedIndex()== 1){
                            cgst.setText("9");
                            sgst.setText("9");
                            gst.setText("18");
                        }  
                        if(tax_cat.getSelectionModel().getSelectedIndex()== 2){
                            cgst.setText("14");
                            sgst.setText("14");
                            gst.setText("28");
                        }   
                    }

                    @FXML
                    private void ExitAction(ActionEvent event) throws IOException {
                        Parent parent = FXMLLoader.load(getClass().getResource("addItems.fxml"));
                        anchor.getChildren().removeAll(parent);
                    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                // Add items to unit combobox
        comboBox.getItems().removeAll(comboBox.getItems());
        comboBox.getItems().addAll("Dozens", "Gms", "kgs.","Meter","Pcs.","Tonne");
        comboBox.getSelectionModel().select("Pcs.");
                //Add items to tax category combobox
        tax_cat.getItems().removeAll(tax_cat.getItems());
        tax_cat.getItems().addAll("GST 0%","GST 3%","GST 12%","GST 17%", "GST 18%", "GST 28%.","GST 5%");
        tax_cat.getSelectionModel().select("GST 12% ");
        
    }    
    
}
