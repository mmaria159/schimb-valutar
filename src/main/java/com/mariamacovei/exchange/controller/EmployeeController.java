package com.mariamacovei.exchange.controller;

import com.mariamacovei.exchange.entity.Employee;
import com.mariamacovei.exchange.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findEmployee(@PathVariable Long id) {
        Employee employee = employeeService.findEmployee(id);
        return new ResponseEntity<>(employee, OK);
    }
}
