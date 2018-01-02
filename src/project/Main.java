package project;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application {

    private double xOffset = 0;
    private double yOffset = 0;

    private Stage stage;
    private Scene scene0, scene1, scene2;
    private Button btnScene0, btnScene1, getBtnScene2;
    private AnchorPane pane1, pane2;
    private IODriver setup = new IODriver();


    @Override
    public void start(Stage stage) throws Exception {


        Parent root = FXMLLoader.load(getClass().getResource("View/Start.fxml"));
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });

        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            }
        });


        stage.setTitle("Better IMDB");
        scene0 = new Scene(root);
        scene0.setFill(Color.TRANSPARENT);
        stage.getIcons().add(new Image("@../../home-page.png"));
        stage.setScene(scene0);
        stage.show();


    }

    // check to see if the string inputted was parseable to int
    public static boolean parseCheck(String V) {

        boolean parseable = true;
        try {
            Integer.parseInt(V);
        } catch (NumberFormatException e) {
            parseable = false;
        }
        return parseable;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
