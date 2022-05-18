package example.hellosecurity.dto;

public class EmployeeDTO {

    private Integer id;
    private String email;
    private Integer salary;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Integer id, String email, Integer salary) {
        this.id = id;
        this.email = email;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
