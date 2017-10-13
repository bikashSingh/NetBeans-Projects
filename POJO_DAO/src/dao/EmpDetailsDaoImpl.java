package dao;

import java.sql.*;
import model.EmpDetails;

public class EmpDetailsDaoImpl implements EmpDetailsDao {

    ConnectToDatabase connect = new ConnectToDatabase();
    private final Connection connection = connect.getConnection();

    @Override
    public boolean insertIntoEmpDetails(EmpDetails empDetails) {
        boolean status = false;
        String query = "insert into emp_details values(?,?,?,?)";
        PreparedStatement st;
        try {
            st = connection.prepareStatement(query);
            st.setInt(1, empDetails.getEmpIdNo());
            st.setString(2, empDetails.getEmpFName());
            st.setString(3, empDetails.getEmpLName());
            st.setInt(3, empDetails.getEmpDept());
            st.executeUpdate();
            status = true;
            st.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return status;
    }

    @Override
    public boolean updateEmpDetails(EmpDetails empDetails) {
        boolean status = false;
        String query = "update emp_details set emp_fname=?,emp_lname=?,emp_dept=? where emp_idno=?";
        PreparedStatement st;
        try {
            st = connection.prepareStatement(query);
            st.setString(1, empDetails.getEmpFName());
            st.setString(2, empDetails.getEmpLName());
            st.setInt(3, empDetails.getEmpDept());
            st.setInt(4, empDetails.getEmpIdNo());
            st.executeUpdate();
            status = true;
            st.close();

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return status;
    }

    @Override
    public boolean deleteEmpDetails(EmpDetails empDetails) {
        boolean status = false;
        String query = "delete from emp_details where emp_idno=?";
        PreparedStatement st;
        try {
            st = connection.prepareStatement(query);
            st.setInt(1, empDetails.getEmpIdNo());
            st.executeUpdate();
            status = true;
            st.close();

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return status;
    }

    @Override
    public EmpDetails[] listEmpDetails() {
        EmpDetails[] empDetails = new EmpDetails[10];
        String query = "select * from emp_details";
        try {
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(query);
            int i = 0;
            while (resultSet.next()) {
                empDetails[i] = new EmpDetails();
                empDetails[i].setEmpIdNo(resultSet.getInt("emp_idno"));
                empDetails[i].setEmpFName(resultSet.getString("emp_fname"));
                empDetails[i].setEmpLName(resultSet.getString("emp_lname"));
                empDetails[i].setEmpDept(resultSet.getInt("emp_dept"));
                i++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return empDetails;
    }

    @Override
    public EmpDetails getEmpDetails(int empIdNo) {
        EmpDetails empDetails = new EmpDetails();
        String query = "select * from emp_details where emp_idno = " + empIdNo;
        try {
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(query);
            resultSet.next();
            empDetails.setEmpIdNo(empIdNo);
            empDetails.setEmpFName(resultSet.getString("emp_fname"));
            empDetails.setEmpLName(resultSet.getString("emp_lname"));
            empDetails.setEmpDept(resultSet.getInt("emp_dept"));

        } catch (Exception e) {
            System.out.println(e);
        }
        return empDetails;
    }

    @Override
    public EmpDetails[] findEmpDetails(String empfName) {
        EmpDetails[] empDetails = new EmpDetails[10];
        String query = "select * from emp_details where emp_fname=" + empfName;
        try {
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(query);
            int i = 0;
            while (resultSet.next()) {
                empDetails[i] = new EmpDetails();
                empDetails[i].setEmpIdNo(resultSet.getInt("emp_idno"));
                empDetails[i].setEmpFName(resultSet.getString("emp_fname"));
                empDetails[i].setEmpLName(resultSet.getString("emp_lname"));   
                empDetails[i].setEmpDept(resultSet.getInt("emp_dept")); 
                i++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return empDetails;
    }

}
