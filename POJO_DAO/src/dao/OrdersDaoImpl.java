package dao;

import java.sql.*;
import model.Orders;

public class OrdersDaoImpl implements OrdersDao {

    ConnectToDatabase connect = new ConnectToDatabase();
    private final Connection connection = connect.getConnection();

    @Override
    public boolean insertIntoOrders(Orders orders) {
        boolean status = false;
        String query = "insert into orders values(?,?,?,?,?)";
        PreparedStatement st;
        try {
            st = connection.prepareStatement(query);
            st.setInt(1, orders.getOrdNo());
            st.setDouble(2, orders.getPurchAmt());
            st.setString(3, orders.getOrdDate());
            st.setInt(4, orders.getCustomerId());
            st.setInt(5, orders.getSalesmanId());
            st.executeUpdate();
            status = true;
            st.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return status;
    }

    @Override
    public boolean updateOrders(Orders orders) {
        boolean status = false;
        String query = "update orders set purch_amt=?,ord_date=?,customer_id=?,salesman_id=? where ord_no=?";
        PreparedStatement st;
        try {
            st = connection.prepareStatement(query);
            st.setDouble(1, orders.getPurchAmt());
            st.setString(2, orders.getOrdDate());
            st.setInt(3, orders.getCustomerId());
            st.setInt(4, orders.getSalesmanId());
            st.setInt(5, orders.getOrdNo());

            st.executeUpdate();
            status = true;
            st.close();

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return status;

    }

    @Override
    public boolean deleteOrders(Orders orders) {
        boolean status = false;
        String query = "delete from orders where ord_no=?";
        PreparedStatement st;
        try {
            st = connection.prepareStatement(query);
            st.setInt(1, orders.getOrdNo());
            st.executeUpdate();
            status = true;
            st.close();

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return status;
    }

    @Override
    public Orders[] listOrders() {
        Orders[] orders = new Orders[10];
        String query = "select * from orders";
        try {
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(query);
            int i = 0;
            while (resultSet.next()) {
                orders[i] = new Orders();
                orders[i].setOrdNo(resultSet.getInt("ord_no"));
                orders[i].setPurchAmt(resultSet.getDouble("purch_amt"));
                orders[i].setOrdDate(resultSet.getString("ord_date"));
                orders[i].setCustomerId(resultSet.getInt("customer_id"));
                orders[i].setSalesmanId(resultSet.getInt("salesman_id"));
                i++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return orders;
    }

    @Override
    public Orders getOrders(int orderNo) {
        Orders orders = new Orders();
        String query = "select * from orders where ord_no = " + orderNo;
        try {
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(query);
            resultSet.next();
            orders.setOrdNo(orderNo);
            orders.setPurchAmt(resultSet.getDouble("purch_amt"));
            orders.setOrdDate(resultSet.getString("ord_date"));
            orders.setCustomerId(resultSet.getInt("customer_id"));
            orders.setSalesmanId(resultSet.getInt("saleman_id"));

        } catch (Exception e) {
            System.out.println(e);
        }
        return orders;
    }

    @Override
    public Orders[] findOrders(String orderDate) {
         Orders[] orders = new Orders[10];
        String query = "select * from orders where order_date=" + orderDate;
        try {
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(query);
            int i = 0;
            while (resultSet.next()) {
                orders[i] = new Orders();
                orders[i].setOrdNo(resultSet.getInt("ord_no"));
                orders[i].setPurchAmt(resultSet.getDouble("purch_amt"));
                orders[i].setOrdDate(resultSet.getString("ord_date"));    
                orders[i].setCustomerId(resultSet.getInt("customer_id"));   
                orders[i].setSalesmanId(resultSet.getInt("salesman_id"));   
                i++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return orders;
    }

}
