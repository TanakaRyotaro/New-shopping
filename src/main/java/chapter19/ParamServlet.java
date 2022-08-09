package chapter19;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;//ｻｰﾌﾞﾚｯﾄの初期化ﾊﾟﾗﾒｰﾀｰ取得時に使用
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ParamServlet extends HttpServlet {

    private String message;
    //initﾒｿｯﾄﾞで取得した初期化ﾊﾟﾗﾒｰﾀｰを保存する為の｢private｣ﾌｨｰﾙﾄﾞ
    public void init() throws ServletException {
    //ｻｰﾌﾞﾚｯﾄの起動時に1回だけ実行｡
        ServletConfig config=getServletConfig();
    //内部で｢getServletConfig｣ﾒｿｯﾄﾞで｢ServletConfig｣ｵﾌﾞｼﾞｪｸﾄを取得
        message = config.getInitParameter("message");
//｢getInitParameter｣ﾒｿｯﾄﾞでｻｰﾌﾞﾚｯﾄの初期化ﾊﾟﾗﾒｰﾀｰを取得して､ﾌｨｰﾙﾄﾞに保存
    }

    public void doGet (
        HttpServletRequest request,HttpServletResponse response
    ) throws ServletException,IOException {
        PrintWriter out=response.getWriter();
        out.println(message);
    //doGetﾒｿｯﾄﾞの中で､｢message｣ﾌｨｰﾙﾄﾞの内容を出力する
    }
}