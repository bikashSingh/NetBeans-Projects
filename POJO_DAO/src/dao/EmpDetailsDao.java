package dao;

import model.EmpDetails;

public interface EmpDetailsDao {

    boolean insertIntoEmpDetails(EmpDetails empDetails);

    boolean updateEmpDetails(EmpDetails empDetails);

    boolean deleteEmpDetails(EmpDetails empDetails);

    EmpDetails[] listEmpDetails();

    EmpDetails getEmpDetails(int empIdNo);

    EmpDetails[] findEmpDetails(String empFName);
}
