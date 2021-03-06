package project.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import project.IODriver;
import project.LinkedList;
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

    protected static Movie savedMovie;


    @FXML
    private void handleClose(MouseEvent event) throws IOException {
        if (event.getSource() == exit) {
            Parent root;
            Stage stage;
            stage = (Stage) btn8.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("../View/Start.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    public void handle(ActionEvent event) {

    }


    /*This is the Movie runtime search, it hashes thr runtime,
    finds it's position in the array and then linearly searches
     in case of multiple hashes to this point */
    @FXML
    private void handleButtonNine(ActionEvent event) throws IOException {
        int runtime;

        if (sRuntime != null) {
            boolean check = Main.parseCheck(sRuntime.getText());
            if (check) {
                runtime = Integer.parseInt(sRuntime.getText());
                if (runtime != 0) {
                    LinkedList<Movie> returnedMovieList = IODriver.runtimeSearch(runtime);
                    LinkedList.DataLink head = null;
                    boolean test = true;
                    try {
                        head = returnedMovieList.header;
                    } catch (NullPointerException e) {
                        test = false;
                    }
                    if (test) {
                        multiList(head);
                    } else {
                        System.out.println("Search did not return a movie.");
                    }
                } else {
                    System.out.println("Please Enter a number for runtime in minutes ie. 106 ");
                }
            } else {
                System.out.println("Please Enter a number for runtime in minutes ie. 106 ");
            }

        }
    }

    @FXML
    private void handleButtonEight(ActionEvent event) throws IOException {
        int year;
        if (sYear != null) {
            boolean check = Main.parseCheck(sYear.getText());
            if (check) {
                year = Integer.parseInt(sYear.getText());
                if (year != 0) {
                    LinkedList<Movie> returnedMovieList = IODriver.yearSearch(year);
                    LinkedList.DataLink head = null;
                    boolean test = true;
                    try {
                        head = returnedMovieList.header;
                    } catch (NullPointerException e) {
                        test = false;
                    }
                    if (test) {
                        multiList(head);
                    } else {
                        System.out.println("Search did not return a movie.");
                    }

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
        if (sTitle != null) {
            String title = sTitle.getText();
            LinkedList<Movie> returnedMovieList = IODriver.titleSearch(title);
            LinkedList.DataLink head = null;
            boolean test = true;
            try {
                head = returnedMovieList.header;
            } catch (NullPointerException e) {
                test = false;
            }
            if (test) {
                multiList(head);
            } else {
                System.out.println("Search did not return a movie.");
            }


        }
    }

    private void multiList(LinkedList.DataLink data) throws IOException {
        while (data.nextDataLink != null) {
            savedMovie = (Movie) data.nextDataLink.data;
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../View/MovieResultsPage.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Better IMDB");
            stage.getIcons().add(new Image("@../../home-page.png"));
            stage.setScene(new Scene(root1));
            stage.show();
            data = data.nextDataLink;
        }
    }

    private void multiListEdit(LinkedList.DataLink data) throws IOException {
        while (data.nextDataLink != null) {
            savedMovie = (Movie) data.nextDataLink.data;
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../View/EditMovieResult.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Better IMDB");
            stage.getIcons().add(new Image("@../../home-page.png"));
            stage.setScene(new Scene(root1));
            stage.show();
            data = data.nextDataLink;
        }
    }

    @FXML
    private void handleButtonTitle(ActionEvent event) throws IOException {
        if (sTitle != null) {
            String title = sTitle.getText();
            LinkedList<Movie> returnedMovieList = IODriver.titleSearch(title);
            LinkedList.DataLink head = null;
            boolean test = true;
            try {
                head = returnedMovieList.header;
            } catch (NullPointerException e) {
                test = false;
            }
            if (test) {
                multiListEdit(head);
            } else {
                System.out.println("Search did not return a movie.");
            }


        }


    }

    @FXML
    private void handleButtonyear(ActionEvent event) throws IOException {
        int year;
        if (sYear != null) {
            boolean check = Main.parseCheck(sYear.getText());
            if (check) {
                year = Integer.parseInt(sYear.getText());
                if (year != 0) {
                    LinkedList<Movie> returnedMovieList = IODriver.yearSearch(year);
                    LinkedList.DataLink head;
                    head = null;
                    check = true;
                    try {
                        head = returnedMovieList.header;
                    } catch (NullPointerException e) {
                        check = false;
                    }
                    if (check) {
                        multiListEdit(head);
                    } else {
                        System.out.println("Search did not return a movie.");
                    }
                } else {
                    System.out.println("Please Enter a number for year ie. 1998");
                }
            } else {
                System.out.println("Please Enter a number for year ie. 1998");
            }

        }
    }

    @FXML
    private void handleButtonRuntime(ActionEvent event) throws IOException {

        int runtime;
        if (sRuntime != null) {
            boolean check = Main.parseCheck(sRuntime.getText());
            if (check) {
                runtime = Integer.parseInt(sRuntime.getText());
                if (runtime != 0) {
                    LinkedList<Movie> returnedMovieList = IODriver.runtimeSearch(runtime);
                    LinkedList.DataLink head;
                    head = null;
                    check = true;
                    try {
                        head = returnedMovieList.header;
                    } catch (NullPointerException e) {
                        check = false;
                    }
                    if (check) {
                        multiListEdit(head);
                    } else {
                        System.out.println("Search did not return a movie.");
                    }
                } else {
                    System.out.println("Please Enter a number for runtime in minutes ie. 106");
                }
            } else {
                System.out.println("Please Enter a number for runtime in minutes ie. 106");
            }

        }
    }
}



