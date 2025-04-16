package formation_sopra.Refuge.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import formation_sopra.Refuge.dao.IDAOAnimal;
import formation_sopra.Refuge.model.Animal;
import formation_sopra.Refuge.rest.request.AnimalRequest;
import formation_sopra.Refuge.rest.response.AnimalResponse;


@RestController
@RequestMapping("/animal")

public class AnimalRestController {
	
	private IDAOAnimal daoAnimal;
	
	public AnimalRestController(IDAOAnimal daoAnimal) {
		super();
		this.daoAnimal = daoAnimal;
	}

	@GetMapping("")
	public List<AnimalResponse> getAll() {
		List<Animal> animals = this.daoAnimal.findAll();

		return animals.stream().map(AnimalResponse::convert).toList();
	}
	
	@GetMapping("/{id}")
	public AnimalResponse getById(@PathVariable Integer id) {
		return this.daoAnimal.findById(id).map(AnimalResponse::convert)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping("")
	public Animal create(@RequestBody AnimalRequest utilisateurRequest) {
		Animal animal = AnimalRequest.convert(utilisateurRequest);

		return daoAnimal.save(animal);
	}
	
	@PutMapping("/{id}")
	public Animal update(@RequestBody AnimalRequest utilisateurRequest, @PathVariable Integer id) {
		if (id != utilisateurRequest.getId() || !this.daoAnimal.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Incohérence de l'appel");
		}

		Animal animal = AnimalRequest.convert(utilisateurRequest);

		return daoAnimal.save(animal);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		if (!this.daoAnimal.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Non trouvé");
		}

		this.daoAnimal.deleteById(id);
	}

}
