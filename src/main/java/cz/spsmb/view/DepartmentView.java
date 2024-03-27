package cz.spsmb.view;

import cz.spsmb.dao.DepartmentRepository;
import cz.spsmb.model.Department;
import cz.spsmb.model.Employee;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

public class DepartmentView {

    @Inject
    DepartmentRepository departmentRepository;

    int employeesAmount;
    String name;

    List<Department> departmentList;

    @PostConstruct
    public void init(){

        employeesAmount = 255;
        name = "NAME_TEST";

        departmentList = departmentRepository.listAll();
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    @Transactional
    public void saveEmployee() {
        System.out.println("Saving...");
        Department department = new Department();
        department.setName(name);
        department.setEmployeesAmount(employeesAmount);
        departmentRepository.persist(department);
        departmentList.add(department);
        System.out.println("Saved " + department);
    }
}