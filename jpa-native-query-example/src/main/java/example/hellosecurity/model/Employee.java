package example.hellosecurity.model;

import example.hellosecurity.dto.EmployeeDTO;

import javax.persistence.*;

@Entity
@NamedNativeQuery(
        name = "EmpNativ",
        query = "select id, email, salary from employee",
        resultSetMapping = "emp_native_mapping")
@SqlResultSetMapping(
        name = "emp_native_mapping",
        classes = @ConstructorResult(
                targetClass = EmployeeDTO.class,
                columns = {
                        @ColumnResult(name = "id"),
                        @ColumnResult(name = "email"),
                        @ColumnResult(name = "salary")
                }))
public class Employee {

    @Id
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer salary;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}
