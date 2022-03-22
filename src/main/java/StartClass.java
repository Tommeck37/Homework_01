import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.coderslab.beans.CustomerLogger;
import pl.coderslab.beans.SimpleCustomerLogger;

public class StartClass {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        SimpleCustomerLogger customerLogger = context.getBean(SimpleCustomerLogger.class);
        customerLogger.log();

    }
}
