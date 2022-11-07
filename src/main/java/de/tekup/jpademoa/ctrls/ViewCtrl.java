package de.tekup.jpademoa.ctrls;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewCtrl {

    @GetMapping({"/","/index"})
    public String landingPage(){
        return "index";
    }

    @GetMapping("/about")
    public String AboutPage(){
        return "about";
    }
}
