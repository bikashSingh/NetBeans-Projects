package model;

public class Orders {

    private int ordNo;
    private double purchAmt;
    private String ordDate;
    private int customerId;
    private int salesmanId;

    public void setOrdNo(int ordNo) {
        this.ordNo = ordNo;
    }

    public int getOrdNo() {
        return this.ordNo;
    }

    public void setPurchAmt(Double purchAmt) {
        this.purchAmt = purchAmt;
    }

    public Double getPurchAmt() {
        return this.purchAmt;
    }

    public void setOrdDate(String ordDate) {
        this.ordDate = ordDate;
    }

    public String getOrdDate() {
        return this.ordDate;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getCustomerId() {
        return this.customerId;
    }

    public void setSalesmanId(int salesmanId) {
        this.salesmanId = salesmanId;
    }

    public int getSalesmanId() {
        return this.salesmanId;
    }
}
