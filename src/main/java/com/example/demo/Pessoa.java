package com.example.demo;

public class Pessoa {

	private static int numPessoas = 0;
	private String nome;
	private int idade;
	private int id;

	/**
	 * @param name
	 * @param idade
	 */
	public Pessoa(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
		id = numPessoas;
		numPessoas++;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return nome;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the idade
	 */
	public int getIdade() {
		return idade;
	}

	/**
	 * @param idade the idade to set
	 */
	public void setIdade(int idade) {
		this.idade = idade;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

}
