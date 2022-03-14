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
import com.example.demo.dto.SimpleResponsePessoas;
import com.example.demo.model.Pessoa;
import com.example.demo.service.ServiceEmpresa;
import com.example.demo.service.ServicePessoa;

import net.bytebuddy.asm.Advice.Return;


@RestController
public class ControladorPessoa {

	private final ServicePessoa sPessoa;
	private final ServiceEmpresa sEmpresa;
	
	@Autowired
	public ControladorPessoa (ServicePessoa sPessoa, ServiceEmpresa sEmpresa)
	{
		this.sPessoa = sPessoa;
		this.sEmpresa = sEmpresa;
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
    public SimpleResponsePessoas SimpleResponsePessoas (@RequestBody Pessoa pessoa) 
    {
    	
    	SimpleResponsePessoas sResponse = new SimpleResponsePessoas();
    	
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
		
		
		if (sEmpresa.addPessoa(pessoa).isStatusOk())
		{
			sResponse = (SimpleResponsePessoas) sPessoa.addPessoa(pessoa);
		}
		
		if (sResponse == null) sResponse = new SimpleResponsePessoas();
		
		sResponse.setPessoas(sPessoa.getAllPessoas());
		
		return sResponse;
		
    }
    
    @DeleteMapping("/deletePessoa/{id}")
    public SimpleResponse deletePessoa(@PathVariable String id){
    	
    	SimpleResponse sResponse = new SimpleResponse();
    	
    	try 
    	{
    		return sPessoa.deletePessoa(Integer.parseInt(id));
			
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

    	return sPessoa.updatePessoa(p) ? "Sucesso ao atualizar pessoa" : "Alguma coisa falhou";

    }

}