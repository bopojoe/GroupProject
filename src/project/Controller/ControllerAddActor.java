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

import javafx.scene.control.TextField;
import project.ActorList;

import java.io.IOException;


public class ControllerAddActor {
    @FXML
    private Label exit;

    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private TextField name,gender,nationality,age;


    @FXML
    private void handleClose(MouseEvent event) throws IOException {
        if (event.getSource() == exit) {
            Parent root;
            Stage stage;
            stage = (Stage) btn1.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("../View/Start.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
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
            root = FXMLLoader.load(getClass().getResource("../View/Add-Search-Modify.fxml"));
        }
        else{
            stage=(Stage) btn2.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("../View/AddActor.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        if(name.getText() != null){
            String name = this.name.getText();
            int age = Integer.parseInt(this.age.getText());
            String gender = this.gender.getText();
            String nationality = this.nationality.getText();

            ActorList.addActor(name,age,gender,nationality);

        }

    }
}
