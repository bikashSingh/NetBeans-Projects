package dao;

import java.sql.*;
import model.EmpDepartment;

public class EmpDepartmentDaoImpl implements EmpDepartmentDao {

    ConnectToDatabase connect = new ConnectToDatabase();
    private final Connection connection = connect.getConnection();

    @Override
    public boolean insertIntoEmpDepartment(EmpDepartment empDepartment) {
        boolean status = false;
        String query = "insert into emp_department values(?,?,?)";
        PreparedStatement st;
        try {
            st = connection.prepareStatement(query);
            st.setInt(1, empDepartment.getDptCode());
            st.setString(2, empDepartment.getDptName());
            st.setInt(3, empDepartment.getDptAllotment());
            st.executeUpdate();
            status = true;
            st.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return status;
    }

    @Override
    public boolean updateEmpDepartment(EmpDepartment empDepartment) {
        boolean status = false;
        String query = "update emp_department set dpt_name=?,dpt_allotment=? where dpt_code=?";
        PreparedStatement st;
        try {
            st = connection.prepareStatement(query);
            st.setString(1, empDepartment.getDptName());
            st.setInt(2, empDepartment.getDptAllotment());
            st.setInt(3, empDepartment.getDptCode());
            st.executeUpdate();
            status = true;
            st.close();

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return status;
    }

    @Override
    public boolean deleteEmpDepartment(EmpDepartment empDepartment) {
        boolean status = false;
        String query = "delete from emp_department where dpt_code=?";
        PreparedStatement st;
        try {
            st = connection.prepareStatement(query);
            st.setInt(1, empDepartment.getDptCode());
            st.executeUpdate();
            status = true;
            st.close();

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return status;
    }

    @Override
    public EmpDepartment[] listEmpDepartment() {
         EmpDepartment[] empDepartment = new EmpDepartment[10];
        String query = "select * from emp_department";
        try {
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(query);
            int i = 0;
            while (resultSet.next()) {
                empDepartment[i] = new EmpDepartment();
                empDepartment[i].setDptCode(resultSet.getInt("dpt_code"));
                empDepartment[i].setDptName(resultSet.getString("dpt_name"));
                empDepartment[i].setDptAllotment(resultSet.getInt("dpt_allotment"));
                i++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return empDepartment;
    }

    @Override
    public EmpDepartment getEmpDepartment(int dptCode) {
        EmpDepartment empDepartment = new EmpDepartment();
        String query = "select * from emp_department where dpt_code = " + dptCode;
        try {
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(query);
            resultSet.next();
            empDepartment.setDptCode(dptCode);
            empDepartment.setDptName(resultSet.getString("dpt_name"));
            empDepartment.setDptAllotment(resultSet.getInt("dpt_allotment"));

        } catch (Exception e) {
            System.out.println(e);
        }
        return empDepartment;
    }

    @Override
    public EmpDepartment[] findEmpDepartment(String dptName) {
        EmpDepartment[] empDepartment = new EmpDepartment[10];
        String query = "select * from emp_department where dpt_name=" + dptName;
        try {
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(query);
            int i = 0;
            while (resultSet.next()) {
                empDepartment[i] = new EmpDepartment();
                empDepartment[i].setDptCode(resultSet.getInt("dpt_code"));
                empDepartment[i].setDptName(resultSet.getString("dpt_name"));
                empDepartment[i].setDptAllotment(resultSet.getInt("dpt_allotment"));             
                i++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return empDepartment;
    }

}
