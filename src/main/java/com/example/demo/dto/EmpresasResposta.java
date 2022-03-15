package com.example.demo.dto;

import java.util.List;

import com.example.demo.model.Empresa;

public class EmpresasResposta extends SimpleResponse {

	private List<Empresa> empresas;
	public EmpresasResposta() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the pessoas
	 */
	public List<Empresa> getEmpresas() {
		return empresas;
	}
	/**
	 * @param pessoas the pessoas to set
	 */
	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}
	
	
	
}
