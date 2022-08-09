package dao;

import bean.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO extends DAO {
    public User search(String name, String password)
        throws Exception {
            User user=null;
            Connection con=getConnection();
            PreparedStatement st;
            st=con.prepareStatement(
        "select * from user where name=? and password=?"
            );
            st.setString(1, name);
            st.setString(2, password);
            ResultSet rs=st.executeQuery();

            while (rs.next()) {
                user = new User();
                user.setUserid(rs.getInt("userid"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
            }
            st.close();
            con.close();
            return user;
        }
}