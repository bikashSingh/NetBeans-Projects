package dao;

import java.sql.*;
import model.Salesman;

public class SalesmanDaoImpl implements SalesmanDao {

    ConnectToDatabase connect = new ConnectToDatabase();
    private final Connection connection = connect.getConnection();

    @Override
    public boolean insertIntoSalesman(Salesman salesman) {
        boolean status = false;
        String query = "insert into salesman values(?,?,?,?)";
        PreparedStatement st;
        try {
            st = connection.prepareStatement(query);
            st.setInt(1, salesman.getSalesmanId());
            st.setString(2, salesman.getName());
            st.setString(3, salesman.getCity());
            st.setDouble(4, salesman.getCommission());
            st.executeUpdate();
            status = true;
            st.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return status;
    }

    @Override
    public boolean updateSalesman(Salesman salesman) {
        boolean status = false;
        String query = "update salesman set name=?,city=?,commission=? where salesman_id=?";
        PreparedStatement st;
        try {
            st = connection.prepareStatement(query);
            st.setString(1, salesman.getName());
            st.setString(2, salesman.getCity());
            st.setDouble(3, salesman.getCommission());
            st.setInt(4, salesman.getSalesmanId());
            st.executeUpdate();
            status = true;
            st.close();

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return status;

    }

    @Override
    public boolean deleteSalesman(Salesman salesman) {
        boolean status = false;
        String query = "delete from salesman where salesman_id=?";
        PreparedStatement st;
        try {
            st = connection.prepareStatement(query);
            st.setInt(1, salesman.getSalesmanId());
            st.executeUpdate();
            status = true;
            st.close();

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return status;
    }

    @Override
    public Salesman[] listSalesman() {
        Salesman[] salesman = new Salesman[10];
        String query = "select * from salesman";
        try {
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(query);
            int i = 0;
            while (resultSet.next()) {
                salesman[i] = new Salesman();
                salesman[i].setSalesmanId(resultSet.getInt("salesman_id"));
                salesman[i].setName(resultSet.getString("name"));
                salesman[i].setCity(resultSet.getString("city"));
                salesman[i].setCommission(resultSet.getDouble("commission"));
                i++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return salesman;

    }

    @Override
    public Salesman getSalesman(int salesmanId) {
        Salesman salesman = new Salesman();
        String query = "select * from salesman where salesman_id = " + salesmanId;
        try {
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(query);
            resultSet.next();
            salesman.setSalesmanId(salesmanId);
            salesman.setName(resultSet.getString("name"));
            salesman.setCity(resultSet.getString("city"));
            salesman.setCommission(resultSet.getDouble("commission"));

        } catch (Exception e) {
            System.out.println(e);
        }
        return salesman;

    }

    @Override
    public Salesman[] findSalesman(String name) {
        Salesman[] salesman = new Salesman[10];
        String query = "select * from salesman where name=" + name;
        try {
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(query);
            int i = 0;
            while (resultSet.next()) {
                salesman[i] = new Salesman();
                salesman[i].setSalesmanId(resultSet.getInt("salesman_id"));
                salesman[i].setName(resultSet.getString("name"));
                salesman[i].setCity(resultSet.getString("city"));
                salesman[i].setCommission(resultSet.getDouble("commission"));
                i++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return salesman;

    }

}
