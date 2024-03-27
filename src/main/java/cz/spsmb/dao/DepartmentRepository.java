package cz.spsmb.dao;

import cz.spsmb.model.Department;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DepartmentRepository implements PanacheRepository<Department> {

}
