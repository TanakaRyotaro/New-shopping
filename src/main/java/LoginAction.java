

import bean.Customer;
import dao.CustomerDAO;
import tool.Action;
import javax.servlet.http.*;

public class LoginAction extends Action {
    public String execute(
        HttpServletRequest request, HttpServletResponse response
    ) throws Exception {
        HttpSession session=request.getSession();
        //ｾｯｼｮﾝを開始｡

        String login=request.getParameter("login");
        String password=request.getParameter("password");
        CustomerDAO dao=new CustomerDAO();
        Customer customer=dao.search(login, password);
//CustomerDAOのsearchﾒｿｯﾄﾞを使い指定したﾛｸﾞｲﾝ名･ﾊﾟｽﾜｰﾄﾞの顧客をDBから検索

        if (customer!=null) {
            session.setAttribute("customer",customer);
            return "login-out.jsp";
        }
//ﾛｸﾞｲﾝ成功時の処理 上記でﾛｸﾞｲﾝ名とﾊﾟｽﾜｰﾄﾞに合致する顧客が見つかった場合
//customerに見つかった顧客Beanが代入されているのでこれをｾｯｼｮﾝ属性に属性名
//customerで登録する｡

        return "login-error.jsp";
//ﾛｸﾞｲﾝ失敗時の処理 
    }
}
