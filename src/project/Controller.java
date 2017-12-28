package project;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;

public class Controller implements EventHandler<ActionEvent>{
    IODriver test = new IODriver();

    @FXML
    private Label exit;

    @FXML
    private void handleClose(MouseEvent event) {
        if(event.getSource()== exit)
        {
            System.exit(0);
        }
    }
    public void handle(ActionEvent event){

    }
    @FXML
    public void test()
    {
        System.out.println("test");
        test.fillArray(49);
        test.setupAdditions(30);

    }




}
