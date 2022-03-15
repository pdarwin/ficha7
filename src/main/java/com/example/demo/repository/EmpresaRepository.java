package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Empresa;

public interface EmpresaRepository  extends CrudRepository<Empresa, Long> {
	
}