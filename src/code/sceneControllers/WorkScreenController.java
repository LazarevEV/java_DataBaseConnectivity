package code.sceneControllers;

import code.DBConnection;
import code.DBTableWorker;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.TextAlignment;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class WorkScreenController implements Initializable {

    @FXML
    private BorderPane borderPane;

    @FXML
    private JFXButton tableListButton;

    @FXML
    private VBox tableList;

    DBConnection dbConnection;
    DBTableWorker dbtw;

    private String username;
    private String password;
    private ArrayList<String> tableArrList = new ArrayList<String>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void showTableList() throws SQLException {
        tableArrList = dbtw.getTableList();
        for (String talTemp : tableArrList) {
            JFXButton button = new JFXButton();
            button.setPrefSize(tableList.getWidth(), Region.USE_COMPUTED_SIZE);
            button.setText(talTemp);
            button.setButtonType(JFXButton.ButtonType.FLAT);
            button.setStyle("-fx-text-alignment: CENTER");
            button.setStyle("-fx-text-fill: #e4e4e4");
            button.setStyle("-fx-background-color: #6A7F97");
            button.setStyle("-fx-background-radius: 0");
            button.setOnAction(event ->  {
                try {
                    dbtw.showAll(talTemp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
            tableList.getChildren().add(button);
        }
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
