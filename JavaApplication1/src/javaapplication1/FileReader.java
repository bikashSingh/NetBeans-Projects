package javaapplication1;

import java.util.Scanner;

public class FileReader {

    private String data;
    private String records[];

    public String[] getRecords(Scanner inputStream) {
        data = inputStream.nextLine();
        //records = data.split(",");
        //String input = "1/28/09 18:00,Product1,\"13,000\",Visa,sandhya,Centennial,CO,United States,12/2/06 23:24,2/7/09 15:18,39.57917,-104.87639";
        records = data.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
        return records;
    }
}
