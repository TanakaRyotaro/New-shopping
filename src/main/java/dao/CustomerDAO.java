package dao;

import bean.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerDAO extends DAO {
    public Customer search(String login, String password)
    //customerﾃｰﾌﾞﾙから顧客を検索するためのsearchﾒｿｯﾄﾞのみを定義
        throws Exception {
            Customer customer=null;

            Connection con=getConnection();

            PreparedStatement st;
            st=con.prepareStatement(
        "select * from customer where login=? and password=?"
            );
            st.setString(1, login);
            st.setString(2, password);
            ResultSet rs=st.executeQuery();
    //実行しているSQLの?の部分には引数として､ﾛｸﾞｲﾝ名とﾊﾟｽﾜｰﾄﾞを入力

            while (rs.next()) {
                customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setLogin(rs.getString("login"));
                customer.setPassword(rs.getString("password"));
            }
    //検索結果を顧客Bean(Customerｵﾌﾞｼﾞｪｸﾄ)に保存

            st.close();
            con.close();
            return customer;
        }
}