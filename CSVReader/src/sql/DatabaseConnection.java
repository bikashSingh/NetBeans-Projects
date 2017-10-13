/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author bikashs
 */
public class DatabaseConnection {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/sales";
    private static final String USER = "root";
    private static final String PSWD = "3037542";

    private Connection connection;

    public DatabaseConnection() {
        this.connection = null;
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        if (connection == null) {
            connect();
        }
        return connection;
    }

    public void connect() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        connection = DriverManager.getConnection(URL, USER, PSWD);
    }

    public void disconnect() throws SQLException {
        connection.close();
    }
}
