package pro.Sky.EmployeeBook.services.api;

import pro.Sky.EmployeeBook.model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeBookService {
    Employee addNewEmployee(String firstName, String lastName, int ID, double salary);
    Employee removeEmployee(String firstName, String lastName, int ID, double salary);
    Employee findEmployee(String firstName, String lastName, int ID, double salary);

    Map<String, Employee> printEmployee();

    Map<String, Employee> getEmployees();

    List<Employee> allEmployee();
}
