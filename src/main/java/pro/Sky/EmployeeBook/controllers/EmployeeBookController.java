package pro.Sky.EmployeeBook.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.Sky.EmployeeBook.model.Employee;
import pro.Sky.EmployeeBook.services.api.EmployeeBookService;

import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeBookController {
    private final EmployeeBookService employeeBookService;

    public EmployeeBookController(EmployeeBookService employeeBookService) {
        this.employeeBookService = employeeBookService;
    }


    @GetMapping(path = "/add")
    public Employee addNewEmployee(@RequestParam("firstName") String firstName,
                                   @RequestParam("lastName") String lastName,
                                   @RequestParam("departmentID") int departmentID,
                                   @RequestParam("salary") double salary) {

        return employeeBookService.addNewEmployee(firstName, lastName, departmentID, salary);
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam("firstName") String firstName,
                                   @RequestParam("lastName") String lastName,
                                   @RequestParam("departmentID") int departmentID,
                                   @RequestParam("salary") double salary) {
        return employeeBookService.removeEmployee(firstName, lastName, departmentID, salary);
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName,
                                 @RequestParam("departmentID") int departmentID,
                                 @RequestParam("salary") double salary) {
        return employeeBookService.findEmployee(firstName, lastName, departmentID, salary);
    }

    @GetMapping()
    public Map<String, Employee> printEmployee() {
        return employeeBookService.printEmployee();
    }
}
