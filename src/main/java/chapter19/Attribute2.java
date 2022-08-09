package chapter19;
//設定されている全てのアプリケーション属性を表示する｡
import tool.Page;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import javax.servlet.ServletContext;//アプリケーション属性の操作に必要
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns={"/chapter19/attribute2"})
public class Attribute2 extends HttpServlet {
    public void doGet (
        HttpServletRequest request,HttpServletResponse response
    ) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        Page.header(out);

        ServletContext context=getServletContext();
        List<String> List=Collections.list(context.getAttributeNames());
        //｢getAttributeNames｣ﾒｿｯﾄﾞによりｱﾌﾟﾘｹｰｼｮﾝ属性名の一覧を取得して
        //String型のリストに代入する。
        for (String name : List) {
        //上のﾘｽﾄを拡張for文で処理し取り出した属性名に対応する値を
        //｢getAttribute｣ﾒｿｯﾄﾞで取得して出力する｡
            out.println("<p>"+name+" : ");
            out.println(context.getAttribute(name));
            out.println("</p>");
        }      
        Page.footer(out);
    }
}
