package com.derivedmed.mytown.security.filter;

import com.derivedmed.mytown.security.token.TokenAuthentication;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Oleg Derivedmed on 09.07.2018
 */
public class TokenFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String token = request.getParameter("token");

        var tokenAuthentication = new TokenAuthentication(token);
        if (token == null){
            tokenAuthentication.setAuthenticated(false);
        }

    }

    @Override
    public void destroy() {

    }
}
