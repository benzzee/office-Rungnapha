package it.holy.benz.office.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.holy.benz.office.model.Project;

public interface ProjecRepository extends CrudRepository <Project,Integer>{
    List <Project> findByNameContaining(String name);
}
