package ex03;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class EncoderFilter
 */
@WebFilter("/*") // WebFilter 애너테이션을 이용해 모든 요청이 필터를 거치게 한다.
public class EncoderFilter implements Filter { // 사용자 정의 필터는 반드시 Filter 인터페이스를 구현해야 한다.
	ServletContext context;

    /**
     * Default constructor. 
     */

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy 호출");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		System.out.println("doFilter 호출");
		request.setCharacterEncoding("utf-8");
		String context = ((HttpServletRequest) request).getContextPath();
		String pathinfo = ((HttpServletRequest) request).getRequestURI();
		String realPath = request.getRealPath(pathinfo);
		String mesg = " Context 정보:" + context
						+ "\n URI 정보 : " + pathinfo
						+ "\n 물리적 경로 : " + realPath;
		System.out.println(mesg);
		long begin = System.currentTimeMillis();
		// doFilter 메소드를 기준으로 위쪽은 요청 필터 기능
		chain.doFilter(request, response); // 다음 필터로 넘기는 작업 수행
		// doFilter 메소드를 기준으로 아래쪽은 응답 필터 기능
		long end = System.currentTimeMillis();
		System.out.println("작업 시간:" + (end-begin) + "ms");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("utf-8 인코딩...................");
		context = fConfig.getServletContext();
	}

}
