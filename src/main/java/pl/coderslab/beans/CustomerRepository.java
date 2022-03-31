package pl.coderslab.beans;

import java.util.List;

public interface CustomerRepository {
    public void add(Customer customer);

    public void remove(Customer customer);

    public List<Customer> retrieve();

}
