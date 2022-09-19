package com.knoldus.quarkus.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.knoldus.quarkus.model.Employee;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class EmployeeSerializer implements Serializer<Employee> {

    private final Logger logger = LoggerFactory.getLogger(EmployeeSerializer.class);
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map configs, boolean isKey) {
        Serializer.super.configure(configs, isKey);
    }

    @Override
    public byte[] serialize(String topic, Employee employee) {
        try {
            if (employee == null){
                logger.error("Null received at serializing");
                return new byte[0];
            }
            logger.info("Serializing...");
            return objectMapper.writeValueAsBytes(employee);
        } catch (Exception e) {
            throw new SerializationException("Error when serializing employee");
        }
    }

    @Override
    public void close() {
        Serializer.super.close();
    }
}
