package it.holy.benz.office.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.holy.benz.office.model.Employee;

public interface EmployeeRepository extends CrudRepository <Employee, Integer>{
    List<Employee> findByName(String name);
    List <Employee> findBysalary(int salary);
}
