package br.com.x10d.presencarest.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.x10d.presencarest.model.Login;
import br.com.x10d.presencarest.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginResource {

	@Autowired
	private LoginService loginService;
	
	@GetMapping("/{usuario}/{senha}")
	public ResponseEntity<Login> validaUsuario(@PathVariable String usuario, @PathVariable String senha) {
		
		Login login = loginService.devolveLoginPorUsuario(usuario);
		if(login != null) {
			if(login.getSenha().equals(senha)) {
				
				return new ResponseEntity<Login>(login, HttpStatus.OK);
			}
		}
		
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();			
	}
	
}
