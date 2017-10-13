package dao;

import model.Customer;

public interface CustomerDao {

    boolean insertIntoCustomer(Customer customer);

    boolean updateCustomer(Customer customer);

    boolean deleteCustomer(Customer customer);

    Customer[] listCustomer();

    Customer getCustomer(int customerId);

    Customer[] findCustomer(String custName);
}
