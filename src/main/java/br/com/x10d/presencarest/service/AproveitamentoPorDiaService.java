package br.com.x10d.presencarest.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.x10d.presencarest.model.ViewAproveitamentoPorDia;
import br.com.x10d.presencarest.repository.AproveitamentoPorDiaRepository;

@Service
public class AproveitamentoPorDiaService {
	
	@Autowired
	private AproveitamentoPorDiaRepository aproveitamentoPorDiaRepository;

	public List<ViewAproveitamentoPorDia> devolveViewRelatorio(){
		return (List<ViewAproveitamentoPorDia>) aproveitamentoPorDiaRepository.findAll();
	}
}
