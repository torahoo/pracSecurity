package com.pracsecurity.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
public class BaseController {

    @RequestMapping("/")
    public String index () {
        log.info("indexPage");
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        log.info("loginPage");
        return "login";
    }

    @RequestMapping("/main")
    public String main() {
        log.info("mainPage");
        return "main";
    }

    @RequestMapping("/accessDenied")
    public String accessDenied() {
        return "accessDenied";
    }

    @RequestMapping("/member")
    public String member() {
        return "member";
    }

    @RequestMapping("/manager")
    public String manager() {
        return "manager";
    }

    @RequestMapping("/admin")
    public String admin() {
        return "admin";
    }

}
