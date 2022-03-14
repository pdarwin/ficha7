package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.SimpleResponse;
import com.example.demo.model.Empresa;
import com.example.demo.model.Pessoa;

@Service
public class ServiceEmpresa {

	List<Empresa> empresas = new ArrayList<Empresa>();
	
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
    
    public SimpleResponse addPessoa (Pessoa pessoa)
    {
    	SimpleResponse sResponse = new SimpleResponse();
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
}
