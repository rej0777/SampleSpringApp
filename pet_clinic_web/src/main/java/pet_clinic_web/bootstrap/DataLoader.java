package pet_clinic_web.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import pet_clinic_data.model.Owner;
import pet_clinic_data.model.Vet;
import pet_clinic_data.services.OwnerService;
import pet_clinic_data.services.PetService;
import pet_clinic_data.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetService petService;

	public DataLoader(OwnerService ownerService, VetService vetService, PetService petService) {
	
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petService = petService;

	}

	@Override
	public void run(String... args) throws Exception {

		Owner owner1 = new Owner();
		owner1.setFirstName("Michael");
		owner1.setLastName("Weston");
		owner1.setAddress("123 Brickerel");
		owner1.setCity("Miami");
		owner1.setTelephone("1231231234");

		ownerService.save(owner1);

		Owner owner2 = new Owner();
		owner2.setFirstName("Fiona");
		owner2.setLastName("Glenanne");
		owner2.setAddress("123 Brickerel");
		owner2.setCity("Miami");
		owner2.setTelephone("1231231234");

		ownerService.save(owner2);

		Vet vet1 = new Vet();
		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");
		// vet1.getSpecialities().add(savedRadiology);

		Vet vet2 = new Vet();
		vet2.setFirstName("Jessie");
		vet2.setLastName("Porter");
		// vet2.getSpecialities().add(savedSurgery);

		vetService.save(vet1);

		vetService.save(vet2);

		System.out.println("Loaded Vets....");
	}

}