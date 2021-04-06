package backend.backapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PageController {
    @GetMapping("/error")
    public String error(){
        return "error";
    }
}
