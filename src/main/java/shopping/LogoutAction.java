package shopping;

import tool.Action;
import javax.servlet.http.*;

public class LogoutAction extends Action {
    public String execute (
        HttpServletRequest request, HttpServletResponse response
    ) throws Exception {
        HttpSession session=request.getSession();

        if (session.getAttribute("customer")!=null){
            session.removeAttribute("customer");
            return "logout-out.jsp";
//ログインしている場合の処理 セッション属性から顧客Beanが取得できた場合､
//ログインされていると判定される｡removeAttributeﾒｿｯﾄﾞを使って､ｾｯｼｮﾝ属性
//顧客Beanを削除して､｢logout-out.jsp｣をﾌｫﾜｰﾄﾞ先に指定する｡
        }
        return "logout-error.jsp";
//ログインしていない場合の処理
    }
} 