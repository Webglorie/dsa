package com.dsa.dieetschema.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ServiceController {


    @GetMapping({ "/services/", "/services" })
    public String service(Model model) {
        model.addAttribute("companyName", "Dieet Schema");
        model.addAttribute("serviceTitel1", "Dieet Schema");
        model.addAttribute("serviceTitel2", "Dieet Schema");
        model.addAttribute("serviceTitel3", "Dieet Schema");

        return "services"; // name of the View
    }

    @GetMapping({ "/caloriebehoefte-berekenen/", "/caloriebehoefte-berekenen" })
    public String calorieService(Model model) {
        model.addAttribute("companyName", "Dieet Schema");
        model.addAttribute("serviceTitel1", "Dieet Schema");
        model.addAttribute("serviceTitel2", "Dieet Schema");
        model.addAttribute("serviceTitel3", "Dieet Schema");

        return "views/calorieservice"; // name of the View
    }


}
