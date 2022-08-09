package chapter19;

import tool.Page;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileInputStream;//ﾌｧｲﾙを読み込むクラス
import java.util.Properties;//ﾌﾟﾛﾊﾟﾃｨを扱うクラス
import javax.servlet.ServletContext;//ｻｰﾊﾞ上の物理ﾊﾟｽを取得するクラス
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns={"/chapter19/file"})
public class File extends HttpServlet {
    public void doGet (
        HttpServletRequest request,HttpServletResponse response
    ) throws ServletException,IOException {
        PrintWriter out=response.getWriter();
        Page.header(out);

        ServletContext context=getServletContext();
        //｢getServletContext｣により｢ServletContext｣ｵﾌﾞｼﾞｪｸﾄを取得
        String path=context.getRealPath("/WEB-INF/setting.txt");
        //｢getRealPath｣ﾒｿｯﾄﾞにより設定ﾌｧｲﾙのｻｰﾊﾞ上のﾊﾟｽを取得する
        //引数~ｺﾝﾃｷｽﾄﾙｰﾄを起点とするﾊﾟｽを指定する

        FileInputStream in=new FileInputStream(path);
        //設定ﾌｧｲﾙを開く｡上記で取得したﾊﾟｽを使用して､
        //java.io.FileInputStreamｵﾌﾞｼﾞｪｸﾄを作成する。

        Properties p=new Properties();
        //Propertiesｸﾗｽ~設定ﾌｧｲﾙ内の｢名前=値｣という記述から取り出す。
        p.load(in);//Propertiesｸﾗｽのｲﾝｽﾀﾝｽを生成後､loadﾒｿｯﾄﾞを使用して
        in.close();//ﾌｧｲﾙを読み込む｡

        for (String key : p.stringPropertyNames()) {
        //Propertiesｵﾌﾞｼﾞｪｸﾄに保存された名前の一覧を取得する。
        //戻り値は名前のセットなので､拡張for文の条件に指定できる。
            out.println("<p>"+key+" : "+p.getProperty(key)+"</p>");
        }//名前と値の組を出力｡｢Properties｣ｵﾌﾞｼﾞｪｸﾄから値を取得するには
         //｢getProperty｣ﾒｿｯﾄﾞを使う｡
        Page.footer(out);
    }
} 
