package org.launchcode.starts;

import org.launchcode.starts.controllers.AuthenticationController;
import org.launchcode.starts.data.UserRepository;
import org.launchcode.starts.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AuthenticationFilter extends HandlerInterceptorAdapter {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationController authenticationController;

    private static final List<String> whitelist = Arrays.asList("/index", "/login", "/register", "/logout", "/companies", "/companies/detail", "/events", "/events/detail");

    //Methods

    private static boolean isWhitelisted(String path) {
        for (String pathRoot : whitelist) {
            if (path.equals(pathRoot)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws IOException {

        // Don't require sign-in for whitelist
        if (isWhitelisted(request.getRequestURI())) {
            return true;
        }

        HttpSession session = request.getSession();
        User user = authenticationController.getUserFromSession(session);

        // User is logged in
        if (user != null) {
            return true;
        }

        // User is NOT logged in
        response.sendRedirect("/login");
        return false;
    }

}
