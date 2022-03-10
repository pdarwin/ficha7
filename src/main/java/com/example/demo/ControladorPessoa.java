package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorPessoa {

	List<Pessoa> pessoas = new ArrayList<Pessoa>();
	
    @GetMapping("/teste")
    public String teste(){
        return "Whatever";
    }
    
    @GetMapping("/teste2")
    public String teste2(){
        return "Пу́тін — хуйло́!!";
    }
    
    @PostMapping("/addPessoa")
    public String addPessoa (@RequestBody Pessoa pessoa) {
    	pessoas.add (pessoa);
    	return "Sucesso ao inserir a pessoa";
    	
    }
    
    @GetMapping("/getPessoas")
    public List<Pessoa> getPessoas(){
        return pessoas;
    }
    
    @GetMapping("/removePessoa/{id}")
    public String removePessoas(@PathVariable String id){
    	
    	try {
			for (Pessoa pessoa : pessoas)
			{
	    		if (pessoa.getId() == Integer.parseInt(id))
	    		{
	    			pessoas.remove(pessoa); 
	    			return "Sucesso ao remover a pessoa";
	    		}
			}
			return "ID inexistente";
		} catch (Exception e) {
			return "ID inválido";
		}
    }
}
