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
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class RegisterSuccessBoxController implements Initializable 
{
    @FXML
    private Button ok;
    @FXML
    private AnchorPane anchor;

                                @Override
                                public void initialize(URL url, ResourceBundle rb) 
                                {
                                    // TODO
                                }    

                                    @FXML
                                    public void ok(ActionEvent event) throws IOException 
                                {
                                  
                                                             
                                                    Parent parent = FXMLLoader.load(getClass().getResource("/updatework/Business_Details.fxml"));
                                                    anchor.getChildren().setAll(parent);
                                    
//                                                   Parent parent = FXMLLoader.load(getClass().getResource("/updatework/Business_Details.fxml"));
//                                                Scene scene = new Scene(parent);
//                                                Stage stage = new Stage();
//
//                                                stage.setTitle("Bussiness Deatils");
//                                                stage.setScene(scene);
//                                                stage.show();
                                    }
    
}
