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

import com.example.demo.dto.SimpleResponse;
import com.example.demo.dto.PessoasResposta;
import com.example.demo.model.Pessoa;
import com.example.demo.service.ServicePessoaEmpresa;

@RestController
public class ControladorPessoa {

	private final ServicePessoaEmpresa sPessoaEmpresa;
	
	@Autowired
	public ControladorPessoa (ServicePessoaEmpresa sPessoaEmpresa)
	{
		this.sPessoaEmpresa = sPessoaEmpresa;
	}
	
    @GetMapping("/getAllPessoas")
    public List<Pessoa> getAllPessoas(){
		return sPessoaEmpresa.getAllPessoas();
    }
    
    @GetMapping("/getPessoaById/{id}")
    public Pessoa getPessoaById(@PathVariable String id){
		
    	try 
    	{
    		return sPessoaEmpresa.getPessoaById(Integer.parseInt(id));
			
		} 
    	catch (Exception e) 
    	{
			return null;
		}
  
    }
    
    
    @PostMapping("/addPessoa")
    public PessoasResposta SimpleResponsePessoas (@RequestBody Pessoa pessoa) 
    {
    	
    	PessoasResposta sResponse = new PessoasResposta();
    	
		if (pessoa.getNome() == null || pessoa.getNome().isBlank())
		{
			sResponse.addMsg("Nome não preenchido.");
			return sResponse;
		}
		if (pessoa.getIdade() <= 0)
		{
			sResponse.addMsg("A idade tem de ser maior que zero.");
			return sResponse;
		}
		
		
		if (sPessoaEmpresa.addPessoa(pessoa).isStatusOk())
		{
			sResponse = (PessoasResposta) sPessoaEmpresa.addPessoa(pessoa);
		}
		
		if (sResponse == null) sResponse = new PessoasResposta();
		
		sResponse.setPessoas(sPessoaEmpresa.getAllPessoas());
		
		return sResponse;
		
    }
    
    @DeleteMapping("/deletePessoa/{id}")
    public SimpleResponse deletePessoa(@PathVariable String id){
    	
    	SimpleResponse sResponse = new SimpleResponse();
    	
    	try 
    	{
    		return sPessoaEmpresa.deletePessoa(Integer.parseInt(id));
			
		} 
    	catch (Exception e) 
    	{
			sResponse.addMsg("ID inválido");
			return sResponse;
		}
    }
    
    @PutMapping ("/updatePessoa")
    public String updatePessoa (@RequestBody Pessoa p)
    {	
		if (p.getIdade() <= 0 ) return "Idade inválida";
    	
		if (p.getNome() == null || p.getNome().isBlank()) return "Nome inválido";

    	return sPessoaEmpresa.updatePessoa(p) ? "Sucesso ao atualizar pessoa" : "Alguma coisa falhou";

    }
    


}