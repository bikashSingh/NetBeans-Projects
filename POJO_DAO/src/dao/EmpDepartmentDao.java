package dao;

import model.EmpDepartment;

public interface EmpDepartmentDao {

    boolean insertIntoEmpDepartment(EmpDepartment empDepartment);

    boolean updateEmpDepartment(EmpDepartment empDepartment);

    boolean deleteEmpDepartment(EmpDepartment empDepartment);

    EmpDepartment[] listEmpDepartment();

    EmpDepartment getEmpDepartment(int dptCode);

    EmpDepartment[] findEmpDepartment(String dptName);
}
