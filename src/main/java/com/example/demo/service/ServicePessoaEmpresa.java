package com.example.demo.service;

import java.util.ArrayList;
	import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.SimpleResponse;
import com.example.demo.model.Empresa;
import com.example.demo.model.Pessoa;
import com.example.demo.repository.EmpresaRepository;
import com.example.demo.repository.PessoaRepository;

import static java.lang.Float.NaN;
import static java.lang.Long.parseLong;

@Service
public class ServicePessoaEmpresa {
	
	private final PessoaRepository pRepository;
	private final EmpresaRepository eRepository;
	
    @Autowired
    public ServicePessoaEmpresa (PessoaRepository pRepository, EmpresaRepository eRepository) 
    {
        this.pRepository = pRepository;
        this.eRepository = eRepository;
    }
    
    public String addPessoa (Pessoa pessoa) 
    {
    	if (pessoa.getNome().isBlank()) return "Nome não preenchido.";
    	
		if (pessoa.getIdade() <= 0) return "A idade tem de ser maior que zero.";
		
		if ((pessoa.getEmail() != null) && !pessoa.getEmail().isBlank())
		{
			if (!verifyEmail(pessoa.getEmail())) return "Email inválido";
		}
    	
    	pRepository.save(pessoa);
    	return "";
		
//    	for (Empresa empresa : empresas)
//    	{
//    		if (pessoa.getEmpresaId()== empresa.getId())
//    		{
//    			empresa.addPessoa(pessoa);
//    			sResponse.setStatusOk(true);
//    			return sResponse;
//    		}
//    	}
//    	
//    	sResponse.addMsg("Empresa não encontrada.");
//    	return sResponse;
		
    }
   
    
    public String removePessoa(Pessoa pessoa)
    {
        if (pessoa.getId() == null || pRepository.findById(pessoa.getId()).isEmpty()){
        	return "ID de pessoa não encontrado.";
        }

        Pessoa p = pRepository.findById(pessoa.getId()).get();
        pRepository.delete(p);

        return "";
    }

    public String removePessoa2(String id){
        try {
            Long id_long = parseLong(id);

            if (id == null || id_long==NaN || pRepository.findById(id_long).isEmpty()){
                return "ID de pessoa em formato errado ou não encontrado.";
            }

            Pessoa p = pRepository.findById(id_long).get();
            pRepository.delete(p);
            return "";
            
        }catch (Exception e){
            return "o ID tem de ser um n.º longo.";
        }

    }
    
    public String updatePessoa (Pessoa pessoa)
    {	
    	if (pRepository.findById(pessoa.getId()).isEmpty()){
            return "ID de pessoa não encontrado.";
        }

        Pessoa p = pRepository.findById(pessoa.getId()).get();

        if (p.getNome() != null || !p.getNome().isBlank())
        {
            p.setNome(pessoa.getNome());
        }
        else return "Nome não preenchido.";
        

        if (pessoa.getIdade()>0){
            p.setIdade(pessoa.getIdade());
        }
        else return "A idade tem de ser maior que zero.";

		if ((pessoa.getEmail() != null) && !pessoa.getEmail().isBlank())
		{
			if (verifyEmail(pessoa.getEmail()))
			{
				p.setEmail(pessoa.getEmail());
			}
			else return "Email inválido";
			
		}
        
        pRepository.save(p);
        return "";
    
    }
    
    public Optional<Pessoa> getPessoa(String id)
    {	
    	try {
			return pRepository.findById(parseLong(id));
		} catch (NumberFormatException e) {
			return null;
		}
    }

    public List<Pessoa> getPessoas()
    {
    	List<Pessoa> pessoas = new ArrayList<>();
        pRepository.findAll().forEach(pessoas::add);

        return pessoas;
    }
	
    public String addEmpresa (Empresa empresa) 
    {
    	if (empresa.getNome().isBlank())
    	{
        	return "Nome não preenchido.";
    	}

    	eRepository.save(empresa);
    	return "";
    }
   
    
    public String removeEmpresa(Empresa empresa)
    {
        if (empresa.getId() == null || eRepository.findById(empresa.getId()).isEmpty()){
        	return "ID de empresa não encontrado.";
        }

        Empresa emp = eRepository.findById(empresa.getId()).get();
        eRepository.delete(emp);

        return "";
    }

    public String removeEmpresa2(String id){
        try {
            Long id_long = parseLong(id);

            if (id == null || id_long==NaN || eRepository.findById(id_long).isEmpty()){
                return "ID de empresa em formato errado ou não encontrado.";
            }

            Pessoa emp = pRepository.findById(id_long).get();
            pRepository.delete(emp);
            return "";
            
        }catch (Exception e){
            return "o ID tem de ser um n.º longo.";
        }

    }
    
    public String updateEmpresa (Empresa empresa)
    {	
    	if (eRepository.findById(empresa.getId()).isEmpty()){
            return "ID de pessoa não encontrado.";
        }

        Empresa emp = eRepository.findById(empresa.getId()).get();

        if (emp.getNome() != null || !emp.getNome().isBlank())
        {
            emp.setNome(empresa.getNome());
        }
        else return "Nome não preenchido.";
        

        eRepository.save(emp);
        return "";
    
    }
    
    public Optional<Empresa> getEmpresa(String id)
    {
        try {
			return eRepository.findById(parseLong(id));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			return null;
		}
    }

    public List<Empresa> getEmpresas()
    {
    	List<Empresa> empresas = new ArrayList<>();
        eRepository.findAll().forEach(empresas::add);

        return empresas;
    }
    
    public boolean verifyEmail (String email)
    {
    	final String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    	
    	Pattern pattern = Pattern.compile(regex);

  
            Matcher matcher = pattern.matcher(email);

            return matcher.matches();
    	
    }

}
