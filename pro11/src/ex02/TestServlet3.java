package ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet3
 */
@WebServlet("*.do") // 확장자만 일치하는 패턴. 매핑 이름에 상관없이 확장자가 .do면 실행된다
 /*@WebServlet("/*") */  //모든 요청 URL 패턴
public class TestServlet3 extends HttpServlet {

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
		out.println("<title>Test Serlvet3</title>");
		out.println("</head>");
		out.println("<body bgcolor='red'>");
		out.println("<b>TestServlet3입니다.</b><br>");
		out.println("<b>컨텍스트 이름 : " + context+ "</b><br>");
		out.println("<b>전체 경로 : " + url +"<b><br>");
		out.println("<매핑 이름 : " + mapping + "<b><br>");
		out.println("<b>URI : " + uri + "<b>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
