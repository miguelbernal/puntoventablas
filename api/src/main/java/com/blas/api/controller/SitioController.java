package com.blas.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SitioController {
    @GetMapping("/")
    public String sitio(){
        return "index";
    }
}