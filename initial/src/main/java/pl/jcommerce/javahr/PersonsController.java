package pl.jcommerce.javahr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
public class PersonsController {

	private final PersonRepository personRepository;

	@Autowired
	public PersonsController(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET, produces="application/json; charset=UTF-8")
	public List<Person> list() {
		return personRepository.findAll();
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void add(@RequestBody Person p) {

		PersonValidator pv = new PersonValidator();
		if (pv.validate(p)) {
			personRepository.save(p);
		} else {
			throw new ValdationException();
		}

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, produces="application/json; charset=UTF-8")
	public void updatePerson(@RequestBody Person p) {
		PersonValidator pv = new PersonValidator();
		if (pv.validate(p)) {
			personRepository.save(p);
		} else {
			throw new ValdationException();
		}

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces="application/json; charset=UTF-8")
	public Person getPerson(@PathVariable("id") Long id) {
		Person p = personRepository.findOne(id);
		return p;

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deletePerson(@PathVariable("id") Long id) {
		personRepository.delete(id);

	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	class ValdationException extends RuntimeException {

		/**
		 * 
		 */
		private static final long serialVersionUID = 2063012623797712503L;

		public ValdationException() {
			super("Fill correctly all fields");
		}
	}
}
