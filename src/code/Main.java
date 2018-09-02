package code;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws ClassNotFoundException, SQLException, IOException {
        DBConnection dbConnection = new DBConnection();
        DBTableWorker dbtw = new DBTableWorker("branch");

        String user = null;
        String password = null;

        //FOR TESTS---//
        user = "C##dbu";
        password = "SQLdev0112";
        //------------//

        initScene(primaryStage);

        dbtw.DBTW_init(user, password);
        //dbConnection.setConnection(user, password);
    }
    private String getUsPass(int code) { // code == 0 - User || code == 1 - Password
        Scanner scanner = new Scanner(System.in);

        if (code == 0) {
            System.out.println("Enter UserName: ");
             return scanner.nextLine();
        } else {
            System.out.println("Enter Password: ");
            return scanner.nextLine();
        }
    }

    private void initScene(Stage primaryStage) throws IOException {
        Parent root = new FXMLLoader(this.getClass().getResource("/resources/fxml/logInScreen.fxml")).load();
        primaryStage.setTitle("Log In");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
