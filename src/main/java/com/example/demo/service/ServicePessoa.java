package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.startup.SetAllPropertiesRule;
import org.springframework.stereotype.Service;

import com.example.demo.dto.SimpleResponse;
import com.example.demo.dto.SimpleResponsePessoas;
import com.example.demo.model.Pessoa;

@Service
public class ServicePessoa {

	List<Pessoa> pessoas = new ArrayList<Pessoa>();
	
    public List<Pessoa> getAllPessoas()
    {
        return pessoas;
    }
    
    public Pessoa getPessoaById(int id)
    {
    	for (Pessoa pessoa : pessoas)
		{
    		if (pessoa.getId() == id) return pessoa;
		}
    	
    	return null;
    }
	
    public SimpleResponse addPessoa (Pessoa pessoa) 
    {
    	SimpleResponse sResponse = new SimpleResponse();
		pessoas.add (pessoa);
		sResponse.setStatusOk(true);
		return sResponse;
    }
   
    
    public SimpleResponse deletePessoa(int id){
		
    	SimpleResponse sr = new SimpleResponse();
    	
    	for (Pessoa pessoa : pessoas)
		{
    		if (pessoa.getId() == id)
    		{
    			pessoas.remove(pessoa);
    			return null;
    		}
		}
		
		sr.addMsg("Id Não encontrado.");
		return sr;
	} 

    
    public boolean updatePessoa (Pessoa p)
    {	
    	try 
    	{
	    	for (Pessoa pessoa : pessoas)
			{
	    		if (pessoa.getId() == p.getId())
	    		{
    				pessoa.setIdade(p.getIdade());
    				pessoa.setNome(p.getNome());
    				pessoa.setEmail(p.getEmail());
	    			return true;
	    			
	    		}
			}
	    	return false;
    	}
	    catch (Exception e) 
		{
	    	return false;
		}
    
    }

}
