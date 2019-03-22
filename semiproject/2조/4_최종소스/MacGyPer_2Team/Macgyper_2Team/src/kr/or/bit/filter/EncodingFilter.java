package kr.or.bit.filter;

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
		urlPatterns = { "/*" }, 
		initParams = { 
				@WebInitParam(value = "UTF-8", name = "encoding")
		})
public class EncodingFilter implements Filter {
	private String encoding;
    public EncodingFilter() { }
	public void destroy() {	}
	public void init(FilterConfig fConfig) throws ServletException {
		this.encoding = fConfig.getInitParameter("encoding");
		System.out.println("Filter init : " + this.encoding);
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if(request.getCharacterEncoding() == null) {
			System.out.println("Before : " + request.getCharacterEncoding());
			request.setCharacterEncoding(this.encoding);
			System.out.println("after : " + request.getCharacterEncoding());
		}
		chain.doFilter(request, response);
	}
}
