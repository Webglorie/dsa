package com.dsa.dieetschema.controllers;

import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.TemplateEngine;

import java.util.Properties;

@Controller
public class IndexController {

    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }

    @GetMapping({ "/", "/index" })
    public String index(Model model) {
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.addDialect(new LayoutDialect());
        return "views/home"; // name of the View
    }
}