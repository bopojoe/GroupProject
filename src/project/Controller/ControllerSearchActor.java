package project.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerSearchActor {
    @FXML
    private Label exit;

    @FXML
    private Button btn1, btn2, btn3, btn4;


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
            root = FXMLLoader.load(getClass().getResource("../View/ActorName.fxml"));
        }
        else if(event.getSource()==btn2){
            stage=(Stage) btn2.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("../View/ActorAge.fxml"));
        }
        else if(event.getSource().equals(btn3)){
            stage=(Stage) btn3.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("../View/ActorGender.fxml"));
        }
        else{
            stage=(Stage) btn4.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("../View/ActorNationality.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
