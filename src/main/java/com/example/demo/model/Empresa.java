package com.example.demo.model;

import java.util.List;

public class Empresa {

	private static int numEmpresas = 0;
	private int id;
	private String nome;
	private String morada;
	private int numFuncionariosAtual;
	private int numFuncionariosDesdeCriacao;
	private List <Pessoa> pessoas;
	
	/**
	 * @param nome
	 * @param morada
	 * @param numFuncionariosAtual
	 * @param numFuncionariosDesdeCriacao
	 */
	public Empresa(String nome, String morada, int numFuncionariosAtual, int numFuncionariosDesdeCriacao) {
		this.nome = nome;
		this.morada = morada;
		this.numFuncionariosAtual = numFuncionariosAtual;
		this.numFuncionariosDesdeCriacao = numFuncionariosDesdeCriacao;
		id = numEmpresas;
		numEmpresas++;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the morada
	 */
	public String getMorada() {
		return morada;
	}
	/**
	 * @param morada the morada to set
	 */
	public void setMorada(String morada) {
		this.morada = morada;
	}
	/**
	 * @return the numFuncionariosAtual
	 */
	public int getNumFuncionariosAtual() {
		return numFuncionariosAtual;
	}
	/**
	 * @param numFuncionariosAtual the numFuncionariosAtual to set
	 */
	public void setNumFuncionariosAtual(int numFuncionariosAtual) {
		this.numFuncionariosAtual = numFuncionariosAtual;
	}
	/**
	 * @return the numFuncionariosDesdeCriacao
	 */
	public int getNumFuncionariosDesdeCriacao() {
		return numFuncionariosDesdeCriacao;
	}
	/**
	 * @param numFuncionariosDesdeCriacao the numFuncionariosDesdeCriacao to set
	 */
	public void setNumFuncionariosDesdeCriacao(int numFuncionariosDesdeCriacao) {
		this.numFuncionariosDesdeCriacao = numFuncionariosDesdeCriacao;
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
