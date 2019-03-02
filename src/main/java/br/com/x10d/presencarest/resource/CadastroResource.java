package br.com.x10d.presencarest.resource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.x10d.presencarest.model.Cadastro;
import br.com.x10d.presencarest.service.CadastroService;

@RestController
@RequestMapping("/membro")
public class CadastroResource {
	
	@Autowired
	private CadastroService membroService;
	
	@GetMapping("/todos")
	public ResponseEntity<Cadastro> getTodosOsMembros(){
		
		Cadastro cadastro = new Cadastro();
		try {
			cadastro.setMembros(membroService.devolveTodosDESC());
			
			return new ResponseEntity<Cadastro>(cadastro, HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity<Cadastro>(cadastro, HttpStatus.BAD_GATEWAY);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cadastro> getTodosOsMembros(@PathVariable int id){
		
		Cadastro cadastro = new Cadastro();
		try {
			Cadastro membroEncontrado = membroService.devolveMembroPorId(id);
			
			List<Cadastro> listaComUmMembro = new ArrayList<Cadastro>();

			if(membroEncontrado.getId() > 0) {

				listaComUmMembro.add(membroEncontrado);
			}
			cadastro.setMembros(listaComUmMembro);
			
			return new ResponseEntity<Cadastro>(cadastro, HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity<Cadastro>(cadastro, HttpStatus.BAD_GATEWAY);
		}
	}
	
	@GetMapping("/{de}/{ateh}")
	public ResponseEntity<Cadastro> getTodosOsMembrosDeAteh(@PathVariable int de, @PathVariable int ateh){
		
		Cadastro membro = new Cadastro();
		try {
			List<Cadastro> lista = membroService.devolveMembroDeAteh(de, ateh);

			membro.setMembros(lista);
			
			return new ResponseEntity<Cadastro>(membro, HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity<Cadastro>(membro, HttpStatus.BAD_GATEWAY);
		}
	}
	
	@PostMapping()
	public ResponseEntity<Cadastro> cadastraMembro(@RequestBody Cadastro novoMembro){
		
		Cadastro membroEncontrado = membroService.devolveMembroPorCPF(novoMembro.getCpf());
		
		if(membroEncontrado != null) {
			novoMembro.setId(membroEncontrado.getId());
		}
		Cadastro membroCriado = membroService.salvar(novoMembro);			
		
		if(membroCriado == null) {
			return ResponseEntity.noContent().build();
		}else {
			adicionaCodigoDeBarras(membroCriado);
			
			return new ResponseEntity<Cadastro>(membroCriado, HttpStatus.OK);
		}
	}
	
	private void adicionaCodigoDeBarras(Cadastro membroCriado) {

		Cadastro membroEncontrado = membroService.devolveMembroPorCPF(membroCriado.getCpf());
								  String codigoBarras = String.format("%08d", Long.parseLong(""+membroEncontrado.getId()));
		membroEncontrado.setCodigoBarras(codigoBarras);
		membroEncontrado.setDataCadastro(new Date());
		//aqui vai sempre atualizar:
		membroService.salvar(membroEncontrado);			
	}
	
}
