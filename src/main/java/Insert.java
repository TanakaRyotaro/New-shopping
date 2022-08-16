import tool.Page;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Connection;

@WebServlet(urlPatterns={"/insert"})
public class Insert extends HttpServlet {
    public void doPost (
        HttpServletRequest request, HttpServletResponse response
    ) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        Page.header(out);
        try {
            InitialContext ic=new InitialContext();
            DataSource ds=(DataSource)ic.lookup(
                "java:/comp/env/jdbc/book");
            Connection con=ds.getConnection();

            String login=request.getParameter("login");
            String password=request.getParameter("password");
            PreparedStatement st=con.prepareStatement(
            "insert into customer values(null,?,?)");
            st.setString(1, login);
            st.setString(2, password);
            int line=st.executeUpdate();
            if (line>0) {
            request.getRequestDispatcher("user.jsp").forward(request, response);
            }
            st.close();
            con.close();
            
        } catch (Exception e) {
            e.printStackTrace(out);
        }
        Page.footer(out);
    }
}