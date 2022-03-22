package pl.coderslab.beans;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component

public class MemoryCustomerRepository implements CustomerRepository {
    private final CustomerLogger customerLogger;

    public MemoryCustomerRepository(CustomerLogger customerLogger) {
        this.customerLogger = customerLogger;
    }

    @Override
    public void add() {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer());
        customerLogger.log();
    }

    @Override
    public void remove() {
        List<Customer> customerList = new ArrayList<>();
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i) != null) {
                customerList.remove(customerList.get(i));
            }
        }
        customerLogger.log();

    }

    @Override
    public void retrieve() {
        List<Customer> customerList = new ArrayList<>();
        customerList.stream()
                .forEach(System.out::println);
        customerLogger.log();
    }
}
