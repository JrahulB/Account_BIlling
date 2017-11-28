/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account_billing;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author ACER
 */
public class BarcodeGenController implements Initializable {
    
      @FXML
    private void barcodeCreation(ActionEvent event) throws Exception{
            int str = 1234;
             Document d = new Document(new Rectangle(PageSize.A4));
             PdfWriter p = PdfWriter.getInstance(d, new FileOutputStream("E://demo.pdf"));
             d.open();
             Barcode128 b = new Barcode128();
             for(int i=1;i<100;i++){
             b.setCode(""+str);
             d.add(b.createImageWithBarcode(p.getDirectContent(), BaseColor.BLACK, BaseColor.BLACK));
             str++;
             }
              
            
             d.close();
             System.out.println("Successfully created");
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
