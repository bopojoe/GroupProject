package project.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import project.MovieList;

import java.io.IOException;

public class ControllerAddMovie {

    @FXML
    private Label exit;

    @FXML
    private TextField year;
    @FXML
    private TextField runtime;
    @FXML
    private TextArea plot;
    @FXML
    private TextField url;
    @FXML
    private TextField mTitle;




    @FXML
    private Button btn1;
    @FXML
    private Button btn2;

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
        if(event.getSource().equals(btn1)){
            //get reference to the button's stage
            stage=(Stage) btn1.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(getClass().getResource("../View/Add-Search-Modify.fxml"));
        }
        else{
            stage=(Stage) btn2.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("../View/Search.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        if(mTitle.getText() != null){
            String title = this.mTitle.getText();
            int year = Integer.parseInt(this.year.getText());
            int runtime = Integer.parseInt(this.runtime.getText());
            String plot = this.plot.getText();
            String url = this.url.getText();
            MovieList.addMovie(title, year, runtime, plot, url);
            try{
                MovieList.save();}catch (Exception e){
                System.out.println("Error writing to file: " + e);
            }

        }
    }
}
