package com.mariamacovei.exchange.service;

import com.mariamacovei.exchange.dto.EmployeeRequest;
import com.mariamacovei.exchange.entity.Employee;

public interface EmployeeService {
    Employee findEmployee(Long Id);
    Long addEmployee(EmployeeRequest employeeRequest);
}
