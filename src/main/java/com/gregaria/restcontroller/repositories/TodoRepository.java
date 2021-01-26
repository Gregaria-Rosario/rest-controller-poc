package com.gregaria.restcontroller.repositories;

import com.gregaria.restcontroller.entities.Todo;

import org.springframework.data.repository.CrudRepository;


public interface TodoRepository extends CrudRepository<Todo, Integer> {
}
