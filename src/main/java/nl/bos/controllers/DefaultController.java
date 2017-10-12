package nl.bos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by bosa on 27-9-2017.
 */
@Controller
@RequestMapping("/app")
public class DefaultController {
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

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }
}
