package project;

public class Main {

    public static void main(String[] args) {
        Main test = new Main();


    }

    public Main() {
        IODriver app = new IODriver();


    }
}
/*



        import javafx.application.Application;
        import javafx.event.EventHandler;
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


        @Override
        public void start(Stage stage) throws Exception{



            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            stage.initStyle(StageStyle.UNDECORATED);
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




            Scene scene1 = new Scene(root);

            stage.setScene(scene1);
            stage.show();
        }


        public static void main(String[] args) {
            launch(args);
        }
    }

*/



