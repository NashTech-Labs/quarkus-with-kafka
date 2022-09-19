package com.knoldus.quarkus.producer;

import com.knoldus.quarkus.model.Employee;
import io.smallrye.reactive.messaging.kafka.Record;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class EmployeeProducer {

    @Inject
    @Channel("employee-out")
    Emitter<Record<String, Employee>> empEmitter;

    public void createEmployee(Employee employee) {
        empEmitter.send(Record.of(employee.getEmpCode(), employee));
    }
}
