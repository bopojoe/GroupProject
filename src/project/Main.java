package project;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
// import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;




public class Main extends Application {

    private double xOffset = 0;
    private double yOffset = 0;

    private Stage stage;
    private Scene scene0, scene1, scene2;
    private Button btnScene0, btnScene1, getBtnScene2;
    private AnchorPane pane1,pane2;




    @Override
    public void start(Stage stage) throws Exception{


        Parent root = FXMLLoader.load(getClass().getResource("View/Start.fxml"));
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
                stage.setScene(scene0);
            else if(e.getSource() == btnScene1)
                stage.setScene(scene1);
            else
                stage.setScene(scene2);
        }




    public static void main(String[] args) {
        launch(args);
    }
}
