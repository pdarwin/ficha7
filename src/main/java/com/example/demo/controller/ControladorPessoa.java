package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Pessoa;
import com.example.demo.service.ServicePessoa;


@RestController
public class ControladorPessoa {

	private final ServicePessoa sPessoa;
	
	@Autowired
	public ControladorPessoa (ServicePessoa sPessoa)
	{
		this.sPessoa = sPessoa;
	}
	
    @GetMapping("/getAllPessoas")
    public List<Pessoa> getAllPessoas(){
		return sPessoa.getAllPessoas();
    }
    
    @GetMapping("/getPessoaById/{id}")
    public Pessoa getPessoaById(@PathVariable String id){
		
    	try 
    	{
    		return sPessoa.getPessoaById(Integer.parseInt(id));
			
		} 
    	catch (Exception e) 
    	{
			return null;
		}
  
    }
    
    
    @PostMapping("/addPessoa")
    public List <Pessoa> addPessoa (@RequestBody Pessoa pessoa) 
    {
		
		if (pessoa.getNome() == null || pessoa.getNome().isBlank() || pessoa.getIdade() <= 0) return java.util.Collections.emptyList();
		
		return sPessoa.addPessoa(pessoa) ? sPessoa.getAllPessoas() : java.util.Collections.emptyList() ;
    	
    }
    
    @DeleteMapping("/deletePessoa/{id}")
    public String deletePessoa(@PathVariable String id){
    	
    	try 
    	{
    		return sPessoa.deletePessoa(Integer.parseInt(id)) ? "Pessoa removida com sucesso" : "Alguma coisa falhou";
			
		} 
    	catch (Exception e) 
    	{
			return "ID inválido";
		}
    }
    
    @PutMapping ("/updatePessoa")
    public String updatePessoa (@RequestBody Pessoa p)
    {	
		if (p.getIdade() <= 0 ) return "Idade inválida";
    	
		if (p.getNome() == null || p.getNome().isBlank()) return "Nome inválido";

    	return sPessoa.updatePessoa(p) ? "Sucesso ao atualizar pessoa" : "Alguma coisa falhou";

    }

}