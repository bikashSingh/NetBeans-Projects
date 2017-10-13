package JSONfile;

import java.io.File;
import javaapplication1.*;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import java.io.FileWriter;
import java.util.Scanner;

public class JSONfileUsingCSV {

    private static final String fileName = "SalesJan2009.csv";
    private static String a[];

    public void createJSONfileUsingCSV() throws Exception {
        FileReader fileReader = new FileReader();
        File file = new File(fileName);
        JSONArray jsonArray = new JSONArray();
        Scanner inputStream = new Scanner(file);
        inputStream.nextLine();
        try (FileWriter fileWriter = new FileWriter("test.json")) {
            while (inputStream.hasNextLine()) {
                a = fileReader.getRecords(inputStream);
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("Transaction_date", a[0]);
                jsonObject.put("Product", a[1]);
                jsonObject.put("Price", new Integer(a[2]));
                jsonObject.put("Payment_Type", a[3]);
                jsonObject.put("Name", a[4]);
                jsonObject.put("City", a[5]);
                jsonObject.put("State", a[6]);
                jsonObject.put("Country", a[7]);
                jsonObject.put("Account_Created", a[8]);
                jsonObject.put("Last_Login", a[9]);
                jsonObject.put("Latitude", new Double(a[10]));
                jsonObject.put("Longitude", new Double(a[11]));
                jsonArray.add(jsonObject);
            }
            fileWriter.write(jsonArray.toJSONString());
            fileWriter.flush();
            fileWriter.close();
            System.out.println("File created\n");
        } catch (Exception e) {
            System.out.print(e);
        }
        inputStream.close();
//        System.out.println(jsonObject);
    }
}
