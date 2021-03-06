package code.sceneControllers;

import code.DBConnection;
import code.DBTableWorker;
import code.Table;
import com.jfoenix.controls.JFXButton;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class WorkScreenController implements Initializable {

    @FXML
    private BorderPane borderPane;

    @FXML
    private JFXButton tableListButton;

    @FXML
    private VBox tableList;

    @FXML
    private TableView<ObservableList> tableView;

    DBConnection dbConnection;
    DBTableWorker dbtw;

    private String username;
    private String password;
    private ArrayList<String> tableArrList = new ArrayList<String>();
    private Table table;

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
            button.getStylesheets().add("/resources/css/WorkScreen.css");
            button.getStyleClass().add("tableButton");
            button.setOnAction(event -> {
                try {
                    showTable(talTemp);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
            tableList.getChildren().add(button);
        }
//TEST SCROLL PANE
//        for (int i = 0; i<10; i++) {
//            JFXButton button = new JFXButton();
//            button.setPrefSize(tableList.getWidth(), Region.USE_COMPUTED_SIZE);
//            button.setText("Button "+i);
//            button.setButtonType(JFXButton.ButtonType.FLAT);
//            button.getStylesheets().add("/resources/css/WorkScreen.css");
//            button.getStyleClass().add("tableButton");
//            tableList.getChildren().add(button);
//        }
    }

    private void showTableI(String tableName) throws SQLException {
        table = dbtw.showAll(tableName);
        tableView.getColumns().clear();
        ArrayList<TableColumn> tabColAL = new ArrayList<>();
        for (String str : table.getColomnNames()) {
            TableColumn tabCol = new TableColumn(str);
            tabCol.setPrefWidth(tableView.getPrefWidth() / table.getColumns());
            tableView.getColumns().add(tabCol);
        }
    }

    public void showTable(String tableName) throws SQLException {
        table = dbtw.showAll(tableName);
        tableView.getColumns().clear();

        for (int i = 0; i < table.getColumns(); i++) {
            final int j = i;
            TableColumn tabCol = new TableColumn(table.getColomnNames().get(i));
            tabCol.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){
                public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {
                    return new SimpleStringProperty(param.getValue().get(j).toString());
                }
            });


            tabCol.setPrefWidth(tableView.getPrefWidth() / table.getColumns());
            tableView.getColumns().add(tabCol);
        }

        tableView.setItems(table.getData());

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
