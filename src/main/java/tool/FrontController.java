package tool;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns={"*.action"})
//URLﾊﾟﾀｰﾝの指定
public class FrontController extends HttpServlet {
    public void doPost (
//POSTﾘｸｴｽﾄを処理するdoPostﾒｿｯﾄﾞ｡doGetﾒｿｯﾄﾞに呼び出される｡
        HttpServletRequest request, HttpServletResponse response
    ) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        try {
            String path=request.getServletPath().substring(1);
//ﾊﾟｽの取得｡getServletPathﾒｿｯﾄﾞを使って､ﾌﾛﾝﾄｺﾝﾄﾛｰﾗが呼び出されたﾊﾟｽを取得
            String name=path.replace(".a","A").replace('/','.');
//ﾊﾟｽを加工｡ﾊﾟｽのaをAに置換｡/を.に置換｡
            Action action=(Action)Class.forName(name).
                getDeclaredConstructor().newInstance();
//ｱｸｼｮﾝの生成｡ｱｸｼｮﾝのｸﾗｽ名を使ってｲﾝｽﾀﾝｽを作成
                String url=action.execute(request, response);
//ｱｸｼｮﾝの実行｡生成したｱｸｼｮﾝのｲﾝｽﾀﾝｽに対して､executeﾒｿｯﾄﾞを呼び出す｡
                request.getRequestDispatcher(url).
//ﾌｫﾜｰﾄﾞの実行｡上記で取得したﾌｫﾜｰﾄﾞ先のURLを指定されたﾌｫﾜｰﾄﾞ先にﾌｫﾜｰﾄﾞする

                    forward(request,response);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void doGet (
//doGetﾒｿｯﾄﾞ
        HttpServletRequest request, HttpServletResponse response
    ) throws ServletException,IOException {
        doPost(request, response);
    }
}
