package br.com.x10d.presencarest.resource;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.x10d.presencarest.model.Chamada;
import br.com.x10d.presencarest.model.Cadastro;
import br.com.x10d.presencarest.service.ChamadaService;
import br.com.x10d.presencarest.service.CadastroService;

@RestController
@RequestMapping("/chamada")
public class ChamadaResource {
	
	@Autowired
	private ChamadaService chamadaService;
	
	@Autowired
	private CadastroService membroService;
	
	@PostMapping("/todos")
	public ResponseEntity<Chamada> getTodosOsMembros(@RequestBody Chamada chamadaReq){
		
		Chamada chamadaResp = new Chamada();
		try {
			chamadaResp.setChamadas(chamadaService.devolveChamadaDataAtualPorPalestra(chamadaReq.getNomePalestra()));
			
			return new ResponseEntity<Chamada>(chamadaResp, HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity<Chamada>(chamadaResp, HttpStatus.BAD_GATEWAY);
		}
	}
	
	@PostMapping()
	public ResponseEntity<Chamada> getT(@RequestBody Chamada chamadaReq){
		
		Chamada chamadaResp = new Chamada();
		List<Chamada> lista = new ArrayList<Chamada>();
		
		try {
			int id = Integer.parseInt(chamadaReq.getCodigoBarras());
			
			Cadastro membroEncontrado = membroService.devolveMembroPorId(id);

			if(membroEncontrado.getId() == 0) {
				
				chamadaResp.setMensagem("Não encontrou o membro selecionado");
			}else {
					Chamada chamada2 = chamadaService.devolveChamadaPorCodBarrasEPalestra(chamadaReq.getCodigoBarras(), chamadaReq.getNomePalestra());
						
					if(chamada2 == null) {

						DateFormat dateFormatt = new SimpleDateFormat("HH:mm:ss", new Locale("pt","BR")); 
						Date dataAtual = new Date();
				    	String dataAtualSohHMS = dateFormatt.format(dataAtual);
				    	
						chamada2 = new Chamada();
						chamada2.setNomePalestra(chamadaReq.getNomePalestra());		    	
						chamada2.setData(dataAtual);
						chamada2.setCodigoBarras(chamadaReq.getCodigoBarras());
						chamada2.setMensagem(dataAtualSohHMS+" | "+membroEncontrado.getNome());
				
						chamadaService.salvar(chamada2);
						
						lista.add(chamada2);						
					}else {
						chamadaResp.setMensagem("Membro já adicionado na lista de chamada!");
					}
				}
			chamadaResp.setChamadas(lista);
			
			return new ResponseEntity<Chamada>(chamadaResp, HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity<Chamada>(chamadaResp, HttpStatus.BAD_GATEWAY);
		}
	}
	
}
