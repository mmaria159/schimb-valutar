package com.mariamacovei.exchange.controller;

import com.mariamacovei.exchange.dto.EmployeeRequest;
import com.mariamacovei.exchange.dto.ExchangeCurrencyResponse;
import com.mariamacovei.exchange.entity.Employee;
import com.mariamacovei.exchange.service.EmployeeService;
import com.mariamacovei.exchange.service.ExchangeCurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    private final ExchangeCurrencyService exchangeCurrencyService;

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findEmployee(@PathVariable Long id) {
        Employee employee = employeeService.findEmployee(id);
        return new ResponseEntity<>(employee, OK);
    }

    @PostMapping
    public ResponseEntity<Long> addEmployee(@RequestBody @Valid EmployeeRequest request) {
        Long employeeId = employeeService.addEmployee(request);
        return new ResponseEntity<>(employeeId, CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateEmployee(@PathVariable Long id,
                                               @RequestBody @Valid EmployeeRequest request) {
        Long employeeId = employeeService.updateEmployee(id, request);
        return new ResponseEntity<>(employeeId, OK);
    }

    @GetMapping("/{id}/currency")
    public ResponseEntity<List<ExchangeCurrencyResponse>> findCurrencyExchangeByEmployeeId(@PathVariable Long id) {
        List<ExchangeCurrencyResponse> responses = exchangeCurrencyService.findCurrencyExchangeByEmployeeId(id);
        return new ResponseEntity<>(responses, OK);
    }
}
