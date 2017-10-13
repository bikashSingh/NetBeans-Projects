/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bikash;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
public class DatabaseReader {

    ResultSet fetchRecordsFromDB(Connection con) throws Exception {
        String query = "select * from salesjan";
        Statement st = con.createStatement();
        ResultSet resultSet = st.executeQuery(query);
        return resultSet;

    }
}



