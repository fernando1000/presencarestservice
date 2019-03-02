package br.com.x10d.presencarest.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import br.com.x10d.presencarest.model.Chamada;
import br.com.x10d.presencarest.repository.ChamadaRepository;

@Service
public class ChamadaService {
	
	@Autowired
	private ChamadaRepository chamadaRepository;

	public List<Chamada> devolveChamadaDataAtualPorPalestra(String nomePalestra){
		
		Date dataInicial = criaDataInicial();
		Date dataFinal = criaDataFinal();
		
		return (List<Chamada>) chamadaRepository.devolveChamadaDeAtehPorPalestra(dataInicial, dataFinal, nomePalestra, new PageRequest(0, 300));
	}
	
	public Chamada devolveChamadaPorCodBarrasEPalestra(String codigoBarras, String nomePalestra) {
		
		Date dataInicial = criaDataInicial();
		Date dataFinal = criaDataFinal();
		
		List<Chamada> listaComUmItem = chamadaRepository.devolveChamadaPorCodBarrasEPalestra(codigoBarras, dataInicial, dataFinal, nomePalestra, new PageRequest(0, 1));
	
		if(listaComUmItem.isEmpty()) {
			return null;
		}else {
			return listaComUmItem.get(0);			
		}
	}
	
	public Chamada salvar(Chamada chamada){
		return chamadaRepository.save(chamada);
	}

	private Date criaDataInicial() {
		Date dataInicial = new Date();
		dataInicial.setHours(00);
		dataInicial.setMinutes(00);
		dataInicial.setSeconds(01);
		
		return dataInicial;
	}
	private Date criaDataFinal() {
		Date dataFinal = new Date();
		dataFinal.setHours(23);
		dataFinal.setMinutes(59);
		dataFinal.setSeconds(59);
		return dataFinal;
	}
}
