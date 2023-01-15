package pet_clinic_web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import pet_clinic_web.ComonUtil1;


@Controller
public class IndexController {

	@GetMapping({"", "/", "index", "index.html"})
	public String index() {
		System.out.print(ComonUtil1.getAPPName());
		return "index";
	}
	
}
