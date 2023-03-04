package pet_clinic_web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pet_clinic_data.services.OwnerService;

@RequestMapping("/owners")
@Controller
public class OwnerController {

	private final OwnerService ownerService;

	public OwnerController(OwnerService ownerService) {
		this.ownerService = ownerService;
	}

	@GetMapping({ "", "/", "/index" })
	public String listOwners(Model model) {

		model.addAttribute("owners", ownerService.findAll());

		return "owners/index";
	}
	
	@GetMapping("/find")
	public String findOwners() {	
		return "notImplemented";
	}
}
