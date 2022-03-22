import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.coderslab.beans.Customer;
import pl.coderslab.beans.CustomerLogger;
import pl.coderslab.beans.MemoryCustomerRepository;
import pl.coderslab.beans.SimpleCustomerLogger;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        SimpleCustomerLogger simpleCustomerLogger = context.getBean("simpleCustomerLogger", SimpleCustomerLogger.class);
//        simpleCustomerLogger.log();
        MemoryCustomerRepository memoryCustomerRepository = new MemoryCustomerRepository(simpleCustomerLogger);
        memoryCustomerRepository.add();
//        memoryCustomerRepository.retrieve();
        memoryCustomerRepository.remove();
        memoryCustomerRepository.retrieve();

        context.close();
    }




}
