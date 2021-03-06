package org.spring.data.jpa.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class SwaggerController {

    @RequestMapping(value = "/", method = GET)
    public String redirectToSwaggerUi() {
        return "redirect:/swagger-ui.html";
    }

}
