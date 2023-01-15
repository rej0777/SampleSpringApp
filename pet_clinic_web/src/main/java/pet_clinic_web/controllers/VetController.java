package pet_clinic_web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pet_clinic_data.services.VetService;

@Controller
@RequestMapping("/vets")
public class VetController {

	private final VetService vetService;
		
	public VetController(VetService vetService) {
		this.vetService = vetService;
	}



	@GetMapping({ "", "/", "/index"}) //vets/index", "vets"
	public String listVets(Model model) {
		
		model.addAttribute("vets", vetService.findAll());
		
		return"vets/index";
	}
	

}
