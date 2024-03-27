package cz.spsmb.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Departments")
public class Department {

    @Id
    @Column(name = "DepartmentID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int EmployeesAmount;
    String name;

    public int getEmployeesAmount() {
        return EmployeesAmount;
    }

    public void setEmployeesAmount(int employeesAmount) {
        EmployeesAmount = employeesAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
