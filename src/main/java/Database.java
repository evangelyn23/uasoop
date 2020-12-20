import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {
    private Connection db;

    public Database()throws ClassNotFoundException, SQLException {
        //load JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        //establish connection to mysql
        String url="jdbc:mysql://localhost:3306/uas?autoReconnect=true&useSSL=false";
        String user="root";
        String pass="";
        db= DriverManager.getConnection(url,user,pass);

    }

    public boolean isconnected(){
        return(db!= null);
    }

    public void insert (String text, String text1, String Pilihan, String text2, String Pengantaran,
                        String Pembayaran, String Total) throws SQLException {
        String sql = "INSERT INTO uastabel(Nama, Alamat, Pilihan, Quantity, Pengantaran, Pembayaran, Total) VALUES (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement state = db.prepareStatement(sql);
        state.setString(1, text);
        state.setString(2, text1);
        state.setString(3, Pilihan);
        state.setString(4, text2);
        state.setString(5, Pengantaran);
        state.setString(6, Pembayaran);
        state.setString(7, Total);

        state.execute();
    }
}
