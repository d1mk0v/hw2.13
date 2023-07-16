package pro.Sky.EmployeeBook.services.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;
import pro.Sky.EmployeeBook.model.Employee;
import pro.Sky.EmployeeBook.services.api.DepartmentService;
import pro.Sky.EmployeeBook.services.api.EmployeeBookService;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTest {
    @Mock
    private EmployeeBookService employeeBookService;
    private DepartmentService departmentService;

    @BeforeEach
    public void setUp(){
        departmentService = new DepartmentServiceImpl(employeeBookService);


    }

    @Test
    public void sumSalaryByDepartmentTest() {

        assertNotNull(employeeBookService);

        Employee employee1 = new Employee("Иван", "Иванов", 1, 200_000);
        Employee employee2 = new Employee("Петр", "Петров", 1, 300_000);
        Employee employee3 = new Employee("Степан", "Сидоров", 2, 250_000);

        Map<String, Employee> employees = new HashMap<>();
        employees.put("Иван Иванов", employee1);
        employees.put("Петр Петров", employee2);
        employees.put("Степан Сидоров", employee3);

        when(employeeBookService.getEmployees()).thenReturn(employees);

        assertEquals(500_000, departmentService.sumSalaryByDepartment(1));
        assertEquals(250_000, departmentService.sumSalaryByDepartment(2));
    }

    @Test
    public void maxSalaryByDepartmentTest() {

        assertNotNull(employeeBookService);

        Employee employee1 = new Employee("Иван", "Иванов", 1, 200_000);
        Employee employee2 = new Employee("Петр", "Петров", 1, 300_000);
        Employee employee3 = new Employee("Степан", "Сидоров", 2, 250_000);

        Map<String, Employee> employees = new HashMap<>();
        employees.put("Иван Иванов", employee1);
        employees.put("Петр Петров", employee2);
        employees.put("Степан Сидоров", employee3);

        Mockito.when(employeeBookService.getEmployees()).thenReturn(employees);

        assertEquals(300_000, departmentService.maxSalaryByDepartment(1));
        assertEquals(250_000, departmentService.maxSalaryByDepartment(2));
    }

    @Test
    public void minSalaryByDepartmentTest() {

        assertNotNull(employeeBookService);

        Employee employee1 = new Employee("Иван", "Иванов", 1, 200_000);
        Employee employee2 = new Employee("Петр", "Петров", 1, 300_000);
        Employee employee3 = new Employee("Степан", "Сидоров", 2, 250_000);

        Map<String, Employee> employees = new HashMap<>();
        employees.put("Иван Иванов", employee1);
        employees.put("Петр Петров", employee2);
        employees.put("Степан Сидоров", employee3);

        Mockito.when(employeeBookService.getEmployees()).thenReturn(employees);

        assertEquals(200_000, departmentService.minSalaryByDepartment(1));
        assertEquals(250_000, departmentService.minSalaryByDepartment(2));
    }

    @Test
    void allEmployeeTest() {
        Employee employee1 = new Employee("Иван", "Иванов", 1, 200_000);
        Employee employee2 = new Employee("Петр", "Петров", 1, 300_000);
        Employee employee3 = new Employee("Степан", "Сидоров", 2, 250_000);

        Map<String, Employee> employees = new HashMap<>();
        employees.put("Иван Иванов", employee1);
        employees.put("Петр Петров", employee2);
        employees.put("Степан Сидоров", employee3);

        Mockito.when(employeeBookService.getEmployees()).thenReturn(employees);

        Map<Integer, List<Employee>> expected = new HashMap<>();
        expected.put(1, Arrays.asList(employee1, employee2));
        expected.put(2, Arrays.asList(employee3));

        departmentService.allEmployee();
        Map<Integer, List<Employee>> actual = departmentService.allEmployee();

        assertEquals(expected.keySet(), actual.keySet());
        assertEquals(expected.size(), actual.size());
        assertEquals(expected.get(1).get(0), actual.get(1).get(1));
        assertEquals(expected.get(1).get(1), actual.get(1).get(0));
        assertEquals(expected.get(2).get(0), actual.get(2).get(0));
    }

    @Test
    void allEmployeeInDepartmentTest() {
        assertNotNull(employeeBookService);

        Employee employee1 = new Employee("Иван", "Иванов", 1, 200_000);

        Map<String, Employee> employees = new HashMap<>();
        employees.put("Иван Иванов", employee1);

        Mockito.when(employeeBookService.getEmployees()).thenReturn(employees);

        List<Employee> expected = new ArrayList<>();

        expected.add(employee1);

        List<Employee> actual = departmentService.allEmployeeInDepartment(1);

        assertEquals(expected, actual);
    }
}