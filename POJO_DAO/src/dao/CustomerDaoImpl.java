package dao;

import java.sql.*;
import model.Customer;

public class CustomerDaoImpl implements CustomerDao {

    ConnectToDatabase connect = new ConnectToDatabase();
    private final Connection connection = connect.getConnection();

    @Override
    public boolean insertIntoCustomer(Customer customer) {
        boolean status = false;
        String query = "insert into customer values(?,?,?,?,?)";
        PreparedStatement st;
        try {
            st = connection.prepareStatement(query);
            st.setInt(1, customer.getCustomerId());
            st.setString(2, customer.getCustomerName());
            st.setString(3, customer.getCity());
            st.setInt(4, customer.getGrade());
            st.setInt(5, customer.getCustomerId());
            st.executeUpdate();
            status = true;
            st.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return status;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        boolean status = false;
        String query = "update customer set cust_name=?,city=?,grade=? where customer_id=?";
        PreparedStatement st;
        try {
            st = connection.prepareStatement(query);
            st.setString(1, customer.getCustomerName());
            st.setString(2, customer.getCity());
            st.setInt(3, customer.getGrade());
            st.setInt(4, customer.getCustomerId());
            
            st.executeUpdate();
            status = true;
            st.close();

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return status;

    }

    @Override
    public boolean deleteCustomer(Customer customer) {
        boolean status = false;
        String query = "delete from customer where customer_id=?";
        PreparedStatement st;
        try {
            st = connection.prepareStatement(query);
            st.setInt(1, customer.getCustomerId());
            st.executeUpdate();
            status = true;
            st.close();

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return status;
    }

    @Override
    public Customer[] listCustomer() {
        Customer[] customer = new Customer[10];
        String query = "select * from customer";
        try {
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(query);
            int i = 0;
            while (resultSet.next()) {
                customer[i] = new Customer();
                customer[i].setCustomerId(resultSet.getInt("customer_id"));
                customer[i].setCustomerName(resultSet.getString("cust_name"));
                customer[i].setCity(resultSet.getString("city"));
                customer[i].setGrade(resultSet.getInt("grade"));
                customer[i].setCustomerId(resultSet.getInt("customer_id"));
                i++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return customer;
    }

    @Override
    public Customer getCustomer(int customerId) {
        Customer customer = new Customer();
        String query = "select * from customer where customer_id = " + customerId;
        try {
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(query);
            resultSet.next();
            customer.setCustomerId(customerId);
            customer.setCustomerName(resultSet.getString("cust_name"));
            customer.setCity(resultSet.getString("city"));
            customer.setGrade(resultSet.getInt("grade"));
            customer.setCustomerId(resultSet.getInt("customer_id"));

        } catch (Exception e) {
            System.out.println(e);
        }
        return customer;

    }

    @Override
    public Customer[] findCustomer(String custName) {
       Customer[] customer = new Customer[10];
        String query = "select * from customer where name=" + custName;
        try {
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(query);
            int i = 0;
            while (resultSet.next()) {
                customer[i] = new Customer();
                customer[i].setCustomerId(resultSet.getInt("customer_id"));
                customer[i].setCustomerName(resultSet.getString("cust_name"));
                customer[i].setCity(resultSet.getString("city"));
                customer[i].setGrade(resultSet.getInt("grade"));
                customer[i].setSalesmanId(resultSet.getInt("salesman_id"));
                i++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return customer;
    }

}
