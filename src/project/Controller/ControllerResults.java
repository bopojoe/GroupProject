package project.Controller;

/**
 * @author James O'Rourke_20074556 on 30/12/2017
 */

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.text.TextFlow;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import project.Actor;
import project.ActorList;
import project.Movie;
import project.MovieList;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class ControllerResults implements Initializable {

    @FXML
    private Label exit;

    @FXML
    private Button btn1, changeBtn, BtnAtr;
    @FXML
    private Button btn2;
    @FXML
    private Label year1, runtime1, plot1, url1, mTitle1, name1 ,age1, gender1, nationality1;
    @FXML
    private TextField year2, runtime2, plot2, url2, mTitle2, sName, sAge, sGender, sNationality;


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

    @FXML
    private void handleButtonChange(ActionEvent event) throws IOException {
       Movie movie = ControllerSearchMovie.savedMovie;
       MovieList.removeMovie(movie);
        String title = this.mTitle2.getText();
        int year = Integer.parseInt(this.year2.getText());
        int runtime = Integer.parseInt(this.runtime2.getText());
        String plot = this.plot2.getText();
        String url = this.url2.getText();
        MovieList.addMovie(title, year, runtime, plot, url);

        Stage stage = (Stage) changeBtn.getScene().getWindow();
        // do what you have to do
        stage.close();

    }

    @FXML
    private void changeActorBtn(ActionEvent event) throws IOException {
        Actor actor = ControllerSearchActor.savedActor;
        ActorList.removeActor(actor);
        String name = this.sName.getText();
        int age = Integer.parseInt(this.sAge.getText());
        String gender = this.sGender.getText();
        String nat = this.sNationality.getText();
        ActorList.addActor(name,age,gender,nat);

        Stage stage = (Stage) BtnAtr.getScene().getWindow();
        // do what you have to do
        stage.close();

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
        boolean test = false;

            if (ControllerSearchMovie.savedMovie != null) {

                String runt = Integer.toString(ControllerSearchMovie.savedMovie.getRunningTime());
                String year = Integer.toString(ControllerSearchMovie.savedMovie.getYear());
                String title = ControllerSearchMovie.savedMovie.getTitle();
                String plot = ControllerSearchMovie.savedMovie.getPlot();
                String url = ControllerSearchMovie.savedMovie.getImgUrl();
                try{
                mTitle1.setText(title);
                plot1.setText(plot);
                url1.setText(url);
                year1.setText(year);
                runtime1.setText(runt);
            } catch (NullPointerException e) {test = true;}
                if (test){

                    mTitle2.setText(title);
                    plot2.setText(plot);
                    url2.setText(url);
                    year2.setText(year);
                    runtime2.setText(runt);
                }
            } else {
                String name = ControllerSearchActor.savedActor.getName();
                String age = Integer.toString(ControllerSearchActor.savedActor.getAge());
                String gender = ControllerSearchActor.savedActor.getGender();
                String nationality = ControllerSearchActor.savedActor.getNationality();
                try {
                    name1.setText(name);
                    age1.setText(age);
                    gender1.setText(gender);
                    nationality1.setText(nationality);
                }catch (NullPointerException e) {test = true;}
                if (test) {
                    sName.setText(name);
                    sAge.setText(age);
                    sGender.setText(gender);
                    sNationality.setText(nationality);
                }
            }

    }
}