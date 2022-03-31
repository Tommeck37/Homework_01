import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.coderslab.beans.*;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    private static String DIAGNOSTIC_QUERY = "insert into log (log_content) values (?);";


    static void addLog(String log_content) {
        try (Connection connection = DBUtil.connectDiagnostics()) {
            DBUtil.insert(connection, DIAGNOSTIC_QUERY, log_content);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        SimpleCustomerLogger simpleCustomerLogger = context.getBean(SimpleCustomerLogger.class);
////        simpleCustomerLogger.log();
//        MemoryCustomerRepository memoryCustomerRepository1 = context.getBean(MemoryCustomerRepository.class);
//        FileCustomerLogger fileCustomerLogger = context.getBean("fileCustomerLogger", FileCustomerLogger.class);
//
//        memoryCustomerRepository1.add(new Customer(150, "Tomasz", "Czornak"));
//        memoryCustomerRepository1.retrieve();
////        fileCustomerLogger.log();
//        System.out.println(memoryCustomerRepository1.retrieve().toString());

        DBCustomerLogger dbCustomerLogger = context.getBean(DBCustomerLogger.class);
        dbCustomerLogger.log();
        addLog("test");
        context.close();
    }




}
