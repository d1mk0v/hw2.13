package pro.Sky.EmployeeBook.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.Sky.EmployeeBook.Employee;
import pro.Sky.EmployeeBook.exeption.EmployeeAlreadyAddedException;
import pro.Sky.EmployeeBook.exeption.EmployeeNotFoundException;
import pro.Sky.EmployeeBook.exeption.EmployeeStorageIsFullException;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeBookServiceImplTest {

    EmployeeBookService employeeBookService;

    @BeforeEach
    public void setUp() {
        employeeBookService = new EmployeeBookServiceImpl();
    }

    @Test
    public void addNewEmployeeTest() {
        Employee employee = new Employee("Sergey", "Ivanov", 1,70000);

        Map<String, Employee> expected = new HashMap<>();
        expected.put("Sergey Ivanov", employee);

        employeeBookService.addNewEmployee("Sergey", "Ivanov", 1,70000);

        Map<String, Employee> actual = employeeBookService.printEmployee();

        assertEquals(expected, actual);
    }

    @Test
    public void addExistingEmployeeTest() {

        employeeBookService.addNewEmployee("Sergey", "Ivanov", 1,70000);

        assertThrows(EmployeeAlreadyAddedException.class, () -> {
            employeeBookService.addNewEmployee("Sergey", "Ivanov", 1,70000);
        });
    }

    @Test
    public void removeEmployeeTest() {

        Employee addedEmployee = employeeBookService.addNewEmployee("Sergey", "Ivanov", 1,70000);

        Employee removedEmployee = employeeBookService.removeEmployee("Sergey", "Ivanov", 1,70000);

        assertNotNull(removedEmployee);
        assertEquals(addedEmployee, removedEmployee);

        Map<String, Employee> employees = employeeBookService.printEmployee();
        assertFalse(employees.containsKey(addedEmployee.getFullName()));
    }
@Test
    public void removeNonExistingEmployeeTest() {

    assertThrows(EmployeeNotFoundException.class, () -> {
            employeeBookService.removeEmployee("Sergey", "Ivanov", 1,70000);
        });
    }

    @Test
    public void findEmployee() {

        Employee addedEmployee = employeeBookService.addNewEmployee("Sergey", "Ivanov", 1,70000);

        Employee foundEmployee = employeeBookService.findEmployee("Sergey", "Ivanov", 1,70000);

        assertNotNull(foundEmployee);
        assertEquals(addedEmployee, foundEmployee);
    }

    @Test
    public void testFindNonExistingEmployee() {

        assertThrows(EmployeeNotFoundException.class, () -> {
            employeeBookService.findEmployee("Sergey", "Ivanov", 1,70000);
        });
    }
}