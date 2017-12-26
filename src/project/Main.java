package project;


/*public class Main{

    public static void main(String[] args) {
        Main test = new Main();


    }
    public Main(){
        IODriver app = new IODriver();


    }*/




        import javafx.application.Application;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
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



    public class Main extends Application {

        Stage window;
        Scene scene1, scene2;
        BorderPane layout;

        @Override
        public void start(Stage primaryStage) throws Exception{
            window = primaryStage;

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

            //button 1
            Label label1 = new Label("Welcome to the first scene!");
            Button button1 = new Button("Go to scene 2");
            button1.setOnAction(e -> window.setScene(scene2));

            //layout 1
            VBox layout1 = new VBox(20);
            layout1.getChildren().addAll(label1,button1);
            Scene scene1 = new Scene(layout, 400,400);


            window.setScene(scene1);
            window.setTitle("Better IMDB");
            window.show();
        }


        public static void main(String[] args) {
            launch(args);
        }
    }




