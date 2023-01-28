package com.mariamacovei.exchange.service;

import com.mariamacovei.exchange.entity.Employee;
import com.mariamacovei.exchange.exception.EmployeeNoteFoundException;
import com.mariamacovei.exchange.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public Employee findEmployee(Long id) {
        return employeeRepository.findById(id).orElseThrow(() ->
                new EmployeeNoteFoundException("Employee not found by id: " + id));
    }
}
