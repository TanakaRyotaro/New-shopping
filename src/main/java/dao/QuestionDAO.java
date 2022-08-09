package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionDAO {
    public static void main(String[] args) {
        String url="jdbc:h2:tcp://localhost/~/book"; 
        String user="tana";    
        String password="Spta0808";
        Connection con=null;
        PreparedStatement pt=null;
        ResultSet rs=null;
        String sql="SELECT * FROM qanda LEFT OUTER JOIN quizdetail ON qanda.quizid = quizdetail.quizid WHERE qanda.genre=? ORDER BY qanda.orderno;";   

        try {
            con=DriverManager.getConnection(url, user, password);
            pt=con.prepareStatement(sql);
            rs=pt.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("quizid"));
                System.out.println(rs.getString("issue"));
                System.out.println(rs.getString("note1"));
                System.out.println(rs.getString("note2"));
                System.out.println(rs.getString("note3"));
                System.out.println(rs.getString("note4"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
 
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (pt != null) {
                pt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
}