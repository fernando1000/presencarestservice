package br.com.x10d.presencarest.repository;

import org.springframework.data.repository.CrudRepository;
import br.com.x10d.presencarest.model.ViewPercentualPresenca;

public interface PercentualPresencaRepository extends CrudRepository<ViewPercentualPresenca, Long> {
	 
}
