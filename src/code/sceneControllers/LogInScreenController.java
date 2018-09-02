package code.sceneControllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;
import org.w3c.dom.events.Event;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class LogInScreenController {

    @FXML
    private TextField userTF;

    @FXML
    private Button loginButton;

    @FXML
    private TextField passTF;

    public void logIn() {
        if (check()) {
            System.out.println("CORRECT");
            openWorkScreen();
            ((Stage) loginButton.getScene().getWindow()).close();
        } else {
            System.out.println("Username or password is incorrect! Try again!");
            userTF.setText(null);
            passTF.setText(null);
        }
    }

    private boolean check() {
        if (userTF.getText().equals("C##dbu") && passTF.getText().equals("SQLdev0112")) return true;
        else return false;
    }

    private void openWorkScreen() {
        Parent root = null;
        try {
            root = new FXMLLoader(this.getClass().getResource("/resources/fxml/WorkScreen.fxml")).load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage gameStage = new Stage();
        gameStage.setTitle("Game Screen");
        gameStage.setScene(new Scene(root));
        gameStage.setResizable(false);
        gameStage.show();
    }

}
