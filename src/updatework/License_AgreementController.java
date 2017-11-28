package updatework;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class License_AgreementController implements Initializable 
{

    @FXML
    private RadioButton accept;
    @FXML
    private ToggleGroup license_Accept;
    @FXML
    private RadioButton not_Accept;

    JOptionPane jp=new JOptionPane();
      Alert al= new Alert(Alert.AlertType.WARNING);
    @FXML
    private AnchorPane anchor;
                        @Override
                        public void initialize(URL url, ResourceBundle rb) 
                        {

                        }    

                        @FXML
                        private void clickOnNext(ActionEvent event) throws IOException 
                        {
                                             

                                                if(accept.isSelected())
                                                 {
                                                                       System.out.println(" i am here ");
                                                                Parent parent = FXMLLoader.load(getClass().getResource("/updatework/ResisterDetails.fxml"));
                                                                      anchor.getChildren().setAll(parent);
                                                                    System.out.println(" i am below ");
//                                                                Scene scene = new Scene(parent);
//                                                                Stage stage = new Stage();
//
//                                                                stage.setTitle("Register Deatils");
//                                                                stage.setScene(scene);
//                                                                stage.show();

                                                 }
                                                else
                                                {
                                                                       
                                                                 al.setTitle("Validation");
                                                                al.setHeaderText(null);
                                                                al.setContentText(" You Must accept license Terms  ");
                                                                al.showAndWait();
                                                                               
                                                }

                        }


                        @FXML
                        private void clickOnCancel(ActionEvent event)
                        {
                                                 System.exit(0);
                        }

}
