package com.example.demo.model;

public class Pessoa {

	private static int numPessoas = 0;
	private int id;
	private String nome;
	private int idade;
	private String email;
	private int empresaId;
	
	/**
	 * @param name
	 * @param idade
	 */
	public Pessoa(String nome, int idade, String email) {
		this.nome = nome;
		this.idade = idade;
		this.email = email;
		id = numPessoas;
		numPessoas++;
	}
	
	/**
	 * @return the name
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param name the name to set
	 */
	public void setNome(String nome) {
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

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the idEmpresa
	 */
	public int getEmpresaId() {
		return empresaId;
	}

	/**
	 * @param idEmpresa the idEmpresa to set
	 */
	public void setEmpresaId(int empresaId) {
		this.empresaId = empresaId;
	}
	
}
