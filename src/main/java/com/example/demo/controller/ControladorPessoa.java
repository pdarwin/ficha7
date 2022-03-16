package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
    @GetMapping("/getPessoas")
    public List<Pessoa> getPessoas(){
		return sPessoaEmpresa.getPessoas();
    }
    
    @GetMapping("/getPessoa/{id}")
    public Optional <Pessoa> getPessoa(@PathVariable String id){
		
    	return sPessoaEmpresa.getPessoa(id);
  
    }
    
    
    @PostMapping("/addPessoa/{empresa_id}")
    public ResponseEntity<PessoasResposta> addPessoa (@RequestBody Pessoa pessoa, @PathVariable String empresa_id) 
    {
    	
    	PessoasResposta sResponse = new PessoasResposta();
    	
		if (pessoa.getId() != null)
		{
			sResponse.addMsg("ID pessoa não nulo.");
			return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(sResponse);
		}		
		
		if ((pessoa.getNome() == null))
		{
			sResponse.addMsg("Nome nulo.");
			return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(sResponse);
		}
		
		if (empresa_id == null || empresa_id.isBlank())
		{
			sResponse.addMsg("ID empresa não preenchido.");
			return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(sResponse);
		}
		
		String msg = sPessoaEmpresa.addPessoa(pessoa, empresa_id);
		
		if (!msg.isBlank())
		{
			sResponse.addMsg(msg);
			return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(sResponse);
		}
		else
		{
			sResponse.setStatusOk(true);
			sResponse.setPessoas(getPessoas());
			return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(sResponse);
		}
		
    }
    
    @DeleteMapping("/removePessoa")
    public ResponseEntity<SimpleResponse> removePessoa(@RequestBody Pessoa pessoa){
    	
    	SimpleResponse sResponse = new SimpleResponse();
    	

		String msg = sPessoaEmpresa.removePessoa(pessoa);
		
		if (!msg.isBlank())
		{
			sResponse.addMsg(msg);
			return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(sResponse);
		}
		else
		{
			sResponse.setStatusOk(true);
			return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(sResponse);
		}
			
    }
    
    @DeleteMapping("/removePessoa2/{id}")
    public ResponseEntity<SimpleResponse> removePessoa2(@PathVariable String id){
    	
    	SimpleResponse sResponse = new SimpleResponse();
    	

		String msg = sPessoaEmpresa.removePessoa2(id);
		
		if (!msg.isBlank())
		{
			sResponse.addMsg(msg);
			return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(sResponse);
		}
		else
		{
			sResponse.setStatusOk(true);
			return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(sResponse);
		}
			
    }
    
    @PutMapping ("/updatePessoa")
    public ResponseEntity<SimpleResponse> updatePessoa (@RequestBody Pessoa pessoa)
    {	
    	SimpleResponse sResponse = new SimpleResponse();
        	
		String msg = sPessoaEmpresa.updatePessoa(pessoa);
		
		if (!msg.isBlank())
		{
			sResponse.addMsg(msg);
			return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(sResponse);
		}
		else
		{
			sResponse.setStatusOk(true);
			return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(sResponse);
		}
    }


}