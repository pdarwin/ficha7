package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Pessoa")
public class Pessoa {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column (name ="id", nullable = false)
	private Long id;
	
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="empresa_id", nullable=false)
    private Empresa empresa;
	
	private String nome;
	private int idade;
	private String email;
	
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
	public Long getId() {
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
	public Long getEmpresaId() {
		return empresa.getId();
	}

	
    /**
	 * @return the empresa
	 */
	public Empresa getEmpresa() {
		return empresa;
	}

	/**
	 * @param empresa the empresa to set
	 */
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", age=" + idade +
                ", name='" + nome + '\'' +
                '}';
    }
	
}
