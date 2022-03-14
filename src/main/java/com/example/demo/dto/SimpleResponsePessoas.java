package com.example.demo.dto;

import java.util.List;

import com.example.demo.model.Pessoa;

public class SimpleResponsePessoas extends SimpleResponse {

	private List<Pessoa> pessoas;
	public SimpleResponsePessoas() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the pessoas
	 */
	public List<Pessoa> getPessoas() {
		return pessoas;
	}
	/**
	 * @param pessoas the pessoas to set
	 */
	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	
	
	
}
