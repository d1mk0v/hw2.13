package pro.Sky.EmployeeBook.service;

import pro.Sky.EmployeeBook.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {

    int sumSalaryByDepartment(int ID);
    Employee maxSalaryByDepartment(int ID);
    Employee minSalaryByDepartment(int ID);
    List<Employee> allEmployeeInDepartment(int ID);

    Map<Integer, List<Employee>> allEmployee();
}
