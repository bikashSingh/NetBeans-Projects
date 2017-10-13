package model;

public class EmpDepartment {

    private int dptCode;
    private String dptName;
    private int dptAllotment;

    public void setDptCode(int dptCode) {
        this.dptCode = dptCode;
    }

    public int getDptCode() {
        return this.dptCode;
    }

    public void setDptName(String dptName) {
        this.dptName = dptName;
    }

    public String getDptName() {
        return this.dptName;
    }

    public void setDptAllotment(int dptAllotment) {
        this.dptAllotment = dptAllotment;
    }

    public int getDptAllotment() {
        return this.dptAllotment;
    }

}
