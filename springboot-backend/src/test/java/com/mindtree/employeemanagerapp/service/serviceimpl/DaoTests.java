package com.mindtree.employeemanagerapp.service.serviceimpl;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.mindtree.employeemanagerapp.model.Employee;
import com.mindtree.employeemanagerapp.repository.EmployeeRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DaoTests {

	@Autowired
	EmployeeRepository employeeRepository;
	
	
	//service layer addNewEmployee unit test
	@Test
	public void addNewEmployee() {
		Employee employee = new Employee("Lokesh", "Gupta", "Gupta5241");
		employeeRepository.save(employee);
		List<Employee> employees = employeeRepository.findAll();
		assertEquals(3, employees.size());
	}
	
	//service layer find by id junit test
	@Test
	public void findById() {
		employeeRepository.findById(1L).get();
		assertEquals("vinay", employeeRepository.findById(1L).get().getFirstName());
	}
	
	//service layer test update employee by ID
	@Test
	public void updateEmployeeById() {
		Employee employee= employeeRepository.findById(1L).get();
		assertEquals("vinay", employeeRepository.findById(1L).get().getFirstName());
		employee.setFirstName("Krishna");
		employeeRepository.save(employee);
		assertEquals("Krishna", employeeRepository.findById(1L).get().getFirstName());
	}
	
	
	//service layer delete Employee by id junit test
	@Test
	public void deleteEmployeeById() {
		employeeRepository.deleteById(2L);
		List<Employee> employees = employeeRepository.findAll();
		for (Employee employee : employees) {
			System.out.println(employee.getFirstName());
		}
		assertEquals(1, employees.size());
	}

}
