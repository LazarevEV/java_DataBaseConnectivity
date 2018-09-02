package code.sceneControllers;

import code.DBConnection;
import code.DBTableWorker;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class WorkScreenController implements Initializable {

    @FXML
    private BorderPane borderPane;

    @FXML
    private Button tableListButton;

    DBConnection dbConnection;
    DBTableWorker dbtw;

    private String username;
    private String password;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void showTableList() throws SQLException {
        System.out.println("Username: " + username + "  || Password: " + password);
        System.out.println("WSC_dbConnection: " + dbConnection);
        System.out.println("DBTW: " + dbtw);
        dbtw.setTableName("branch");
        dbtw.showAll();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public DBConnection getDbConnection() {
        return dbConnection;
    }

    public void setDbConnection(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public DBTableWorker getDbtw() {
        return dbtw;
    }

    public void setDbtw(DBTableWorker dbtw) {
        this.dbtw = dbtw;
    }
}
