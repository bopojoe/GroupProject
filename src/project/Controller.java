package project;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;

public class Controller implements EventHandler<ActionEvent>{

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


}
