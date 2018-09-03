package code;

import java.sql.*;
import java.util.ArrayList;

public class DBTableWorker {
    DBConnection dbConnection;
    Statement statement;
    ResultSet resultSet;
    ResultSetMetaData rsmd;
    private String tableName = null;

    public DBTableWorker(DBConnection dbConnection) throws SQLException {
        this.dbConnection = dbConnection;
        statement = this.dbConnection.getConnection().createStatement();
    }

    public void DBTW_init() throws SQLException {
        statement = dbConnection.getConnection().createStatement();
    }

    public ArrayList<String> getTableList() throws SQLException {
        ArrayList<String> tableList = new ArrayList<String>();
        resultSet = statement.executeQuery("SELECT table_name FROM user_tables");
        int i = 0;
        while (resultSet.next()) {
            tableList.add(resultSet.getString(1));
        }
        return tableList;
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

    public Table showAll(String tableName) throws SQLException {

        resultSet = statement.executeQuery("SELECT * FROM " + tableName);
        rsmd = resultSet.getMetaData();

        int colomns = rsmd.getColumnCount();
        ArrayList<String> colomnNames = new ArrayList<>();
        ArrayList<String> data = new ArrayList<>();

        for (int i = 1; i <= colomns; i++) colomnNames.add(rsmd.getColumnName(i));

        while (resultSet.next()) {
            for (int i = 1; i <= colomns; i++) {
                data.add(resultSet.getString(i));
            }
        }
        //TEST DATA ARRAYLIST
//        System.out.println("\nDATA:");
////        int i = 1;
////        for (String str : data) {
////            if (i != colomns) {
////                System.out.print(str + " || ");
////                i++;
////            } else {
////                System.out.println(str);
////                i = 1;
////            }
////        }

//        resultSet.close();
//        statement.close();
        return new Table(tableName, colomns, colomnNames, data);
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
