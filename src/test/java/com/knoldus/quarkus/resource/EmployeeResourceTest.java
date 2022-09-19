package com.knoldus.quarkus.resource;

import com.knoldus.quarkus.model.Employee;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import javax.ws.rs.core.MediaType;

import java.util.stream.Stream;

import static io.restassured.RestAssured.given;

@QuarkusTest
class EmployeeResourceTest {

    @Test
    void shouldReturnAcceptedForValidRequest() {
        given()
                .contentType(MediaType.APPLICATION_JSON).body(dummyRequest())
                .when().post("/employee").then()
                .assertThat().statusCode(202);
    }

    @ParameterizedTest
    @MethodSource("invalidRequestSource")
    void shouldReturnBadRequestForInvalidRequest(Employee request) {
        given()
                .contentType(MediaType.APPLICATION_JSON).body(request)
                .when().post("/employee").then()
                .assertThat().statusCode(400);
    }

    private Employee dummyRequest() {
        Employee employee = new Employee();
        employee.setFirstName("Test");
        employee.setLastName("Quarkus");
        employee.setEmpCode("EmpCode");
        return employee;
    }

    private static Stream<Arguments> invalidRequestSource() {
        Employee emp1 = new Employee();
        emp1.setFirstName(null);
        emp1.setLastName("");
        emp1.setEmpCode("123");
        Employee emp2 = new Employee();
        emp2.setFirstName("New");
        emp2.setLastName("Emp");
        emp2.setEmpCode(null);
        return Stream.of(Arguments.of(emp1), Arguments.of(emp2));
    }
}
