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

import com.fasterxml.jackson.annotation.JsonView;

import formation_sopra.Refuge.dao.IDAOAnimal;
import formation_sopra.Refuge.model.Animal;
import formation_sopra.Refuge.model.Views;
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
	@JsonView(Views.ViewAnimal.class)
	public List<AnimalResponse> getAll() {
		List<Animal> animals = this.daoAnimal.findAll();

		return animals.stream().map(AnimalResponse::convert).toList();
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.ViewAnimal.class)
	public AnimalResponse getById(@PathVariable Integer id) {
		return this.daoAnimal.findById(id).map(AnimalResponse::convert)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping("")
	@JsonView(Views.ViewAnimal.class)
	public Animal create(@RequestBody AnimalRequest animalRequest) {
		Animal animal = AnimalRequest.convert(animalRequest);

		return daoAnimal.save(animal);
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.ViewAnimal.class)
	public Animal update(@RequestBody AnimalRequest animalRequest, @PathVariable Integer id) {
		if (id != animalRequest.getId() || !this.daoAnimal.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Incohérence de l'appel");
		}

		Animal animal = AnimalRequest.convert(animalRequest);

		return daoAnimal.save(animal);
	}
	
	@DeleteMapping("/{id}")
	@JsonView(Views.ViewAnimal.class)
	public void delete(@PathVariable Integer id) {
		if (!this.daoAnimal.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Non trouvé");
		}

		this.daoAnimal.deleteById(id);
	}

}
