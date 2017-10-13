/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csvreader;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Record;

/**
 *
 * @author bikashs
 */
public class Reader {

    private List<Record> records;

    public void read(String fileName) throws FileNotFoundException, ParseException {
        File file = new File(fileName);
        Scanner inputStream = new Scanner(file);
        inputStream.nextLine();
        
        records = new ArrayList<>();
        while (inputStream.hasNextLine()) {
            String data = inputStream.nextLine();
            String[] fields = data.split(",");
            
            Record newRecord = new Record();
            
            newRecord.setTransactionDate(fields[0]);
            newRecord.setProduct(fields[1]);
            newRecord.setPrice(Double.parseDouble(fields[2]));
            newRecord.setPaymentType(fields[3]);
            newRecord.setName(fields[4]);
            newRecord.setCity(fields[5]);
            newRecord.setState(fields[6]);
            newRecord.setCountry(fields[7]);
            newRecord.setAccountCreated(fields[8]);
            newRecord.setLastLogin(fields[9]);
            newRecord.setLatitude(Double.parseDouble(fields[10]));
            newRecord.setLongitude(Double.parseDouble(fields[11]));
            
            records.add(newRecord);
        }
    }

    public List<Record> getRecords() {
        return records;
    }
}
