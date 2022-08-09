package dao;

import bean.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

public class ProductDAO extends DAO {
    
    public List<Product> search(String keyword) throws Exception {
        List<Product> list=new ArrayList<>();//Listの型はProduct型
        //Resultsetｵﾌﾞｼﾞｪｸﾄの内容をListに詰め替える。
        //Resultsetｵﾌﾞｼﾞｪｸﾄはﾃﾞｰﾀﾍﾞｰｽから切断される時に破棄されてしまう
        Connection con=getConnection();

        PreparedStatement st=con.prepareStatement(
        "select * from product where name like ?");
        st.setString(1, "%"+keyword+"%");
        ResultSet rs=st.executeQuery();

        while (rs.next()) {//検索結果であるResultsetｵﾌﾞｼﾞｪｸﾄから1行ずつ
            //取り出し、各列の値を新たに生成したProductｵﾌﾞｼﾞｪｸﾄのﾌﾟﾛﾊﾟﾃｨ
            //に、ｾｯﾀｰを使って書き込み。終わり次第、Listに格納される
            Product p=new Product();
            p.setId(rs.getInt("id"));
            p.setName(rs.getString("name"));
            p.setPrice(rs.getInt("price"));
            list.add(p);
        }
        st.close();
        con.close();

        return list;
    }

    public int insert(Product product) throws Exception {
        Connection con=getConnection();
//追加を行うinsertﾒｿｯﾄﾞ。引数に商品のBean(Productｵﾌﾞｼﾞｪｸﾄ)を指定。
//Beanに保存された情報を取得し、ﾃﾞｰﾀﾍﾞｰｽに1行を追加。戻り値はﾃﾞｰﾀﾍﾞｰｽ上で変更した行数
        PreparedStatement st=con.prepareStatement(
        "insert into product values(null, ?, ?)");
        
        st.setString(1, product.getName());
        st.setInt(2, product.getPrice());
        int line=st.executeUpdate();

        st.close();
        con.close();
        return line;//戻り値
    }

}
