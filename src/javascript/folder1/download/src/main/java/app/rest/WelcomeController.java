package app.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Nosov Serzh on 27.10.2018 19:03
 */
@RestController
public class WelcomeController {

    @RequestMapping("/")
    public String printWelcome(ModelMap model) {
        return "index";
    }
}
