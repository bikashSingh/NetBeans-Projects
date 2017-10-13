package com.twopirad;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import javax.jws.WebService;
import javax.jws.WebMethod;

@WebService(serviceName = "SoapWebService")
public class SoapWebService {

    Date date = new Date();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

    //TimeZone zone = TimeZone.getTimeZone("Asia/Kolkata");
    @WebMethod(operationName = "GetCurrentDateTime")
    public Date getCurrentDateTime() {
        return date;
    }

    @WebMethod(operationName = "GetDateTimeInNewYork")
    public String getDateTimeInNewYork() {
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        return simpleDateFormat.format(date);
    }

    @WebMethod(operationName = "GetDateTimeInLondon")
    public String getDateTimeInLondon() {
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Europe/London"));
        return simpleDateFormat.format(date);
    }

    @WebMethod(operationName = "GetDateTimeInSanFrancisco")
    public String getDateTimeInSanFrancisco() {
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
        return simpleDateFormat.format(date);
    }
//    @WebMethod(operationName = "AddIntegers")
//    public int add(@WebParam(name = "firstNum") int num1, @WebParam(name = "secondNum") int num2) {
//        return num1 + num2;
//    }
//
//    @WebMethod(operationName = "SubIntegers")
//    public int sub(@WebParam(name = "firstNum") int num1, @WebParam(name = "secondNum") int num2) {
//        return num1 - num2;
//    }
//
//    @WebMethod(operationName = "MulIntegers")
//    public int mul(@WebParam(name = "firstNum") int num1, @WebParam(name = "secondNum") int num2) {
//        return num1 * num2;
//    }
//
//    @WebMethod(operationName = "DivIntegers")
//    public int div(@WebParam(name = "firstNum") int num1, @WebParam(name = "secondNum") int num2) {
//        return num1 / num2;
//    }
}
