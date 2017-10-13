package com.bikash;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class URLconnection {
    //public static void main(String ar[])throws MalformedURLException, IOException, ParseException
    public String getDate(String timeZone,long time) throws MalformedURLException, IOException, ParseException
    {
        //String timeZone = "America/New_York";
        JSONParser parser = new JSONParser();
        //Long time=1505125320L;
        URL url = new URL("http://api.timezonedb.com/v2/get-time-zone?key=PU68HOKL3MEB&format=json&by=zone&zone="+timeZone+"&time="+time);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        if(conn.getResponseCode()!=200)
        {
            throw new RuntimeException("Failed : Http Error Code: "+conn.getResponseCode());
        }
        Scanner inputStream = new Scanner(conn.getInputStream());
       // String output=null;
        System.out.println("Output from server : \n");
        Object routeObj = parser.parse(inputStream.nextLine());
        JSONObject jsonObj = (JSONObject)routeObj;
        String resDate=(String)jsonObj.get("formatted");
        //System.out.println(resDate);
        conn.disconnect();
        return resDate;
        
       
    }
}