package ru.ruzavin.featuretogglewebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FeatureToggleController {

    @GetMapping("/features")
    public String getPage() {
        return "start_page";
    }
}
