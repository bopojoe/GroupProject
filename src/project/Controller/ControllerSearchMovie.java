package project.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import project.IODriver;
import project.Main;
import project.Movie;

import java.io.IOException;

public class ControllerSearchMovie {


    @FXML
    private Label exit;
    @FXML
    private ComboBox comboBox;
    @FXML
    private Button btn1;
    @FXML
    private Button btn2, btn7, btn8, btn9;
    @FXML
    private TextField sTitle, sYear, sRuntime;

    protected static Text savedText;
    protected static String savedString;
    protected static Movie savedMovie;




    @FXML
    private void handleClose(MouseEvent event) {
        if (event.getSource() == exit) {
            System.exit(0);
        }
    }

    public void handle(ActionEvent event) {

    }

//    @FXML
//    private void handleButtonAction(ActionEvent event) throws IOException {
//        Stage stage;
//        Parent root;
//        if (event.getSource() == btn1) {
//            //get reference to the button's stage
//            stage = (Stage) btn1.getScene().getWindow();
//            //load up OTHER FXML document
//            root = FXMLLoader.load(getClass().getResource("../View/Add-Search.fxml"));
//        } else {
//            stage = (Stage) btn2.getScene().getWindow();
//            root = FXMLLoader.load(getClass().getResource("../View/AddActor.fxml"));
//        }
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//
//    }

    /*This is the Movie runtime search, it hashes thr runtime,
    finds it's position in the array and then linearly searches
     in case of multiple hashes to this point */
    @FXML
    private void handleButtonNine(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        int runtime;

        if (sRuntime != null) {
            boolean check = Main.parceCheck(sRuntime.getText());
            if (check) {
                runtime = Integer.parseInt(sRuntime.getText());
                if (runtime != 0) {
                    Movie returnedMovie = IODriver.listm(runtime);
                    savedMovie = returnedMovie;
                    stage = (Stage) btn9.getScene().getWindow();
                    root = FXMLLoader.load(getClass().getResource("../View/MovieResultsPage.fxml"));
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                    //ControllerResults.resultText.getChildren().add(t);

                    }

                else {
                    System.out.println("Please Enter a number for runtime in minutes ie. 106 ");
                }
            } else {
                System.out.println("Please Enter a number for runtime in minutes ie. 106 ");
            }

        }
    }

    @FXML
    private void handleButtonEight(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        int year;
        if (sYear != null) {
            boolean check = Main.parceCheck(sYear.getText());
            if (check) {
                year = Integer.parseInt(sYear.getText());
                if (year != 0) {
                    Movie returnedMovie = IODriver.yearSearch(year);
                    savedMovie = returnedMovie;
                    stage = (Stage) btn9.getScene().getWindow();
                    root = FXMLLoader.load(getClass().getResource("../View/MovieResultsPage.fxml"));
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } else {
                    System.out.println("Please Enter a number for year ie. 1998");
                }
            } else {
                System.out.println("Please Enter a number for year ie. 1998");
            }

        }
    }


    @FXML
    private void handleButtonSeven(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        if (sTitle != null) {
                String title = sTitle.getText();
            Movie returnedMovie = IODriver.titleSearch(title);
            savedMovie = returnedMovie;
            stage = (Stage) btn9.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("../View/MovieResultsPage.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
    }
}



