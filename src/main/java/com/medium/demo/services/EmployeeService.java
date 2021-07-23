package com.medium.demo.services;

import com.medium.demo.entities.Employee;
import com.medium.demo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);

    }

    public void deleteEmployee(Integer id) {
        boolean exists = employeeRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Employee doesn't exists");
        }
        employeeRepository.deleteById(id);
    }
}
