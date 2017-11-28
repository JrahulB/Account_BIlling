/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account_billing;


import com.osiersystems.pojos.Invoice;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterAttributes;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Scale;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class InvoceBillingController implements Initializable {
    @FXML
    private AnchorPane anchor;
    @FXML
    private TextField name,name1,invoceno,date,reverseC,code,date_suply,place_Suply,address,gstin,gstin1,
            totalqty,totalamt,totalDisc,totaltaxV,totalcgst,totalsgst,net_total,before_Tax,add_cgst,add_sgst,after_Tax,gstReverseC;
     @FXML
    private Label banknm,accno,ifsc;
    @FXML
    private ComboBox state,state1,state2;
     @FXML
    private TableView<Invoice> table;
    @FXML
    private TableColumn<Invoice, Integer> srno;
    @FXML
    private TableColumn<Invoice, String> productDesc;
    @FXML
    private TableColumn<Invoice, String> hsncode;
    @FXML
    private TableColumn<Invoice, Integer> qty;
    @FXML
    private TableColumn<Invoice, Integer> rate;
    @FXML
    private TableColumn<Invoice, Integer> amount;
    @FXML
    private TableColumn<Invoice, Integer> discount;
    @FXML
    private TableColumn<Invoice, Integer> taxableV;
    @FXML
    private TableColumn<Invoice, Integer> cgstrate;
    @FXML
    private TableColumn<Invoice, Integer> cgstamount;
    @FXML
    private TableColumn<Invoice, Integer> sgstrate;
    @FXML
    private TableColumn<Invoice, Integer> sgstamount;
    @FXML
    private TableColumn<Invoice, Integer> total;
     private  ObservableList<Invoice> list = FXCollections.observableArrayList(
             new Invoice(1,"Ghee",11, 1,55,55,0,0,9,9,9,9,81),
             new Invoice(2,"Ghee",12, 1,55,55,0,0,9,9,9,9,81),
             new Invoice(3,"Ghee",13, 1,55,55,0,0,9,9,9,9,81),
             new Invoice(4,"Ghee",14, 1,55,55,0,0,9,9,9,9,81)
     );
     JOptionPane jp = new JOptionPane();
       int t=0;
     /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //inializing table values
       srno.setCellValueFactory(new PropertyValueFactory<>("serial"));
        productDesc.setCellValueFactory(new PropertyValueFactory<>("items"));
        hsncode.setCellValueFactory(new PropertyValueFactory<>("hsn"));
        qty.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        rate.setCellValueFactory(new PropertyValueFactory<>("price"));
        amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        discount.setCellValueFactory(new PropertyValueFactory<>("discount"));
        taxableV.setCellValueFactory(new PropertyValueFactory<>("taxable"));
        cgstrate.setCellValueFactory(new PropertyValueFactory<>("pricec"));
        cgstamount.setCellValueFactory(new PropertyValueFactory<>("amountc"));
        sgstrate.setCellValueFactory(new PropertyValueFactory<>("prices"));
        sgstamount.setCellValueFactory(new PropertyValueFactory<>("amounts"));
        total.setCellValueFactory(new PropertyValueFactory<>("total"));
        // insert data into table 
        table.setItems(list);
//           table.prefHeightProperty().bind(table.fixedCellSizeProperty().multiply(Bindings.size(table.getItems()).add(list.size())));
//             table.minHeightProperty().bind(table.prefHeightProperty());
//    table.maxHeightProperty().bind(table.prefHeightProperty());
        /* try
        {
          
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
            Statement stm = c.createStatement();
            t=0;
            ResultSet rs = stm.executeQuery("select * from items where stock!=0");
            while(rs.next())
            {
                t=1;
               /*list.add(new Invoice(
                       rs.getString("name"),
                       rs.getInt("stock"),
                       rs.getInt("mrp")
               ));*/
               
              // table.setItems(list);
          /*  }
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
		}*/
    }    

    //Conver to PDF
     @FXML
    private void printAction(ActionEvent event) throws Exception{
         //doPrint(anchor);
        printNode(anchor);
   }
/*    // Get the Default Printer
Printer printer = Printer.getDefaultPrinter();

     PrinterJob job = PrinterJob.createPrinterJob();
// Show the page setup dialog

//boolean proceed = job.showPageSetupDialog(owner);

         if(job == null)
             return false;
         if(! job.printPage(n))
             return false;
         return job.endJob();
}*/
  public static void printNode(final Node node) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
    Printer printer = Printer.getDefaultPrinter();
    PageLayout pageLayout
        = printer.createPageLayout(Paper.A4, PageOrientation.PORTRAIT, Printer.MarginType.HARDWARE_MINIMUM);
    PrinterAttributes attr = printer.getPrinterAttributes();
    PrinterJob job = PrinterJob.createPrinterJob();
    double scaleX
        = pageLayout.getPrintableWidth() / node.getBoundsInParent().getWidth();
    double scaleY
        = pageLayout.getPrintableHeight() / node.getBoundsInParent().getHeight();
    Scale scale = new Scale(scaleX, scaleY);
    node.getTransforms().add(scale);

    if (job != null && job.showPrintDialog(node.getScene().getWindow())) {
      boolean success = job.printPage(pageLayout, node);
      if (success) {
        job.endJob();

      }
    }
    node.getTransforms().remove(scale);
  }

}