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

import com.example.demo.model.Empresa;
import com.example.demo.service.ServiceEmpresa;


@RestController
public class ControladorEmpresa {

	private final ServiceEmpresa sEmpresa;
	
	@Autowired
	public ControladorEmpresa (ServiceEmpresa sEmpresa)
	{
		this.sEmpresa = sEmpresa;
	}
	
    @GetMapping("/getAllEmpresas")
    public List<Empresa> getAllEmpresas(){
		return sEmpresa.getAllEmpresas();
    }
    
    @GetMapping("/getEmpresaById/{id}")
    public Empresa getEmpresaById(@PathVariable String id){
		
    	try 
    	{
    		return sEmpresa.getEmpresaById(Integer.parseInt(id));
			
		} 
    	catch (Exception e) 
    	{
			return null;
		}
  
    }
    
    
    @PostMapping("/addEmpresa")
    public List <Empresa> addEmpresa (@RequestBody Empresa empresa) 
    {
		
		if (empresa.getNome() == null || empresa.getNome().isBlank() ) return java.util.Collections.emptyList();
		
		return sEmpresa.addEmpresa(empresa) ? sEmpresa.getAllEmpresas() : java.util.Collections.emptyList() ;
    	
    }
    
    @DeleteMapping("/deleteEmpresa/{id}")
    public String deleteEmpresa(@PathVariable String id){
    	
    	try 
    	{
    		return sEmpresa.deleteEmpresa(Integer.parseInt(id)) ? "Empresa removida com sucesso" : "Alguma coisa falhou";
			
		} 
    	catch (Exception e) 
    	{
			return "ID inválido";
		}
    }
    
    @PutMapping ("/updateEmpresa")
    public String updateEmpresa (@RequestBody Empresa p)
    {	
    	
		if (p.getNome() == null || p.getNome().isBlank()) return "Nome inválido";

    	return sEmpresa.updateEmpresa(p) ? "Sucesso ao atualizar empresa" : "Alguma coisa falhou";

    }

}