package pro.Sky.EmployeeBook.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.Sky.EmployeeBook.Employee;
import pro.Sky.EmployeeBook.service.DepartmentService;
import pro.Sky.EmployeeBook.service.EmployeeBookService;

import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/max-salary")
    public Employee maxSalaryByDepartment(@RequestParam("departmentID") int departmentID) {
        return departmentService.maxSalaryByDepartment(departmentID);

    }

    @GetMapping(path = "/min-salary")
    public Employee minSalaryByDepartment(@RequestParam("departmentID") int departmentID) {
        return departmentService.minSalaryByDepartment(departmentID);
    }

    @GetMapping(path = "/allInDepartment")
    public Employee allEmployeeInDepartment(@RequestParam("departmentID") int departmentID) {
        return (Employee) departmentService.allEmployeeInDepartment(departmentID);
    }

    @GetMapping(path = "/departments/all")
    public Employee allEmployee() {
        return (Employee) departmentService.allEmployee();
    }
}
