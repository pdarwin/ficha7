package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

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
	
    public boolean addPessoa (Pessoa pessoa) 
    {
		pessoas.add (pessoa);
		return true;
    }
   
    
    public boolean deletePessoa(int id){
		for (Pessoa pessoa : pessoas)
		{
    		if (pessoa.getId() == id)
    		{
    			pessoas.remove(pessoa);
    			return true;
    		}
		}
		return false;
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
