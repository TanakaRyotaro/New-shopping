

import bean.Item;
import tool.Action;
import javax.servlet.http.*;
import java.util.List;

public class CartRemoveAction extends Action {
    @SuppressWarnings("unchecked")
    public String execute (
        HttpServletRequest request,HttpServletResponse response
    ) throws Exception {
        HttpSession session=request.getSession();

        int id=Integer.parseInt(request.getParameter("id"));
        //ﾘｸｴｽﾄﾊﾟﾗﾒｰﾀから商品番号を取得
        List<Item> cart=(List<Item>)session.getAttribute("cart");
        //ｾｯｼｮﾝ属性からｶｰﾄを取得する

        for (Item i : cart) {
            if (i.getProduct().getId()==id) {
                cart.remove(i);
                break;
//指定された商品番号の項目Beanをｶｰﾄから検索して見つかった項目Beanを削除する
//拡張for文を使って､ｶｰﾄ内の項目Beanを順に調べ指定された商品番号が見つかった
//ら､Listｲﾝﾀｰﾌｪｰｽのremoveﾒｿｯﾄﾞを使って項目Beanを削除｡break文で繰り返し終了
            }
        }
        return "cart.jsp";//ﾌｫﾜｰﾄﾞ先に指定
    }
}
