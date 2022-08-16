package tool;
import java.io.PrintWriter;

public class Page{
	
	public static void header(PrintWriter out) {
		out.println("<!DOCTYPE heml>");
		out.println("<heml>");
		out.println("<head>");
		out.println("<meta sharset='UTF-8'>");
		out.println("<title>ユーザー登録</title>");
		out.println("</head>");
		out.println("<body>");
	}
	
	public static void footer(PrintWriter out) {
		out.println("</body>");
		out.println("</heml>");
	}
}