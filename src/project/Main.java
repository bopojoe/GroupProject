package project;



public class Main{

    public static void main(String[] args) {
        Main test = new Main();


    }
    public Main(){
        IODriver app = new IODriver();


    }

/*public class Main extends Application {

    Button button;

    @Override
    public void start(Stage primaryStage) throws Exception{
        button = new Button("Add");
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }*/


/*package project;


        import javafx.application.Application;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.control.*;
        import javafx.scene.layout.BorderPane;
        import javafx.stage.Stage;



    public class Main extends Application {

        Stage window;
        BorderPane layout;

        @Override
        public void start(Stage primaryStage) throws Exception{
            window = primaryStage;
            window.setTitle("Better IMDB");
            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

            //Search Menu
            Menu searchMenu = new Menu("search");

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
    }*/

}
