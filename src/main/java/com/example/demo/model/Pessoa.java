package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Pessoa")
public class Pessoa {
    
	private static Long numPessoas = 0l;
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
    @ManyToOne
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

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", age=" + idade +
                ", name='" + nome + '\'' +
                '}';
    }
	
}
