package br.com.x10d.presencarest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.x10d.presencarest.model.Login;
import br.com.x10d.presencarest.repository.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	private LoginRepository loginRepository;
	
	public Login devolveLoginPorUsuario(String usuario) {
		
		Login login = null;
		
		List<Login> lista = loginRepository.devolveLoginPorUsuario(usuario, new PageRequest(0, 1));
		if(!lista.isEmpty()) {
			login = lista.get(0);
		}
		
		return login;
	}

}
