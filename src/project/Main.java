package project;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.*;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
// import javafx.scene.control.*;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;




public class Main extends Application {

    private double xOffset = 0;
    private double yOffset = 0;

    Stage stage;
    Scene scene0, scene1, scene2;
    Button btnScene0, btnScene1, getBtnScene2;


    @Override
    public void start(Stage stage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("Start.fxml"));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.initStyle(StageStyle.TRANSPARENT);
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
            stage.setScene(scene0);
            stage.show();

            btnScene0 = new Button("I'm bored");
            btnScene0.setOnAction(e -> stage.setScene(scene1));

            AnchorPane anchorPane2 = new AnchorPane();
            anchorPane2.getChildren().add(btnScene0);
            scene2 = new Scene(anchorPane2, 700, 400);
    }

        public void ButtonClicked(ActionEvent e)
        {
            if (e.getSource() == btnScene0)
                stage.setScene(scene1);
            else
                stage.setScene(scene2);
        }



//        Scene scene1 = new Scene(root);
//
//        stage.setScene(scene1);
//        stage.show();



    public static void main(String[] args) {
        launch(args);
    }
}
