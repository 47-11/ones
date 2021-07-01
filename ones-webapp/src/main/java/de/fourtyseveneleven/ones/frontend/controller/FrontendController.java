package de.fourtyseveneleven.ones.frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontendController {

    @GetMapping({"{_:^(?!api|assets|img|index\\.html|service-worker\\.js|manifest\\.json|robots\\.txt).+$}/**"})
    public String redirectToFrontend() {
        return "forward:/index.html";
    }
}
