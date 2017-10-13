package JSONfile;

import java.util.Scanner;

public class JSONfileCreation {

    public static void main(String args[]) throws Exception {
        Scanner inputStream = new Scanner(System.in);
        System.out.print("JSON File Creation\n");
        
        System.out.println("Type 1 for JSON file creation using CSV file\nType 2 for JSON file creation using Database\n");
        int option = inputStream.nextInt();
        switch (option) {
            case 1:
                JSONfileUsingCSV jsonCSV = new JSONfileUsingCSV();
                jsonCSV.createJSONfileUsingCSV();
                break;
            case 2:
                JSONfileUsingDatabase jsonDB = new JSONfileUsingDatabase();
                jsonDB.createJSONfileUsingDatabase();
                break;
            default:
                System.out.print("Wrong choice.Try again");
        }
    }

}
