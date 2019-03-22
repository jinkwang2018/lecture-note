package kr.or.kosta.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;


@WebFilter(
		description = "프로그램 실행시 걸린 시간 체크 필터", 
		urlPatterns = { "/*" }, 
		initParams = { 
				@WebInitParam(name = "Time", value = "0", description = "기준시간")
		})
public class TimeFilter implements Filter {

   
    public TimeFilter() {
        // TODO Auto-generated constructor stub
    }

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		long start = System.currentTimeMillis();
		chain.doFilter(request, response);
		//응답이 나갈때
		long end = System.currentTimeMillis();
		System.out.println("걸린시간 : " + (end - start)/1000F);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
