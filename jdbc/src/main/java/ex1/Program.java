package ex1;

import java.sql.*;

public class Program {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        String url = "jdbc:oracle:thin:@192.168.219.106:1521/ORCLPDB";
        String sql = "SELECT * FROM NOTICE";

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(url, "NEWLEC", "newlec");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()){
            int id = rs.getInt("ID");
            String title = rs.getString("TITLE");
            String writerId = rs.getString("WRITER_ID");
            Date regDate = rs.getDate("REGDATE");
            String content = rs.getString("CONTENT");
            int hit = rs.getInt("HIT");

            System.out.printf("id : %d, title : %s, writerId : %s, regDate : %s, content : %s, hit : %d\n", id, title, writerId, regDate, content, hit);
        }

        rs.close();
        st.close();
        con.close();
    }
}
