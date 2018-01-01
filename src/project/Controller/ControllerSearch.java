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

public class ControllerSearch {

    @FXML
    private Label exit;

    @FXML
    private Button btn1;
    @FXML
    private Button btn2, btn22, btnAct, btnMove;

    @FXML
    private void handleClose(MouseEvent event) throws IOException {
        if (event.getSource() == exit) {
            Parent root;
            Stage stage;
            stage = (Stage) btn2.getScene().getWindow();
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
    @FXML
    private void handleButtonActor(ActionEvent event) throws IOException {
        Parent root;
        Stage stage;
        stage = (Stage) btn22.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("../View/EditActor.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }
    @FXML
    private void handleButtonMovie(ActionEvent event) throws IOException {
        Parent root;
        Stage stage;
        stage = (Stage) btn22.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("../View/EditMovie.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    private void handleButtonEdit(ActionEvent event) throws IOException {
        Parent root;
        Stage stage;
        stage = (Stage) btn2.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("../View/Edit.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void handleButtonDelete(ActionEvent event) throws IOException {
        Parent root;
        Stage stage;
        stage = (Stage) btn2.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("../View/Delete.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void ButtonMovieDelete(ActionEvent event) throws IOException {
        Parent root;
        Stage stage;
        stage = (Stage) btnMove.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("../View/DeleteMovie.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void ButtonActorDelete(ActionEvent event) throws IOException {
        Parent root;
        Stage stage;
        stage = (Stage) btnAct.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("../View/DeleteActor.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
