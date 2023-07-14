package pro.Sky.EmployeeBook.service;

import pro.Sky.EmployeeBook.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeBookService {
    Employee addNewEmployee(String firstName, String lastName, int departmentID, double salary);
    Employee removeEmployee(String firstName, String lastName, int departmentID, double salary);
    Employee findEmployee(String firstName, String lastName, int departmentID, double salary);

    Map<String, Employee> printEmployee();

    List<Employee> allEmployee();
}
