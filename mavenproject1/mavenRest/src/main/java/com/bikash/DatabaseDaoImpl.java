package com.bikash;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseDaoImpl implements DatabaseDao {

    FormatString formatString = new FormatString();
    StringDateToStringTimestamp stringDateToStringTimestamp = new StringDateToStringTimestamp();
    ConnectToDatabase connect = new ConnectToDatabase();
    private final Connection connection = connect.getConnection();

    @Override
    public boolean insertIntoDatabase(DatabasePOJO databasePOJO) {
        boolean status = false;
        String query = "insert into salesjan(Transaction_date,Product,Price,Payment_Type,Name,City,State,Country,Account_Created,Last_Login,Latitude,Longitude) values(?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement st;
        try {
            st = connection.prepareStatement(query);
            st.setString(1, databasePOJO.getTransactionDate());
            st.setString(2, databasePOJO.getProduct());
            st.setInt(3, (int)databasePOJO.getPrice());
            st.setString(4, databasePOJO.getPaymentType());
            st.setString(5, databasePOJO.getName());
            st.setString(6, databasePOJO.getCity());
            st.setString(7, databasePOJO.getState());
            st.setString(8, databasePOJO.getCountry());
            st.setString(9, databasePOJO.getAccountCreated());
            st.setString(10, databasePOJO.getLastLogin());
            st.setDouble(11, databasePOJO.getLatitude());
            st.setDouble(12, databasePOJO.getLongitude());
        
            st.executeUpdate();
            status = true;
            st.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return status;
    }

    @Override
    public boolean updateDatabase(DatabasePOJO databasePOJO) {
        boolean status = false;
        String query = "update salesjan set name=? where name=?";
        PreparedStatement st;
        try {
            st = connection.prepareStatement(query);
            st.setString(1, "Bks");
            st.setString(2, databasePOJO.getName());
            st.executeUpdate();
            status = true;
            st.close();

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return status;
    }

    @Override
    public boolean deleteDatabase(String name) {
        boolean status = false;
        String query = "delete from salesjan where name=?";
        PreparedStatement st;
        try {
            st = connection.prepareStatement(query);
            st.setString(1, name);
            st.executeUpdate();
            status = true;
            st.close();

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return status;
    }

    @Override
    public List<DatabasePOJO> listDatabase() {
        String query = "select * from salesjan";
        List<DatabasePOJO> list = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(query);

            while (resultSet.next()) {
                DatabasePOJO db = new DatabasePOJO();
                db.setTransactionDate(resultSet.getString("Transaction_date"));
                db.setProduct(resultSet.getString("Product"));
                db.setPrice(resultSet.getInt("Price"));
                db.setPaymentType(resultSet.getString("Payment_Type"));
                db.setName(resultSet.getString("Name"));
                db.setCity(resultSet.getString("City"));
                db.setState(resultSet.getString("State"));
                db.setCountry(resultSet.getString("Country"));
                db.setAccountCreated(resultSet.getString("Account_Created"));
                db.setLastLogin(resultSet.getString("Last_Login"));
                db.setLatitude(resultSet.getDouble("Latitude"));
                db.setLongitude(resultSet.getDouble("Longitude"));
                list.add(db);

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;

    }

    @Override
    public DatabasePOJO getDatabase(String name) {
        DatabasePOJO databasePOJO = new DatabasePOJO();
        String query = "select * from salesjan where name=?";
        PreparedStatement st;
        try {
            st = connection.prepareStatement(query);
            st.setString(1, name);
            ResultSet resultSet = st.executeQuery();
            resultSet.next();
            databasePOJO.setTransactionDate(resultSet.getString("Transaction_date"));
            databasePOJO.setProduct(resultSet.getString("Product"));
            databasePOJO.setPrice(resultSet.getInt("Price"));
            databasePOJO.setPaymentType(resultSet.getString("Payment_Type"));
            databasePOJO.setName(resultSet.getString("Name"));
            databasePOJO.setCity(resultSet.getString("City"));
            databasePOJO.setState(resultSet.getString("State"));
            databasePOJO.setCountry(resultSet.getString("Country"));
            databasePOJO.setAccountCreated(resultSet.getString("Account_Created"));
            databasePOJO.setLastLogin(resultSet.getString("Last_Login"));
            databasePOJO.setLatitude(resultSet.getDouble("Latitude"));
            databasePOJO.setLongitude(resultSet.getDouble("Longitude"));

            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return databasePOJO;
    }
}
