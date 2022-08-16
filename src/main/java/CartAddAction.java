

import bean.Item;
import bean.Product;
import tool.Action;
import javax.servlet.http.*;
import java.util.ArrayList;
import java.util.List;

public class CartAddAction extends Action {
    
    @SuppressWarnings("unchecked")//　➀

    public String execute(
        HttpServletRequest request, HttpServletResponse response
    ) throws Exception {

        HttpSession session=request.getSession();

        int id=Integer.parseInt(request.getParameter("id"));// ➁

        List<Item> cart=(List<Item>)session.getAttribute("cart");// ➂

        if (cart==null) {
            cart=new ArrayList<Item>();// ➃
            session.setAttribute("cart", cart);
        }
        for (Item i : cart) {// ➄
            if (i.getProduct().getId()==id) {
                i.setCount(i.getCount()+1);
                return "cart.jsp";
            }
        }

        List<Product> list=(List<Product>)session.getAttribute("list");// ➅

        for (Product p : list) {// ➆
            if (p.getId()==id) {
                Item i = new Item();
                i.setProduct(p);
                i.setCount(1);
                cart.add(i);
            }
        }
        return "cart.jsp";
    }
}