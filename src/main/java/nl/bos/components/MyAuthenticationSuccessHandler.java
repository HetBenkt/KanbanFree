package nl.bos.components;

import lombok.extern.java.Log;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

/**
 * Created by bosa on 3-10-2017.
 */
@Component
@Log
public class MyAuthenticationSuccessHandler  implements AuthenticationSuccessHandler {
    private final RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        String targetUrl = "/app/login";

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            log.info(String.format("User %s attempted to access the protected URL %s", auth.getName(), httpServletRequest.getRequestURL()));
            Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
            for (GrantedAuthority authority: authorities) {
                if (authority.getAuthority().equals("ROLE_USER")) {
                    targetUrl = "/app/boards";
                } else if(authority.getAuthority().equals("ROLE_ADMIN")) {
                    targetUrl = "/app/admin";
                }
            }
        }
        redirectStrategy.sendRedirect(httpServletRequest,httpServletResponse,targetUrl);
    }
}
