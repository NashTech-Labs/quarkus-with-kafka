package com.knoldus.quarkus.service.impl;

import com.knoldus.quarkus.model.Employee;
import com.knoldus.quarkus.producer.EmployeeProducer;
import com.knoldus.quarkus.service.EmployeeService;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeProducer employeeProducer;

    public EmployeeServiceImpl(EmployeeProducer employeeProducer) {
        this.employeeProducer = employeeProducer;
    }

    @Override
    public void createEmployee(Employee employee) {
        employeeProducer.createEmployee(employee);
    }
}
