/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.ParseException;
import util.DateUtil;

/**
 *
 * @author bikashs
 */
public class Record {

    private String transactionDate;
    private String product;
    private double price;
    private String paymentType;
    private String name;
    private String city;
    private String state;
    private String country;
    private String accountCreated;
    private String lastLogin;
    private double latitude;
    private double longitude;

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) throws ParseException {
        this.transactionDate = DateUtil.changeDateFormat("MM/dd/yy HH:mm", "yyyy-MM-dd HH:mm:ss", transactionDate);
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAccountCreated() {
        return accountCreated;
    }

    public void setAccountCreated(String accountCreated) throws ParseException {
        this.accountCreated = DateUtil.changeDateFormat("MM/dd/yy HH:mm", "yyyy-MM-dd HH:mm:ss", accountCreated);
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) throws ParseException {
        this.lastLogin = DateUtil.changeDateFormat("MM/dd/yy HH:mm", "yyyy-MM-dd HH:mm:ss", lastLogin);
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

}
