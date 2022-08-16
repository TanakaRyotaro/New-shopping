package filter;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;//ｺﾝﾃｷｽﾄの初期化ﾊﾟﾗﾒｰﾀｰを取得
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns={"/chapter19/param-context"})
public class ParamContext extends HttpServlet {

    public void doGet (
        HttpServletRequest request, HttpServletResponse response
    ) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        ServletContext context=getServletContext();
        //｢getServletContext｣ﾒｿｯﾄﾞにより｢ServletContext｣ｵﾌﾞｼﾞｪｸﾄを取得
        out.println(context.getInitParameter("message"));
        //｢getInitParameter｣ﾒｿｯﾄﾞで初期化ﾊﾟﾗﾒｰﾀｰを取得して出力
    }
}