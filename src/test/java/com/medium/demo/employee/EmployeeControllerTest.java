package com.medium.demo.employee;

import com.medium.demo.entities.Employee;
import com.medium.demo.repositories.EmployeeRepository;
import com.medium.demo.services.EmployeeService;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class EmployeeControllerTest {

    @Test
    void getEmployees() {

        //given
        List<Employee> employees = Arrays.asList(new Employee());
        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);
        EmployeeService employeeService = new EmployeeService(employeeRepository);
        given(employeeRepository.findAll()).willReturn(employees);

        //when
        List<Employee> employeeList = employeeService.getEmployees();

        //then
        assertThat(employeeList, hasSize(1));
    }

    @Test
    void getNoEmployees() {

        //given
        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);
        EmployeeService employeeService = new EmployeeService(employeeRepository);
        given(employeeRepository.findAll()).willReturn(Arrays.asList());

        //when
        List<Employee> employeeList = employeeService.getEmployees();

        //then
        assertThat(employeeList, hasSize(0));
    }
}