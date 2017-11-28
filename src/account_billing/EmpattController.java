/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account_billing;

import com.osiersystems.pojos.Day;
import static java.lang.System.exit;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.ResourceBundle;
import static javafx.application.Platform.exit;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * FXML Controller class
 *
 * @author user
 */
public class EmpattController implements Initializable {

    @FXML
    private AnchorPane anchor;
     @FXML
    private Button closeButton;
    @FXML
    private Label date;
   @FXML
   private DatePicker DatePicker;
   int t=0,in=0,i,x=70,y=140;
   Integer tem=new Integer(0);
	int id[]=new int[50];
	String tp;
        //@FXML
       //// private JCheckBox[] c=new JCheckBox[50];
    @FXML
      JOptionPane jp = new JOptionPane();
    /**
     * Initializes the controller class.
     */
    
    
    
    @FXML
    private void showDisplayAction(ActionEvent event) throws Exception{
                    //createCheckboxes();
         
                     try
			{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			Statement stm = c.createStatement();
			ResultSet rs = stm.executeQuery("select * from emp");
			t=0;			while(rs.next())
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
				JOptionPane.showMessageDialog(null,sql,"EXCEPTION",jp.ERROR_MESSAGE);
//		
//                                TableColumn albumArt = new TableColumn("Album Art");
//        albumArt.setCellValueFactory(new PropertyValueFactory("album"));
//        albumArt.setPrefWidth(200); 
//
//        TableColumn title = new TableColumn("Title");
//        title.setCellValueFactory(new PropertyValueFactory("title"));
//        title.setPrefWidth(120); 
//
//        TableColumn artist = new TableColumn("Artist");
//        artist.setCellValueFactory(new PropertyValueFactory("artist"));
//        artist.setPrefWidth(120); 
//
//        TableColumn rating = new TableColumn("Rating");
//        rating.setCellValueFactory(new PropertyValueFactory("rating"));
//        rating.setPrefWidth(120);
//                                anchor.getChildren().addAll(ch);
                    // @FXML
               //private void empattAction(ActionEvent event) throws Exception{
                               
   // JPanel dPanel = new JPanel(); 
    //getContentPane().add(new JScrollPane(dPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
//    for (int i = 0; i < 5; i++) {
//		for(i=0;i<in;i++)
//		{
//			tem=id[i];
//		     c[i]=new JCheckBox(Integer.toString(tem));
//		}
//		for(i=0;i<in;i++)
//		{  
//                    CheckBox c[] = new CheckBox[50];
//			c[i].setAlignment(Pos.BASELINE_LEFT);//x,y+=30,50,20);
//                       
//                       // anchor.getChildren().setAll(c);
//			//c[i].setFont(new Font("Calibri", Font.BOLD, 20));
//                      // jp.add(c[i]);
//                          anchor.getChildren().setAll(c[i]);
//                          // c.selectedProperty().addListener(checkboxlistener);(c[i]);
//			if(y>=600)
//			{
//				y=140;
//				x+=60;
//			}
//		}
//		//setDefaultCloseOperation(EXIT_ON_CLOSE);
//		//setVisible(true);
//    }
                                
//                             for(int i=0; i<4; i++) 
//        {
//       JCheckBox box = new JCheckBox("check"+i);
//       anchor.getChildren().setAll((Collection<? extends Node>) box);
//       checks.add(box); 
//        } 
                                
    }
    }
   
    private java.util.List <javax.swing.JCheckBox> checks = new java.util.ArrayList<>();;
    @FXML
    private void createCheckboxes()
    {
        for(int i=0; i<4; i++) 
        {
       JCheckBox box = new JCheckBox("check"+i);
       anchor.getChildren().setAll((Collection<? extends Node>) box);
       checks.add(box); 
        }
      // pack();  // this will tell the JFrame's panel to layout all the components
      }
     @FXML
    private void attDisplayAction(ActionEvent event) throws Exception{
          {
              
			for(i=0;i<in;i++)
			{
			try
			{
			
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection c =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			Statement stm = c.createStatement();
			
			
				//if(emid[i].isSelected())
				{
				tem=id[i];
				
				//PreparedStatement ps  = c.prepareStatement("insert into e"+id[i]+"  values(TO_DATE('"+day.getText()+"', 'YYYY/MM/DD'),?)");
				PreparedStatement ps  = c.prepareStatement("insert into e"+id[i]+" values('"+((TextField)DatePicker.getEditor()).getText()+"',?)");
					ps.setInt(1,1);	
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null,id[i]+" is Present","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
				
				}
			
			c.close();
			stm.close();
			}
			catch(java.sql.SQLIntegrityConstraintViolationException e )
			{
				JOptionPane.showMessageDialog(null,"For the day "+ ((TextField)DatePicker.getEditor()).getText()+" Employee id "+id[i]+"'s attendence is already added");
			}
			catch(ClassNotFoundException cnf)
			{
				System.out.println("Cnf Exception");
			}
			catch(SQLException sql)
			{
				JOptionPane.showMessageDialog(null,sql,"EXCEPTION",JOptionPane.ERROR_MESSAGE);
			}}
		}
         
     }
   @FXML
private void closeButtonAction(){
    // get a handle to the stage
//    Stage stage = (Stage) closeButton.getScene().getWindow();
     Stage stage = (Stage) anchor.getScene().getWindow();
     stage.close();
    // do what you have to do
   // stage.hide();
}
//    @FXML
//    private void exitAction(ActionEvent event) throws Exception{
//       // setDefaultCloseOperation(EXIT_ON_CLOSE);
//        exit.setOnAction(new EventHandler<ActionEvent>() {
//    @Override public void handle(ActionEvent event) {
//        
//        EmpattController.exitAction();
//    }
//});
    
   // }

    @Override
   public  void initialize(URL url, ResourceBundle rb) {
        // TODO
       
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

               // createAndShowGUI();

            }

            private void createAndShowGUI() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }    
    
}
