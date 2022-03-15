package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Pessoa;

public interface PessoaRepository  extends CrudRepository<Pessoa, Long> {
	
}
