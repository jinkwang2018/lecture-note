package kr.or.kosta.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//@WebFilter("/EncodingFilter")
public class EncodingFilter implements Filter {
	//member filed
	private String encoding;
    
    public EncodingFilter() {}
    public void destroy() {}

	public void init(FilterConfig fConfig) throws ServletException {
		//초기화 함수(한 번 실행)
		this.encoding = fConfig.getInitParameter("encoding");
		System.out.println("Filter init : " + this.encoding);
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//request(요청이 왔을 때 처리되는 코드)
		if(request.getCharacterEncoding()==null) {
			System.out.println("Before : " + request.getCharacterEncoding());
			request.setCharacterEncoding(this.encoding);
			System.out.println("After : " + request.getCharacterEncoding());
		}
		chain.doFilter(request, response);
		//response(응답할 때 처리되는 코드)
		System.out.println("response 응답처리");
	}

	
	

}
