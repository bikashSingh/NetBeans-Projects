package JSONfile;

import javaapplication1.*;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import java.io.*;
import java.sql.*;

public class JSONfileUsingDatabase {

    public void createJSONfileUsingDatabase()throws Exception {
        DatabaseReader databaseReader = new DatabaseReader();
        ConnectToDatabase connectToDatabase = new ConnectToDatabase();
        Connection connection = connectToDatabase.getConnection();
        ResultSet resultSet = databaseReader.fetchRecordsFromDB(connection);
//        System.out.println(resultSet.getString("Transaction_date"));
        JSONArray jsonArray = new JSONArray();
        try (FileWriter fileWriter = new FileWriter("test.json")) {
            while (resultSet.next()) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("Transaction_date", resultSet.getString("Transaction_date"));
                jsonObject.put("Product", resultSet.getString("Product"));
                jsonObject.put("Price", resultSet.getInt("Price"));
                jsonObject.put("Payment_Type", resultSet.getString("Payment_Type"));
                jsonObject.put("Name", resultSet.getString("Name"));
                jsonObject.put("City", resultSet.getString("City"));
                jsonObject.put("State", resultSet.getString("State"));
                jsonObject.put("Country", resultSet.getString("Country"));
                jsonObject.put("Account_Created", resultSet.getString("Account_Created"));
                jsonObject.put("Last_Login", resultSet.getString("Last_Login"));
                jsonObject.put("Latitude", resultSet.getDouble("Latitude"));
                jsonObject.put("Longitude", resultSet.getDouble("Longitude"));
                jsonArray.add(jsonObject);
            }
            fileWriter.write(jsonArray.toJSONString());
            fileWriter.flush();
            fileWriter.close();
            System.out.println("File created\n");
        } catch (Exception e) {
            System.out.print(e);
        }

//        System.out.println(jsonObject);
    }
}

class DatabaseReader {

    ResultSet fetchRecordsFromDB(Connection con) throws Exception {
        String query = "select * from salesjan";
        Statement st = con.createStatement();
        ResultSet resultSet = st.executeQuery(query);
        return resultSet;

    }
}
