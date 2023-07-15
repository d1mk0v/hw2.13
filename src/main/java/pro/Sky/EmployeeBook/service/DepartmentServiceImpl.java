package pro.Sky.EmployeeBook.service;

import org.springframework.stereotype.Service;
import pro.Sky.EmployeeBook.Employee;

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
                .mapToInt(Employee::getSalary)
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
