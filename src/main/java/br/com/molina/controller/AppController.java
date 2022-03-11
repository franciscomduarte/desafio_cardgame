package br.com.molina.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class AppController {
	
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
          return "home-page";
    }
    
    @RequestMapping(value = "/quiz", method = RequestMethod.GET)
    public String crudQuiz() {
          return "quiz-page";
    }
    
    @RequestMapping(value = "/enquete", method = RequestMethod.GET)
    public String crudEnquete(@RequestParam("id") long id) {
          return "enquete-page";
    }
    
    @RequestMapping(value = "/responder", method = RequestMethod.GET)
    public String responderEnquete(@RequestParam("id") long id) {
          return "responder-page";
    }
    
    @RequestMapping(value = "/responder-quiz", method = RequestMethod.GET)
    public String responderQuiz() {
          return "responder-quiz-page";
    }
    
    @RequestMapping(value = "/responder-bloco", method = RequestMethod.GET)
    public String responderQuizInteiro(@RequestParam("id") long id) {
          return "responder-bloco-page";
    }
    
    @RequestMapping(value = "/ranking", method = RequestMethod.GET)
    public String verRaking(@RequestParam("id") long id) {
          return "visualizar-ranking-page";
    }
}
