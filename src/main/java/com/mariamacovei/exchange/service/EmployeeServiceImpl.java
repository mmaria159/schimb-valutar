package com.mariamacovei.exchange.service;

import com.mariamacovei.exchange.dto.EmployeeRequest;
import com.mariamacovei.exchange.entity.Employee;
import com.mariamacovei.exchange.exception.EmployeeNotFoundException;
import com.mariamacovei.exchange.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public Employee findEmployee(Long id) {
        return employeeRepository.findById(id).orElseThrow(() ->
                new EmployeeNotFoundException("Employee not found by id: " + id));
    }

    @Override
    public Long addEmployee(EmployeeRequest request) {
        Employee employee = new Employee(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getPhone(),
                request.getFunction());

        employeeRepository.save(employee);

        return employee.getId();
    }

    @Override
    public Long updateEmployee(Long employeeId, EmployeeRequest request) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() ->
                new EmployeeNotFoundException("Employee not found with id: " + employeeId));

        Employee newEmployee = new Employee(
                employee.getId(),
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getPhone(),
                request.getFunction());

        employeeRepository.save(newEmployee);

        return newEmployee.getId();
    }
}
