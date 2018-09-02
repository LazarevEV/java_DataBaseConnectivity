package code;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws ClassNotFoundException {
        DBConnection dbConnection = new DBConnection();
        String user = null;
        String password = null;

        //user = getUsPass(0);
       //password = getUsPass(1);

        //FOR TESTS---//
        user = "C##dbu";
        password = "SQLdev0112";
        //------------//

        dbConnection.setConnection(user, password);
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
}
