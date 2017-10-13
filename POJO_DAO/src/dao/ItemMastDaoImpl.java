package dao;

import java.sql.*;
import model.ItemMast;

public class ItemMastDaoImpl implements ItemMastDao {

    ConnectToDatabase connect = new ConnectToDatabase();
    private final Connection connection = connect.getConnection();

    @Override
    public boolean insertIntoItemMast(ItemMast itemMast) {
        boolean status = false;
        String query = "insert into item_mast values(?,?,?,?)";
        PreparedStatement st;
        try {
            st = connection.prepareStatement(query);
            st.setInt(1, itemMast.getProId());
            st.setString(2, itemMast.getProName());
            st.setInt(3, itemMast.getProPrice());
            st.setInt(4, itemMast.getProCom());
            st.executeUpdate();
            status = true;
            st.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return status;
    }

    @Override
    public boolean updateItemMast(ItemMast itemMast) {
        boolean status = false;
        String query = "update item_mast set pro_name=?,pro_price=?,pro_com=? where pro_id=?";
        PreparedStatement st;
        try {
            st = connection.prepareStatement(query);
            st.setString(1, itemMast.getProName());
            st.setInt(2, itemMast.getProPrice());
            st.setInt(3, itemMast.getProCom());
            st.setInt(4, itemMast.getProId());
            st.executeUpdate();
            status = true;
            st.close();

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return status;
    }

    @Override
    public boolean deleteItemMast(ItemMast itemMast) {
        boolean status = false;
        String query = "delete from item_mast where pro_id=?";
        PreparedStatement st;
        try {
            st = connection.prepareStatement(query);
            st.setInt(1, itemMast.getProId());
            st.executeUpdate();
            status = true;
            st.close();

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return status;
    }

    @Override
    public ItemMast[] listItemMast() {
        ItemMast[] itemMast = new ItemMast[10];
        String query = "select * from item_mast";
        try {
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(query);
            int i = 0;
            while (resultSet.next()) {
                itemMast[i] = new ItemMast();
                itemMast[i].setProId(resultSet.getInt("pro_id"));
                itemMast[i].setProName(resultSet.getString("pro_name"));
                itemMast[i].setProPrice(resultSet.getInt("pro_price"));
                itemMast[i].setProCom(resultSet.getInt("pro_com"));
                i++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return itemMast;
    }

    @Override
    public ItemMast getItemMast(int proId) {
        ItemMast itemMast = new ItemMast();
        String query = "select * from emp_department where dpt_code = " + proId;
        try {
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(query);
            resultSet.next();
            itemMast.setProId(proId);
            itemMast.setProName(resultSet.getString("pro_name"));
            itemMast.setProPrice(resultSet.getInt("pro_price"));
            itemMast.setProCom(resultSet.getInt("pro_com"));

        } catch (Exception e) {
            System.out.println(e);
        }
        return itemMast;
    }

    @Override
    public ItemMast[] findItemMast(String proName) {
        ItemMast[] itemMast = new ItemMast[10];
        String query = "select * from item_mast where pro_name=" + proName;
        try {
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(query);
            int i = 0;
            while (resultSet.next()) {
                itemMast[i] = new ItemMast();
                itemMast[i].setProId(resultSet.getInt("pro_id"));
                itemMast[i].setProName(resultSet.getString("pro_name"));
                itemMast[i].setProPrice(resultSet.getInt("pro_price"));
                itemMast[i].setProCom(resultSet.getInt("pro_com"));
                i++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return itemMast;
    }

}
