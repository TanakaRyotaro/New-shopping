package chapter19;

import tool.Page;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;//アプリケーション属性の操作に必要
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns={"/chapter19/attribute"})
public class Attribute extends HttpServlet {
    public void doGet (
        HttpServletRequest rrquest,HttpServletResponse response
    ) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        Page.header(out);

        ServletContext context=getServletContext();
        String path=context.getRealPath("WEB-INF/setting.txt");
        FileInputStream in=new FileInputStream(path);
        Properties p = new Properties();
        p.load(in);//設定ﾌｧｲﾙの読み込み
        in.close();

        for (String name : p.stringPropertyNames()) {
            context.setAttribute(name, p.getProperty(name));
//設定ﾌｧｲﾙから名前と値の組を1つ1つ取り出して､setAttributeﾒｿｯﾄﾞで属性に設定
        }
        out.println("アプリケーション属性を設定しました。");
        Page.footer(out);
    }
}
