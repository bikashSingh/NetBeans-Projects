import java.io.*;
import com.opencsv.CSVReader;
import java.util.Arrays;

public class NewClass {

    private static final String fileName = "C:\\Users\\bikashs\\Documents\\Maven Projects\\test2.csv";
    private static String a[];

    public static void main(String args[]) throws Exception {
//        ConnectToDatabase connectToDatabase = new ConnectToDatabase();
//        Connection connection = connectToDatabase.getConnection();
//        SalesTable salesTable = new SalesTable();
        CSVReader reader = new CSVReader(new FileReader(fileName));
//        DoubleQuotedString doubleQuotedString = new DoubleQuotedString();
        a = reader.readNext();
        while ((a = reader.readNext()) != null) {
//            for (int i = 0; i < a.length; i++) {
////                a[i] = doubleQuotedString.formatDoubleQuotedString(a[i]);
//            }
            System.out.println(a[0]);
            //salesTable.insertRecords(connection, a);
        }
//        connection.close();
    }

}
