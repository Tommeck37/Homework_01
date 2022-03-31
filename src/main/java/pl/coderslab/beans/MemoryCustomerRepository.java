package pl.coderslab.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemoryCustomerRepository implements CustomerRepository {


        @Autowired
    private SimpleCustomerLogger simpleCustomerLogger;

    public MemoryCustomerRepository(SimpleCustomerLogger simpleCustomerLogger) {
        this.simpleCustomerLogger = simpleCustomerLogger;
    }

    private List<Customer> customerList = new ArrayList<>();

    @Override
    public void add(Customer customer) {
        customerList.add(customer);
        simpleCustomerLogger.log();
    }

    @Override
    public void remove(Customer customer) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i) == customer) {
                customerList.remove(customer);
            }
        }
        simpleCustomerLogger.log();

    }

    @Override
    public List<Customer> retrieve() {
        return customerList;

    }

}
