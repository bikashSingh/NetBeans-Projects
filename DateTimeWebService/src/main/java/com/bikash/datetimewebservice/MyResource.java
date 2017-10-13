package com.bikash.datetimewebservice;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone; 
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/myresource")
public class MyResource {

    //Calendar calendar = Calendar.getInstance();  
    Date date = new Date();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }

    //TimeZone zone = TimeZone.getTimeZone("Asia/Kolkata");
    @GET
    @Path("/currentDateTime")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCurrentDateTime() {
        return date.toString();
    }

    @GET
    @Path("/DateTimeInNewYork")
    @Produces(MediaType.TEXT_PLAIN)
    public String getDateTimeInNewYork() {
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        return simpleDateFormat.format(date);
    }

    @GET
    @Path("/DateTimeInLondon")
    @Produces(MediaType.TEXT_PLAIN)
    public String getDateTimeInLondon() {
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Europe/London"));
        return simpleDateFormat.format(date);
    }

    @GET
    @Path("/DateTimeInSanFrancisco")
    @Produces(MediaType.TEXT_PLAIN)
    public String getDateTimeInSanFrancisco() {
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
        //calendar.setTime(date);
        return simpleDateFormat.format(date);
          //return "got the form!" + datetime;

    }
}