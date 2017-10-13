package dao;

import model.Orders;

public interface OrdersDao {

    boolean insertIntoOrders(Orders orders);

    boolean updateOrders(Orders orders);

    boolean deleteOrders(Orders orders);

    Orders[] listOrders();

    Orders getOrders(int orderNo);

    Orders[] findOrders(String orderDate);
}
