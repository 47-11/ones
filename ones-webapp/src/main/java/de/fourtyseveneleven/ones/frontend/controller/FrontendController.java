package de.fourtyseveneleven.ones.frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontendController {

    @GetMapping({"{_:^(?!index\\.html).+$}", "{_:^(?!api|assets).+$}/**"})
    public String redirectToFrontend() {
        return "forward:/";
    }
}
