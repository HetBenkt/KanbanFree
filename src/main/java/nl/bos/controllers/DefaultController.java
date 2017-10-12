package nl.bos.controllers;

import lombok.extern.java.Log;
import nl.bos.models.Member;
import nl.bos.repositories.IMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by bosa on 27-9-2017.
 */
@Controller
@Log
@RequestMapping("/app")
public class DefaultController {

    @Autowired
    private IMemberRepository memberRepository;
    @Autowired
    protected AuthenticationManager authenticationManager;
    @Autowired
    protected InMemoryUserDetailsManager inMemoryUserDetailsManager;

    @GetMapping("")
    public String app() {
        return "/home";
    }

    @GetMapping("/home")
    public String home() {
        return "/home";
    }

    @GetMapping("/admin")
    public String admin() {
        return "/admin";
    }

    @GetMapping("/user")
    public String user() {
        return "/user";
    }

    @GetMapping("/boards")
    public String boards() {
        return "/boards";
    }

    @GetMapping("/features")
    public String features() {
        return "/features";
    }

    @GetMapping("/pricing")
    public String pricing() {
        return "/pricing";
    }

    @GetMapping("/press")
    public String press() {
        return "/press";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @PostMapping("/signup")
    public String register(@ModelAttribute Member member, HttpSession session) {
        //Save new user info in H2
        memberRepository.save(new Member(member.getNickName(), member.getPassword(), "user", member.getFirstName(), member.getLastName(), member.getMailAddress()));

        //Add new user to Spring inMemomery Authentication
        final Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        inMemoryUserDetailsManager.createUser(new User(member.getNickName(), member.getPassword(), grantedAuthorities));

        //Direct login the user to the application
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(member.getNickName(), member.getPassword());
        Authentication auth = authenticationManager.authenticate(authRequest);
        SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.setAuthentication(auth);
        session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);

        //Forward to the boards section
        return "/boards";
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }
}
