package br.com.x10d.presencarest.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.x10d.presencarest.model.ViewAproveitamentoPorDia;
import br.com.x10d.presencarest.model.ViewFrequenciaEvento;
import br.com.x10d.presencarest.model.ViewPercentualPresenca;
import br.com.x10d.presencarest.service.AproveitamentoPorDiaService;
import br.com.x10d.presencarest.service.FrequenciaEventoService;
import br.com.x10d.presencarest.service.PercentualPresencaService;

@RestController
@RequestMapping("/relatorio")
public class RelatorioResource {
	
	@Autowired
	private PercentualPresencaService percentualPresencaService;
	
	@Autowired
	private AproveitamentoPorDiaService aproveitamentoPorDiaService;
	
	@Autowired
	private FrequenciaEventoService frequenciaEventoService;
	
	@GetMapping("/PercentualPresenca")
	public ResponseEntity<ViewPercentualPresenca> getViewPercentualPresenca(){
		
		ViewPercentualPresenca viewPercentualPresenca = new ViewPercentualPresenca();
		try {
			viewPercentualPresenca.setLista(percentualPresencaService.devolveViewRelatorio());
			
			return new ResponseEntity<ViewPercentualPresenca>(viewPercentualPresenca, HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity<ViewPercentualPresenca>(viewPercentualPresenca, HttpStatus.BAD_GATEWAY);
		}
	}
	
	@GetMapping("/AproveitamentoPorDia")
	public ResponseEntity<ViewAproveitamentoPorDia> getViewAproveitamentoPorDia(){
		
		ViewAproveitamentoPorDia viewAproveitamentoPorDia = new ViewAproveitamentoPorDia();
		try {
			viewAproveitamentoPorDia.setLista(aproveitamentoPorDiaService.devolveViewRelatorio());
			
			return new ResponseEntity<ViewAproveitamentoPorDia>(viewAproveitamentoPorDia, HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity<ViewAproveitamentoPorDia>(viewAproveitamentoPorDia, HttpStatus.BAD_GATEWAY);
		}
	}
	
	@GetMapping("/FrequenciaEvento")
	public ResponseEntity<ViewFrequenciaEvento> getViewFrequenciaEvento(){
		
		ViewFrequenciaEvento viewFrequenciaEvento = new ViewFrequenciaEvento();
		try {
			viewFrequenciaEvento.setLista(frequenciaEventoService.devolveViewRelatorio());
			
			return new ResponseEntity<ViewFrequenciaEvento>(viewFrequenciaEvento, HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity<ViewFrequenciaEvento>(viewFrequenciaEvento, HttpStatus.BAD_GATEWAY);
		}
	}
	
	
}
