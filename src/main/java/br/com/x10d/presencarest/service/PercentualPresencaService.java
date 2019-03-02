package br.com.x10d.presencarest.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.x10d.presencarest.model.ViewPercentualPresenca;
import br.com.x10d.presencarest.repository.PercentualPresencaRepository;

@Service
public class PercentualPresencaService {
	
	@Autowired
	private PercentualPresencaRepository percentualPresencaRepository;

	public List<ViewPercentualPresenca> devolveViewRelatorio(){
		
		return (List<ViewPercentualPresenca>) percentualPresencaRepository.findAll();
	}
	
}
