package pl.coderslab.beans;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

@Component
public class DBCustomerLogger implements CustomerLogger {
    Connection connection;

    public DBCustomerLogger() throws SQLException {
        connection = DBUtil.connectDiagnostics();
        System.out.println("Cos");
    }

    @Override
    public void log() {
//TODO:insert log using DBUtil api(end connection)
        

    }


}
