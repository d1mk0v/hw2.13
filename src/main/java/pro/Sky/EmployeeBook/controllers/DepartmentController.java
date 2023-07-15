package pro.Sky.EmployeeBook.controllers;

import org.springframework.web.bind.annotation.*;
import pro.Sky.EmployeeBook.model.Employee;
import pro.Sky.EmployeeBook.services.api.DepartmentService;

import java.util.List;


@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/{ID}/employees")
    public List<Employee> allEmployeeInDepartment(@PathVariable int ID) {
        return departmentService.allEmployeeInDepartment(ID);
    }

    @GetMapping(path = "/{ID}/salary/sum")
    public int sumSalaryByDepartment(@PathVariable int ID) {
        return departmentService.sumSalaryByDepartment(ID);

    }

    @GetMapping(path = "/{ID}/salary/max")
    public Employee maxSalaryByDepartment(@PathVariable int ID) {
        return departmentService.maxSalaryByDepartment(ID);

    }

    @GetMapping(path = "/{ID}/salary/min")
    public Employee minSalaryByDepartment(@PathVariable int ID) {
        return departmentService.minSalaryByDepartment(ID);
    }

    @GetMapping(path = "/employees")
    public Employee allEmployee() {
        return (Employee) departmentService.allEmployee();
    }
}
