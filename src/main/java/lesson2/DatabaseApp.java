package lesson2;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//import org.apache.derby.jdbc.EmbeddedDriver;

public class DatabaseApp {


//    static Driver derbyEmbeddedDriver = new EmbeddedDriver();
    static final String DATABASE_URL = "jdbc:sqlite:javadb.db";
    static Connection connection;
    static Statement statement;

    static {
        try {
            Class.forName("org.sqlite.JDBC");

          //  connection = DriverManager.getConnection(DATABASE_URL);
            connection = DriverManager.getConnection
                    ("jdbc:derby:testdb1;create=true", "user", "pass123");
            statement = connection.createStatement();
            connection.setAutoCommit(false);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        DatabaseApp databaseApp = new DatabaseApp();
        databaseApp.createTable();
        databaseApp.insertNewBike("bike1", "no1");
        databaseApp.insertNewBikePS("model", "serial");
        System.out.println(databaseApp.searchForBike());
        databaseApp.dropTable();

    }

    public void createTable() throws SQLException {
        String createTable = "create table bike (" +
                "id integer not null primary key, " +
                "model varchar(30) not null, " +
                "serial_no varchar(10))";
        statement.execute(createTable);
    }

    public void insertNewBike(String name, String serial) throws SQLException {
        String insertSql = "insert into bike (model, serial_no) values ('" + name + "', '" + serial + "')";
        statement.execute(insertSql);
    }

    public void insertNewBikePS(String model, String serial) throws SQLException {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement("insert into bike (model, serial_no) values (?,?)")) {
            for (int i = 1; i < 11; i++) {
                preparedStatement.setString(1, model + " " + i);
                preparedStatement.setString(2, serial + " " + (i + 10));
                preparedStatement.addBatch();
            }
            int[] ints = preparedStatement.executeBatch();
            connection.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
            connection.rollback();
        }
    }

    public List<Bike> searchForBike() throws SQLException {
        String sql = "select * from bike";
        ResultSet resultSet = statement.executeQuery(sql);
        List<Bike> list = new ArrayList<>();
        while (resultSet.next()) {
            list.add(new Bike(
                    resultSet.getInt("id"),
                    resultSet.getString("model"),
                    resultSet.getString("serial_no")
                    )
            );
            System.out.println("id = " + resultSet.getInt("id")+ " " +
                    resultSet.getString("model") + " " +
                    resultSet.getString(3));
        }
        return list;
    }

    public void dropTable() throws SQLException {
        String dropSql = "drop table bike";
        statement.execute(dropSql);
    }

}
