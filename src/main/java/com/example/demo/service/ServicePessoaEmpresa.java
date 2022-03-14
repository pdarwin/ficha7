package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.SimpleResponse;
import com.example.demo.model.Empresa;
import com.example.demo.model.Pessoa;

@Service
public class ServicePessoaEmpresa {

	List<Pessoa> pessoas = new ArrayList<Pessoa>();
	List<Empresa> empresas = new ArrayList<Empresa>();
	
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
		
    	for (Empresa empresa : empresas)
    	{
    		if (pessoa.getEmpresaId()== empresa.getId())
    		{
    			empresa.addPessoa(pessoa);
    			sResponse.setStatusOk(true);
    			return sResponse;
    		}
    	}
    	
    	sResponse.addMsg("Empresa não encontrada.");
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
    
    public List<Empresa> getAllEmpresas()
    {
        return empresas;
    }
    
    public Empresa getEmpresaById(int id)
    {
    	for (Empresa empresa : empresas)
		{
    		if (empresa.getId() == id) return empresa;
		}
    	
    	return null;
    }
	
    public SimpleResponse addEmpresa (Empresa empresa) 
    {
		empresas.add (empresa);
		return null;
    }
   
    
    public boolean deleteEmpresa(int id){
		for (Empresa empresa : empresas)
		{
    		if (empresa.getId() == id)
    		{
    			empresas.remove(empresa);
    			return true;
    		}
		}
		return false;
	} 

    
    public boolean updateEmpresa (Empresa p)
    {	
    	try 
    	{
	    	for (Empresa empresa : empresas)
			{
	    		if (empresa.getId() == p.getId())
	    		{
	    			if (p.getNome() != null && !p.getNome().isBlank())
	    			{
	    				empresa.setNome(p.getNome());
	    				return true;
	    			}
	    			else return false;
	    			
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
