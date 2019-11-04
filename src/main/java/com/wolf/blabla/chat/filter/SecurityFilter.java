package com.wolf.blabla.chat.filter;

import com.wolf.blabla.chat.domain.Role;
import com.wolf.blabla.chat.domain.User;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//String.format("example.com/user")
//String.format("example.com/admin-service/user")
//String pattern="example.com/%suser"
//--------
//String.format(pattern,"");
//String.format(pattern,"admin-service/");
public class SecurityFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;

        final User user = (User) request.getSession().getAttribute("user");
        if (user.getRoles().stream().noneMatch(Role.ADMIN::equals)) {
            request.getRequestDispatcher("view/not_admin.jsp").forward(request, servletResponse);
        }
        filterChain.doFilter(request, servletResponse);

    }
}
