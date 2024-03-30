package spring6andTesting.webExample.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import spring6andTesting.webExample.services.AuthorService;

//import spring6.webExample.services.AuthorService;

//import org.springframework.ui.Model;


@Controller
public class AuthorController {
	
	

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model) {

        model.addAttribute("authors", authorService.findAll());

        return "authors";
    }
    
    
    public String sayHello(){
        System.out.println("I'm in the controller");

        return "Hello Everyone!!!";
    }
    
    
}