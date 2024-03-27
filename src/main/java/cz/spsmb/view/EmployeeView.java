package cz.spsmb.view;

import cz.spsmb.dao.EmployeeRepository;
import cz.spsmb.model.Employee;
import cz.spsmb.model.Person;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;

import java.io.Serializable;
import java.util.List;

@Named
@RequestScoped
public class EmployeeView implements Serializable {

    @Inject
    EmployeeRepository employeeRepository;

    int salary;
    String department;
    String position;
    String name;

    List<Employee> employeeList;

    @PostConstruct
    public void init(){

        salary = 255;
        department = "DEP_TST";
        position = "POS_TST";
        name = "NAME_TEST";

        employeeList = employeeRepository.listAll();
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    @Transactional
    public void saveEmployee() {
        System.out.println("Saving...");
        Employee employee = new Employee();
        employee.setSalary(salary);
        employee.setDepartment(department);
        employee.setPosition(position);
        employee.setName(name);
        employeeRepository.persist(employee);
        employeeList.add(employee);
        System.out.println("Saved " + employee);
    }
}
