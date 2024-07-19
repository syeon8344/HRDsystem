package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
    @GetMapping("/")
    public String index(){
        return "/index.html";
    }
    @GetMapping("/directory")
    public String directory(){
        return "/directory.html";
    }
    @GetMapping("/personnel")
    public String personnel(){
        return "/personnel.html";
    }
}
