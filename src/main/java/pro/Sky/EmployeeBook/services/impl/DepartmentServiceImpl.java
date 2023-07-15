package pro.Sky.EmployeeBook.services.impl;

import org.springframework.stereotype.Service;
import pro.Sky.EmployeeBook.model.Employee;
import pro.Sky.EmployeeBook.services.api.DepartmentService;
import pro.Sky.EmployeeBook.services.api.EmployeeBookService;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final Map<String, Employee> employees;
    private int maxEmployees = 10;

    public DepartmentServiceImpl(EmployeeBookService employeeBookService) {
        this.employees = new HashMap<>();
        this.maxEmployees = maxEmployees;
    }

    public Map<String, Employee> printEmployee() {
        return null;
    }

    public List<Employee> allEmployeeInDepartment(int ID) {
        return employees.values().stream()
                .filter(e -> Objects.equals(e.getID(), ID))
                .collect(Collectors.toList());
    }

    public int sumSalaryByDepartment(int ID) {
        return employees.values().stream()
                .filter(e -> Objects.equals(e.getID(), ID))
                .mapToInt( value -> (int) value.getSalary())
                .sum();
    }

    public Employee maxSalaryByDepartment(int ID) {
        return employees.values().stream()
                .filter(e -> Objects.equals(e.getID(), ID))
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElse(null);
    }

    public Employee minSalaryByDepartment(int ID) {
        return employees.values().stream()
                .filter(e -> Objects.equals(e.getID(), ID))
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public Map<Integer, List<Employee>> allEmployee() {
        return employees.values().stream()
                .collect(Collectors.groupingBy(Employee::getID));
    }
}
