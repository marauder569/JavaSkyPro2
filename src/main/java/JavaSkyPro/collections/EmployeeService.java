package JavaSkyPro.collections;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private static final int MAX_EMPLOYEES = 10;
    private final List<Employee> employees = new ArrayList<>();

    public Employee addEmployee(String firstName, String lastName) {
        if (employees.size() >= MAX_EMPLOYEES) {
            throw new EmployeeStorageIsFullException("Employee storage is full");
        }

        Employee newEmployee = new Employee(firstName, lastName);
        if (employees.contains(newEmployee)) {
            throw new EmployeeAlreadyAddedException("Employee already exists");
        }

        employees.add(newEmployee);
        return newEmployee;
    }

    public Employee removeEmployee(String firstName, String lastName) {
        Employee employeeToRemove = findEmployee(firstName, lastName);
        if (employeeToRemove == null) {
            throw new EmployeeNotFoundException("Employee not found");
        }
        employees.remove(employeeToRemove);
        return employeeToRemove;
    }

    public Employee findEmployee(String firstName, String lastName) {
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                return employee;
            }
        }
        return null;
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees);
    }
}