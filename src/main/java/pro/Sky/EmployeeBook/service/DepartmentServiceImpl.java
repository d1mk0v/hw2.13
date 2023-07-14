package pro.Sky.EmployeeBook.service;

import org.springframework.stereotype.Service;
import pro.Sky.EmployeeBook.Employee;
import pro.Sky.EmployeeBook.exeption.EmployeeAlreadyAddedException;
import pro.Sky.EmployeeBook.exeption.EmployeeNotFoundException;
import pro.Sky.EmployeeBook.exeption.EmployeeStorageIsFullException;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final Map<String, Employee> employees;
    private int maxEmployees = 10;

    public DepartmentServiceImpl() {
        this.employees = new HashMap<>();
        this.maxEmployees = maxEmployees;
    }

    @Override
    public Map<String, Employee> printEmployee() {
        return null;
    }

    @Override
    public Employee maxSalaryByDepartment(int departmentID) {
        return employees.values().stream()
                .filter(e -> Objects.equals(e.getDepartmentID(), departmentID))
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElse(null);
    }

    public Employee minSalaryByDepartment(int departmentID) {
        return employees.values().stream()
                .filter(e -> Objects.equals(e.getDepartmentID(), departmentID))
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElse(null);
    }

    public List<Employee> allEmployeeInDepartment(int departmentID) {
        return employees.values().stream()
                .filter(e -> Objects.equals(e.getDepartmentID(), departmentID))
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> allEmployee() {
        return null;
    }

    public List<Employee> allEmployee(int departmentID) {
        return (List<Employee>) employees.values().stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentID));
    }
}
