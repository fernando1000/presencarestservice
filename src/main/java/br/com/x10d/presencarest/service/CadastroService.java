package br.com.x10d.presencarest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import br.com.x10d.presencarest.model.Cadastro;
import br.com.x10d.presencarest.repository.CadastroRepository;

@Service
public class CadastroService {
	
	@Autowired
	private CadastroRepository membroRepository;

	public List<Cadastro> devolveTodosDESC(){
		return (List<Cadastro>) membroRepository.devolveTodosDesc(new PageRequest(0, 900));
	}

	public List<Cadastro> devolveMembroDeAteh(int de, int ateh) {
		return membroRepository.devolveMembroDeAteh(de, ateh, new PageRequest(0, 300));
	}

	public Cadastro devolveMembroPorId(int id){
		
		Cadastro membro = null;
				
		Optional<Cadastro> membroOptional = membroRepository.findById(id);
		
		if(membroOptional.isPresent()) {
			membro = membroOptional.get();
		}else {
			membro = new Cadastro();
			membro.setId(0);
		}
	
		return membro;
	}
		
	public Cadastro salvar(Cadastro membro){
		return membroRepository.save(membro);
	}
	
	public Cadastro devolveMembroPorCPF(String cpf) {
		
		Cadastro membro = null;
		
		List<Cadastro> lista = membroRepository.devolveMembroPorCPF(cpf, new PageRequest(0, 1));
		if(!lista.isEmpty()) {
			membro = lista.get(0);
		}
		
		return membro;
	}

}
