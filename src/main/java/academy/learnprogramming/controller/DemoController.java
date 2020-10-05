package academy.learnprogramming.controller;

import academy.learnprogramming.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
@Slf4j
@Controller
public class DemoController {

    private DemoService service;

    @Autowired
    public DemoController(DemoService service) {
        this.service = service;
    }

    // maps to domain/todo-list/hello   http://localhost:8080/todo-list/hello
    @ResponseBody  // the response is bound to the body - no view template
    @GetMapping("/hello")
    public String hello(){
        return "<HTML><BODY><H1>HELLO</H1></BODY></HTML>";
    }
    //http://localhost:8080/todo-list/welcome
    //http://localhost:8080/todo-list/welcome?user=Neal&lastUser=Plotnik
    @GetMapping("welcome")
    public String welcome(@RequestParam String user, @RequestParam String lastUser, @RequestParam int age, Model model){
        model.addAttribute("user",user + " " + lastUser);
        model.addAttribute("helloMessage",service.getHelloMessage(user+ " " + lastUser));
        model.addAttribute("age",age);
        log.info("model {}",model);
        return "welcome";
    }

//runs every time a request is received
@ModelAttribute("welcomeMessage")
    public String welcomeMessage(){
        log.info("welcome message called");
//        return "welcome to the demo from the jsp";
        return service.getWelcomeMessage();
    }

}
