package model;

public class Customer {

    private int customerId;
    private String custName;
    private String city;
    private int grade;
    private int salesmanId;

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getCustomerId() {
        return this.customerId;
    }

    public void setCustomerName(String customerName) {
        this.custName = customerName;
    }

    public String getCustomerName() {
        return this.custName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return this.city;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getGrade() {
        return this.grade;
    }

    public void setSalesmanId(int salesmanId) {
        this.salesmanId = salesmanId;
    }

    public int getSalesmanId() {
        return this.salesmanId;
    }
}
