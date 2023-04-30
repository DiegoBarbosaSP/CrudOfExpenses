package br.com.CrudOfExpensives.model.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    // singleton
    private ConnectionFactory(){}

    public  static Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/expensives_db2","root","58337120");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
