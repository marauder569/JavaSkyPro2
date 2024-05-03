package JavaSkyPro.collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	private final EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/add")
	public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName) {
		return employeeService.addEmployee(firstName, lastName);
	}

	@GetMapping("/remove")
	public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
		return employeeService.removeEmployee(firstName, lastName);
	}

	@GetMapping("/find")
	public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
		Employee employee = employeeService.findEmployee(firstName, lastName);
		if (employee == null) {
			throw new EmployeeNotFoundException("Employee not found");
		}
		return employee;
	}

	@GetMapping("/all")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}
}
