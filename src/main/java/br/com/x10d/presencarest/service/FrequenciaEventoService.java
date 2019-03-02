package br.com.x10d.presencarest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.x10d.presencarest.model.ViewFrequenciaEvento;
import br.com.x10d.presencarest.repository.FrequenciaEventoRepository;

@Service
public class FrequenciaEventoService {
	
	@Autowired
	private FrequenciaEventoRepository frequenciaEventoRepository;

	public List<ViewFrequenciaEvento> devolveViewRelatorio(){
		return (List<ViewFrequenciaEvento>) frequenciaEventoRepository.findAll();
	}
}
