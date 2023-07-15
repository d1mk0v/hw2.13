package pro.Sky.EmployeeBook.services.impl;

import org.springframework.stereotype.Service;
import pro.Sky.EmployeeBook.model.Employee;
import pro.Sky.EmployeeBook.exeptions.EmployeeAlreadyAddedException;
import pro.Sky.EmployeeBook.exeptions.EmployeeNotFoundException;
import pro.Sky.EmployeeBook.exeptions.EmployeeStorageIsFullException;
import pro.Sky.EmployeeBook.services.api.EmployeeBookService;

import java.util.*;

import static org.apache.commons.lang3.StringUtils.*;

@Service
public class EmployeeBookServiceImpl implements EmployeeBookService {

    private final Map<String, Employee> employees;
    public double sumSalaryByDepartment;
    private int maxEmployees = 10;

    public EmployeeBookServiceImpl() {
        this.employees = new HashMap<>();
    }

    public Employee addNewEmployee(String firstName, String lastName, int ID, double salary) {
        Employee employee = new Employee(firstName, lastName, ID, salary);
        validationOfIncomingData(firstName, lastName);

        if (employees.size() >= maxEmployees) {
            throw new EmployeeStorageIsFullException("Штат сотрудников заполнен");
        }

        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже добавлен");
        }

        if (employees.size() < maxEmployees) {
            employees.put(employee.getFullName(), employee);
        }
        return employee;
    }

    public Employee removeEmployee(String firstName, String lastName, int ID, double salary) {
        Employee employee = new Employee(firstName, lastName, ID, salary);
        validationOfIncomingData(firstName, lastName);

        if (employees.containsKey(employee.getFullName())) {
            employees.remove(employee.getFullName());
            return employee;
        }

        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return employee;
    }

    public Employee findEmployee(String firstName, String lastName, int ID, double salary) {
        Employee employee = new Employee(firstName, lastName, ID, salary);
        validationOfIncomingData(firstName, lastName);

        if (employees.containsKey(employee.getFullName())) {
            return employees.get(employee.getFullName());
        }

        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return employee;
    }

    private void validationOfIncomingData(String firstname, String lastname) {
        if (!isAlpha(firstname) && !isAlpha(lastname)) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Map<String, Employee> printEmployee() {
        return employees;
    }

    @Override
    public Map<String, Employee> getEmployees() {
        return employees;
    }

    @Override
    public List<Employee> allEmployee() {
        return null;
    }
}