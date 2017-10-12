package nl.bos.components;

import lombok.extern.java.Log;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by bosa on 3-10-2017.
 */
@Component
@Log
public class MyAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null) {
            log.info(String.format("User %s attempted to access the protected URL %s", auth.getName(), httpServletRequest.getRequestURL()));
        }

        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/app/403");
    }
}
