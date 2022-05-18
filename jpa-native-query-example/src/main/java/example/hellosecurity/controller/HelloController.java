package example.hellosecurity.controller;

import example.hellosecurity.dto.EmployeeDTO;
import example.hellosecurity.dto.IEmployeeDTO;
import example.hellosecurity.model.Employee;
import example.hellosecurity.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/hello")
    public List<Employee> hello(){
        return employeeRepository.findAll();
    }

    @GetMapping("/jpql")
    public List<Employee> helloJPQL(){
        return employeeRepository.customItemsJPQL();
    }

    @GetMapping("/native")
    public List<Employee> helloCustomSQL(){
        return employeeRepository.nativeQuery();
    }

    @GetMapping("/native-1")
    public List<IEmployeeDTO> helloCustomSQLFewFields(){
        return employeeRepository.nativeQueryFewFields_Approach1();
    }


    @GetMapping("/native-2")
    public List<EmployeeDTO> helloCustomSQLFewFields2(){
        return employeeRepository.nativeQueryFewFields_Approach2();
    }
}
