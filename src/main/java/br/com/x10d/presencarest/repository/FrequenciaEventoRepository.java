package br.com.x10d.presencarest.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.x10d.presencarest.model.ViewFrequenciaEvento;

public interface FrequenciaEventoRepository extends CrudRepository<ViewFrequenciaEvento, Long> {
	 
}
