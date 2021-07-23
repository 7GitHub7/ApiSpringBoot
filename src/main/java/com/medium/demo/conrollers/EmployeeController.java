package com.medium.demo.conrollers;

import com.medium.demo.entities.Employee;
import com.medium.demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getEmployees(){
      return employeeService.getEmployees();
    }

    @PostMapping
    public void addNewEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteEmployee(@PathVariable("employeeId") Integer id ){
        employeeService.deleteEmployee(id);
    }
}
