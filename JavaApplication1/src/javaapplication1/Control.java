package javaapplication1;

import java.io.*;
import java.sql.Connection;
import java.util.Scanner;

public class Control {

    private static final String fileName = "SalesJan2009.csv";
    private static String a[];

    public static void main(String args[]) throws Exception {
        ConnectToDatabase connectToDatabase = new ConnectToDatabase();
        Connection connection = connectToDatabase.getConnection();

        SalesTable salesTable = new SalesTable();
        FileReader fileReader = new FileReader();

        File file = new File(fileName);
        Scanner inputStream = new Scanner(file);
        inputStream.nextLine();
        while (inputStream.hasNextLine()) {
            a = fileReader.getRecords(inputStream);
            salesTable.insertRecords(connection, a);
        }

        inputStream.close();
        connection.close();
    }
}
