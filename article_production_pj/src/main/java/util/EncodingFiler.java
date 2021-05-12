package util;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;

@WebFilter(urlPatterns = "/*")
public class EncodingFiler implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}
}