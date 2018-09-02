package code;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTableWorker {
    DBConnection dbConnection;
    Statement statement;
    ResultSet resultSet;
    private String tableName = null;

    public DBTableWorker(DBConnection dbConnection) throws SQLException {
        this.dbConnection = dbConnection;
        statement = this.dbConnection.getConnection().createStatement();
    }

    public void DBTW_init() throws SQLException {
        statement = dbConnection.getConnection().createStatement();
    }

    public void showTableList() throws SQLException {
        resultSet = statement.executeQuery("SELECT table_name FROM user_tables");
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1));
        }
    }
    public void showTableListI() throws SQLException { //DOESNT WORK
       DatabaseMetaData dmd = dbConnection.getConnection().getMetaData();
       resultSet = dmd.getTables(null, null, null, null);
       while (resultSet.next()) {
           System.out.println(resultSet.getString(3));
       }
    }

    public void tableCreate() {

    }

    public void tableDrop() throws SQLException {
        resultSet = statement.executeQuery("DROP TABLE " + tableName);
        System.out.println("TABLE " + tableName + " HAS BEEN DROPPED");
    }

    public void tableUpdate() {

    }

    public void tableInsert() {

    }

    public void showAll() throws SQLException {
        System.out.println("TableName: " + tableName);

        resultSet = statement.executeQuery("SELECT * FROM " + tableName);
        System.out.println("BRANCH_ID || ADDRESS || CITY || NAME || STATE || ZIP_CODE");
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1) + " || " + resultSet.getString(2) + " || " + resultSet.getString(3) + " || " +
                    resultSet.getString(4) + " || " + resultSet.getString(5) + " || ");
        }
        resultSet.close();
        statement.close();
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
