package project;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main{

    public static void main(String[] args) {
        Main test = new Main();


    }
    public Main(){
        IODriver app = new IODriver();


    }

/*
package project;


        import javafx.application.Application;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.control.Label;
        import javafx.scene.layout.BorderPane;
        import javafx.scene.control.MenuItem;
        import javafx.scene.control.Menu;
        import javafx.scene.control.MenuBar;
        import javafx.scene.control.SeparatorMenuItem;
        import javafx.scene.control.TextField;
        import javafx.geometry.Insets;
        import javafx.geometry.Pos;
        import javafx.scene.layout.Background;
        import javafx.scene.layout.BackgroundFill;
        import javafx.scene.layout.CornerRadii;
        import javafx.scene.paint.Color;
        import javafx.stage.Stage;



    public class Main extends Application {

        Stage window;
        BorderPane layout;

        @Override
        public void start(Stage primaryStage) throws Exception{
            window = primaryStage;
            window.setTitle("Better IMDB");
            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));



//        bp.setTop(x=new Label("Air"));
//        x.setAlignment(Pos.CENTER);
//        x.setBackground(new Background(new BackgroundFill(Color.BISQUE,
//                new CornerRadii(4),new Insets(3))));
//        x.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
//        x.setPrefHeight(50);


            //Search Menu
            Menu searchMenu = new Menu("_search");

            //Menu Items
            MenuItem newFile = new MenuItem("New");
            newFile.setOnAction(e -> System.out.println("Create a new file"));
            searchMenu.getItems().add(newFile);
            searchMenu.getItems().add(new MenuItem("Actor"));
            searchMenu.getItems().add(new SeparatorMenuItem());
            searchMenu.getItems().add(new MenuItem("Movie"));
            searchMenu.getItems().add(new SeparatorMenuItem());
            searchMenu.getItems().add(new MenuItem("Exit"));

            //Main menu bar
            MenuBar menuBar = new MenuBar();
            menuBar.getMenus().addAll(searchMenu);

            layout = new BorderPane();
            layout.setTop(menuBar);

            Scene scene = new Scene(layout, 400,400);
            window.setScene(scene);
            window.show();
        }


        public static void main(String[] args) {
            launch(args);
        }
    }
*/


}
