package pro.Sky.EmployeeBook.service;

import org.springframework.web.bind.annotation.PathVariable;
import pro.Sky.EmployeeBook.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {

    Map<String, Employee> printEmployee();

    Employee sumSalaryByDepartment(int ID);
    Employee maxSalaryByDepartment(int ID);
    Employee minSalaryByDepartment(int ID);
    List<Employee> allEmployeeInDepartment(int ID);
    List<Employee> allEmployee();
}
