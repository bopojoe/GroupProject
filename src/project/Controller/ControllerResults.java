package project.Controller;

/**
 * @author James O'Rourke_20074556 on 30/12/2017
 */

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.text.TextFlow;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import project.Movie;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class ControllerResults implements Initializable {

    @FXML
    private Label exit;

    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Label year1, runtime1, plot1, url1, mTitle1, name1 ,age1, gender1, nationality1;


    @FXML
    private void handleClose(MouseEvent event) {
        if(event.getSource()== exit)
        {
            System.exit(0);
        }
    }

    public void handle(ActionEvent event){

    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        if(event.getSource()==btn1){
            //get reference to the button's stage
            stage=(Stage) btn1.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(getClass().getResource("../View/SearchActor.fxml"));
        }
        else{
            stage=(Stage) btn2.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("../View/SearchMovie.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String runt = Integer.toString(ControllerSearchMovie.savedMovie.getRunningTime());
        String year = Integer.toString(ControllerSearchMovie.savedMovie.getYear());
        String title = ControllerSearchMovie.savedMovie.getTitle();
        String plot = ControllerSearchMovie.savedMovie.getPlot();
        String url = ControllerSearchMovie.savedMovie.getImgUrl();
        mTitle1.setText(title);
        plot1.setText(plot);
        url1.setText(url);
        year1.setText(year);
        runtime1.setText(runt);
        //String name = ControllerSearchActor.savedActor.getName();
        //String age = Integer.toString(ControllerSearchActor.savedActor.getAge());
       // String gender = ControllerSearchActor.savedActor.getGender();
      //  String nationality = ControllerSearchActor.savedActor.getNationality();
      //  name1.setText(name);
      //  age1.setText(age);
      //  gender1.setText(gender);
      //  nationality1.setText(nationality);
    }
}