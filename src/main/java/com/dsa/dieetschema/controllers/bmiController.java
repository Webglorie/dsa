package com.dsa.dieetschema.controllers;

import com.dsa.dieetschema.formsubmissions.Bmi;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class bmiController {

    @GetMapping({ "/bmi-berekenen", "/bmi-berekenen/" })
    public String bmiForm(Model model) {
        model.addAttribute( "bmi", new Bmi());
        return "views/bmiservice"; // name of the View
    }

    @PostMapping("/bmi-resultaat/")
    public String bmiSubmit(@ModelAttribute Bmi bmi, Model model) {
        model.addAttribute("bmi", bmi);

        return "views/bmiresult";
    }



}
