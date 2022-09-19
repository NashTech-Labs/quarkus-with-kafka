package com.knoldus.quarkus.service;

import com.knoldus.quarkus.model.Employee;

public interface EmployeeService {

    /**
     * This method publishes message to
     * the topic
     * @param employee
     */
    void createEmployee(Employee employee);
}
