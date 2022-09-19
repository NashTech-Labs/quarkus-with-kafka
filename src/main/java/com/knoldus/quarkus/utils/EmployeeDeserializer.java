package com.knoldus.quarkus.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.knoldus.quarkus.model.Employee;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.util.Map;

public class EmployeeDeserializer implements Deserializer<Employee> {

    private final Logger logger = LoggerFactory.getLogger(EmployeeDeserializer.class);
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        Deserializer.super.configure(configs, isKey);
    }

    @Override
    public Employee deserialize(String s, byte[] data) {
        try {
            if (data == null){
                logger.error("Null received at deserializing");
                return null;
            }
            logger.info("Deserializing...");
            return objectMapper.readValue(new String(data, StandardCharsets.UTF_8), Employee.class);
        } catch (Exception e) {
            throw new SerializationException("Error when deserializing byte[] to Employee");
        }
    }

    @Override
    public void close() {
        Deserializer.super.close();
    }
}
