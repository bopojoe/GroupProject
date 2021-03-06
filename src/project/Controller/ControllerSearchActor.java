package project.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import project.Actor;
import project.IODriver;
import project.LinkedList;
import project.Main;

import java.io.IOException;

public class ControllerSearchActor {
    @FXML
    private Label exit;

    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3, btn5;
    @FXML
    private TextField sName, sAge, sGender, sNationality;

    protected static Actor savedActor;

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
/*
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
            root = FXMLLoader.load(getClass().getResource("../View/Name.fxml"));
        }
        else if(event.getSource()==btn2){
            stage=(Stage) btn2.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("../View/Gender.fxml"));
        }
        else if(event.getSource().equals(btn3)){
            stage=(Stage) btn3.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("../View/Nationality.fxml"));
        }
        else{
            stage=(Stage) btn5.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("../View/Search.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }*/

    @FXML
    private void handleButtonOne(ActionEvent event) throws IOException {
        String name;
        if (sName != null) {
            name = sName.getText();
            LinkedList<Actor> returnedActorList = IODriver.nameSearch(name);
            LinkedList.DataLink head = null;
            boolean test = true;
            try {
                head = returnedActorList.header;
            } catch (NullPointerException e) {
                test = false;
            }
            if (test) {
                multiList(head);
            } else {
                System.out.println("Search did not return a movie.");
            }
        } else {
            System.out.println("Please Enter a valid search for name");
        }

    }


    @FXML
    private void handleButtonTwo(ActionEvent event) throws IOException {
        int age;
        if (sAge != null) {
            boolean check = Main.parseCheck(sAge.getText());
            if (check) {
                age = Integer.parseInt(sAge.getText());
                if (age != 0) {
                    LinkedList<Actor> returnedActorList = IODriver.ageSearch(age);
                    LinkedList.DataLink head = null;
                    boolean test = true;
                    try {
                        head = returnedActorList.header;
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
    private void handleButtonThree(ActionEvent event) throws IOException {
        String gender;
        if (sGender != null) {
            gender = sGender.getText();
            LinkedList<Actor> returnedActorList = IODriver.genderSearch(gender);
            LinkedList.DataLink head = null;
            boolean test = true;
            try {
                head = returnedActorList.header;
            } catch (NullPointerException e) {
                test = false;
            }
            if (test) {
                multiList(head);
            } else {
                System.out.println("Search did not return a movie.");
            }
        } else {
            System.out.println("Please Enter a valid search for gender");
        }

    }

    @FXML
    private void handleButtonFour(ActionEvent event) throws IOException {
        String nat;
        if (sNationality != null) {
            nat = sNationality.getText();
            LinkedList<Actor> returnedActorList = IODriver.natSearch(nat);
            LinkedList.DataLink head = null;
            boolean test = true;
            try {
                head = returnedActorList.header;
            } catch (NullPointerException e) {
                test = false;
            }
            if (test) {
                multiList(head);
            } else {
                System.out.println("Search did not return a movie.");
            }
        } else {
            System.out.println("Please Enter a valid search for nationality");
        }

    }


    private void multiList(LinkedList.DataLink data) throws IOException {
        while (data.nextDataLink != null) {
            savedActor = (Actor) data.nextDataLink.data;
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../View/ActorResultsPage.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Better IMDB");
            stage.setScene(new Scene(root1));
            stage.getIcons().add(new Image("@../../home-page.png"));
            stage.show();
            data = data.nextDataLink;
        }
    }

    private void multiListEdit(LinkedList.DataLink data) throws IOException {
        while (data.nextDataLink != null) {
            savedActor = (Actor) data.nextDataLink.data;
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../View/EditActorResult.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Better IMDB");
            stage.setScene(new Scene(root1));
            stage.getIcons().add(new Image("@../../home-page.png"));
            stage.show();
            data = data.nextDataLink;
        }
    }


    @FXML
    private void handleButtonName(ActionEvent event) throws IOException {
        String name;
        if (sName != null) {
            name = sName.getText();
            LinkedList<Actor> returnedActorList = IODriver.nameSearch(name);
            LinkedList.DataLink head = null;
            boolean test = true;
            try {
                head = returnedActorList.header;
            } catch (NullPointerException e) {
                test = false;
            }
            if (test) {
                multiListEdit(head);
            } else {
                System.out.println("Search did not return a movie.");
            }
        } else {
            System.out.println("Please Enter a valid search for name");
        }


    }

    @FXML
    private void handleButtonAge(ActionEvent event) throws IOException {
        int age;
        if (sAge != null) {
            boolean check = Main.parseCheck(sAge.getText());
            if (check) {
                age = Integer.parseInt(sAge.getText());
                if (age != 0) {
                    LinkedList<Actor> returnedActorList = IODriver.ageSearch(age);
                    LinkedList.DataLink head = null;
                    boolean test = true;
                    try {
                        head = returnedActorList.header;
                    } catch (NullPointerException e) {
                        test = false;
                    }
                    if (test) {
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
    private void handleButtonGender(ActionEvent event) throws IOException {
        String gender;
        if (sGender != null) {
            gender = sGender.getText();
            LinkedList<Actor> returnedActorList = IODriver.genderSearch(gender);
            LinkedList.DataLink head = null;
            boolean test = true;
            try {
                head = returnedActorList.header;
            } catch (NullPointerException e) {
                test = false;
            }
            if (test) {
                multiListEdit(head);
            } else {
                System.out.println("Search did not return a movie.");
            }
        } else {
            System.out.println("Please Enter a valid search for gender");
        }


    }

    @FXML
    private void handleButtonNat(ActionEvent event) throws IOException {
        String nat;
        if (sNationality != null) {
            nat = sNationality.getText();
            LinkedList<Actor> returnedActorList = IODriver.natSearch(nat);
            LinkedList.DataLink head = null;
            boolean test = true;
            try {
                head = returnedActorList.header;
            } catch (NullPointerException e) {
                test = false;
            }
            if (test) {
                multiListEdit(head);
            } else {
                System.out.println("Search did not return a movie.");
            }
        } else {
            System.out.println("Please Enter a valid search for nationality");
        }

    }
}
