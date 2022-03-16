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

import com.example.demo.dto.EmpresasResposta;
import com.example.demo.dto.SimpleResponse;
import com.example.demo.model.Empresa;
import com.example.demo.service.ServicePessoaEmpresa;


@RestController
public class ControladorEmpresa {

	private final ServicePessoaEmpresa sPessoaEmpresa;

	@Autowired
	public ControladorEmpresa (ServicePessoaEmpresa sPessoaEmpresa)
	{
		this.sPessoaEmpresa = sPessoaEmpresa;
	}
	
	@GetMapping("/getEmpresas")
    public List<Empresa> getEmpresas(){
		return sPessoaEmpresa.getEmpresas();
    }
    
    @GetMapping("/getEmpresa/{id}")
    public Optional <Empresa> getEmpresa(@PathVariable String id){
		
    	return sPessoaEmpresa.getEmpresa(id);
  
    }
    
    
    @PostMapping("/addEmpresa")
    public ResponseEntity<EmpresasResposta> addEmpresa (@RequestBody Empresa empresa) 
    {
    	
    	EmpresasResposta sResponse = new EmpresasResposta();
    	
		if (empresa.getId() != null)
		{
			sResponse.addMsg("ID não nulo.");
			return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(sResponse);
		}		
		
		if ((empresa.getNome() == null))
		{
			sResponse.addMsg("Nome nulo.");
			return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(sResponse);
		}
		
		String msg = sPessoaEmpresa.addEmpresa(empresa);
		
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
			sResponse.setEmpresas(getEmpresas());
			return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(sResponse);
		}
		
    }
    
    @DeleteMapping("/removeEmpresa")
    public ResponseEntity<SimpleResponse> removeEmpresa(@RequestBody Empresa empresa){
    	
    	SimpleResponse sResponse = new SimpleResponse();
    	

		String msg = sPessoaEmpresa.removeEmpresa(empresa);
		
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
    
    @DeleteMapping("/removeEmpresa2/{id}")
    public ResponseEntity<SimpleResponse> removeEmpresa2(@PathVariable String id){
    	
    	SimpleResponse sResponse = new SimpleResponse();
    	

		String msg = sPessoaEmpresa.removeEmpresa2(id);
		
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
    
    @PutMapping ("/updateEmpresa")
    public ResponseEntity<EmpresasResposta> updateEmpresa (@RequestBody Empresa empresa)
    {	
    	EmpresasResposta sResponse = new EmpresasResposta();
        	
		String msg = sPessoaEmpresa.updateEmpresa(empresa);
		
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
			sResponse.setEmpresas(getEmpresas());
			return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(sResponse);
		}
    }

}
