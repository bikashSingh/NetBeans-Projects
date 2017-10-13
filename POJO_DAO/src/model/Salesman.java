package model;

public class Salesman {

    private int salesmanId;
    private String name;
    private String city;
    private double commission;

    public void setSalesmanId(int salesmanId) {
        this.salesmanId = salesmanId;
    }

    public int getSalesmanId() {
        return this.salesmanId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return this.city;
    }

    public void setCommission(Double commission) {
        this.commission = commission;
    }

    public Double getCommission() {
        return this.commission;
    }
}
