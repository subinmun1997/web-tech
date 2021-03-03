package ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/first/test") // 정확히 이름까지 일치하는 URL 패턴
public class TestServlet1 extends HttpServlet {
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String context = request.getContextPath(); // 컨텍스트 이름
		String url = request.getRequestURI().toString(); // 전체 URL
		String mapping = request.getServletPath(); // 서블릿 매핑 이름
		String uri = request.getRequestURI(); // URI
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Test Serlvet1</title>");
		out.println("</head>");
		out.println("<body bgcolor='green'>");
		out.println("<b>TestServlet1입니다.</b><br>");
		out.println("<b>컨텍스트 이름 : " + context+ "</b><br>");
		out.println("<b>전체 경로 : " + url +"<b><br>");
		out.println("<매핑 이름 : " + mapping + "<b><br>");
		out.println("<b>URI : " + uri + "<b>");
		out.println("</body>");
		out.println("</html>");
		out.close();
		
	}

}
