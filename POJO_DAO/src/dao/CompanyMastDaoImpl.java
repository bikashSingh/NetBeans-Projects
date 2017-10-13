package dao;

import java.sql.*;
import model.*;

public class CompanyMastDaoImpl implements CompanyMastDao {

    ConnectToDatabase connect = new ConnectToDatabase();
    private Connection connection = connect.getConnection();

    @Override
    public boolean insertIntoCompanyMast(CompanyMast companyMast) {
        boolean status = false;
        String query = "insert into company_mast values(?,?)";
        PreparedStatement st;
        try {
            st = connection.prepareStatement(query);
            st.setInt(1, companyMast.getComId());
            st.setString(2, companyMast.getComName());
            st.executeUpdate();
            status = true;
            st.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return status;
    }

    @Override
    public boolean updateCompanyMast(CompanyMast companyMast) {
        boolean status = false;
        String query = "update company_mast set com_name=? where com_id=?";
        PreparedStatement st;
        try {
            st = connection.prepareStatement(query);
            st.setString(1, companyMast.getComName());
            st.setInt(2, companyMast.getComId());
            st.executeUpdate();
            status = true;
            st.close();

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return status;
    }

    @Override
    public boolean deleteCompanyMast(CompanyMast companyMast) {
        boolean status = false;
        String query = "delete from company_mast where com_id=?";
        PreparedStatement st;
        try {
            st = connection.prepareStatement(query);
            st.setInt(1, companyMast.getComId());
            st.executeUpdate();
            status = true;
            st.close();

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return status;
    }

    @Override
    public CompanyMast[] listCompanyMast() {
        CompanyMast[] companyMast = new CompanyMast[10];
        String query = "select * from company_mast";
        try {
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(query);
            int i = 0;
            while (resultSet.next()) {
                companyMast[i] = new CompanyMast();
                companyMast[i].setComId(resultSet.getInt("com_id"));
                companyMast[i].setComName(resultSet.getString("com_name"));
                i++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return companyMast;

    }

    @Override
    public CompanyMast getCompanyMast(int comId) {
        CompanyMast companyMast = new CompanyMast();
        String query = "select * from company_mast where com_id = " + comId;
        try {
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(query);
            resultSet.next();
            companyMast.setComId(comId);
            companyMast.setComName(resultSet.getString("com_name"));
        } catch (Exception e) {
            System.out.println(e);
        }
        return companyMast;
    }

    @Override
    public CompanyMast[] findCompanyMast(String comName) {
        CompanyMast[] companyMast = new CompanyMast[10];
        String query = "select * from company_mast where com_name="+comName;
        try {
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(query);
            int i = 0;
            while (resultSet.next()) {
                companyMast[i] = new CompanyMast();
                companyMast[i].setComId(resultSet.getInt("com_id"));
                companyMast[i].setComName(resultSet.getString("com_name"));
                i++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return companyMast;

    }
}
