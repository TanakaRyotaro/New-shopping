package shopping;

import bean.Product;
import dao.ProductDAO;
import tool.Action;
import javax.servlet.http.*;
import java.util.List;

public class ProductAction extends Action {
    public String execute(
        HttpServletRequest request,HttpServletResponse response
    ) throws Exception {

        HttpSession session=request.getSession();

        String keyword=request.getParameter("keyword");
        if (keyword==null) keyword="";
        //ﾘｸｴｽﾄﾊﾟﾗﾒｰﾀから検索ｷｰﾜｰﾄﾞを取得｡ﾘｸｴｽﾄﾊﾟﾗﾒｰﾀが指定されていない場合
        //getParameterﾒｿｯﾄﾞはnullを返す
        //nullの場合､検索ｷｰﾜｰﾄﾞを空文字列("")とし､全ての商品を検索

        ProductDAO dao=new ProductDAO();
        List<Product> list=dao.search(keyword);
        //検索の実行｡

        session.setAttribute("list",list);
        //商品ﾘｽﾄをｾｯｼｮﾝ属性に設定する｡属性名はlistです｡

        return "product.jsp";
    }
}