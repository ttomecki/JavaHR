package pl.jcommerce.javahr;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/depart")
public class DepartmentsController {

	@RequestMapping(value = "/", method = RequestMethod.GET, produces="application/json; charset=UTF-8")
	public List<String> deparmets() {
		return Arrays.asList("Java developer", "HR", "Sales", "Tester", "BI", ".NET developer");
	}
}
