package example.hellosecurity.repo;


import example.hellosecurity.dto.EmployeeDTO;
import example.hellosecurity.dto.IEmployeeDTO;
import example.hellosecurity.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("select i from Employee i")
    List<Employee> customItemsJPQL();

    @Query(value = "select id, first_name, last_name, email, salary * 2 as salary from employee", nativeQuery = true)
    List<Employee> nativeQuery();

    @Query(value = "select id, first_name as firstName, salary/2 as salary from employee", nativeQuery = true)
    List<IEmployeeDTO> nativeQueryFewFields_Approach1();


    @Query(nativeQuery = true, name = "EmpNativ")
    List<EmployeeDTO> nativeQueryFewFields_Approach2();
}
