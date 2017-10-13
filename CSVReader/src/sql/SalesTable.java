
package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Record;

public class SalesTable {

    private static String INSERT_QUERY = "insert into"
            + " salesjan(Transaction_date,Product,Price,Payment_Type,Name,City,State,Country,Account_Created,Last_Login,Latitude,Longitude)"
            + " values(?,?,?,?,?,?,?,?,?,?,?,?)";

    private Connection connection;

    public SalesTable(Connection connection) {
        this.connection = connection;
    }

    public void insertRecord(Record record) throws SQLException {

        PreparedStatement st = connection.prepareStatement(INSERT_QUERY);
        st.setString(1, record.getTransactionDate());
        st.setString(2, record.getProduct());
        st.setInt(3, (int) record.getPrice());
        st.setString(4, record.getPaymentType());
        st.setString(5, record.getName());
        st.setString(6, record.getCity());
        st.setString(7, record.getState());
        st.setString(8, record.getCountry());
        st.setString(9, record.getAccountCreated());
        st.setString(10, record.getLastLogin());
        st.setDouble(11, record.getLatitude());
        st.setDouble(12, record.getLongitude());

        st.executeUpdate();

        st.close();
    }
}
