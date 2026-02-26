package com.lucas.security;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lucas.bean.LoginBean;

@WebFilter("/*")
public class AutenticationFilter implements Filter{
	
	@Inject
	private LoginBean loginBean;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String url = req.getRequestURI();
        
        boolean paginaLogin = url.contains("login.xhtml");
        boolean jsf = url.contains("javax.faces.resource");
        
        if (loginBean.isLogado() || paginaLogin || jsf ) {
			chain.doFilter(request, response);
		} else {
			res.sendRedirect(req.getContextPath() + "/login.xhtml");
        }
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void destroy() {
		
	}
       

}
