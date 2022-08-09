package chapter19;

import tool.Page;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns={"/chapter19/attribute3"})
public class Attribute3 extends HttpServlet {
    public void doGet (
        HttpServletRequest request,HttpServletResponse response
    ) throws ServletException,IOException {
        PrintWriter out=response.getWriter();
        Page.header(out);

        ServletContext context=getServletContext();

        String debug=(String)context.getAttribute("debug");
        if (debug.equals("yes")) {
        //属性名debugを取得し文字列Stringに変換｡値がyesならば下記を出力
                out.println("<p>デバックモードで実行します。</p>");
        }

        int memory=Integer.parseInt(
                (String)context.getAttribute("memory"));
        //属性名memoryを取得しIntegerｸﾗｽのparseIntﾒｿｯﾄﾞを使って整数(int)
        //に変換
        if (memory<1000000) {
            out.println("<p>省メモリモードで実行します。</p>");
        }
        Page.footer(out);   
    }
}