package model;

public class EmpDetails {

    private int empIdNo;
    private String empFName;
    private String empLName;
    private int empDept;

    public void setEmpIdNo(int empIdNo) {
        this.empIdNo = empIdNo;
    }

    public int getEmpIdNo() {
        return this.empIdNo;
    }

    public void setEmpFName(String empFName) {
        this.empFName = empFName;
    }

    public String getEmpFName() {
        return this.empFName;
    }

    public void setEmpLName(String empLName) {
        this.empLName = empLName;
    }

    public String getEmpLName() {
        return this.empLName;
    }

    public void setEmpDept(int empDept) {
        this.empDept = empDept;
    }

    public int getEmpDept() {
        return this.empDept;
    }

}
