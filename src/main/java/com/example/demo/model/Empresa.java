package com.example.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Empresa")
public class Empresa {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String morada;
	private int numFuncionariosAtual;
	private int numFuncionariosDesdeCriacao;
	
	@OneToMany(mappedBy="empresa")
	private List <Pessoa> pessoas;
	
	/**
	 * @return the id
	 */
	public Long getId() {
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

	
}
