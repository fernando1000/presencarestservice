package br.com.x10d.presencarest.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import br.com.x10d.presencarest.model.Chamada;

public interface ChamadaRepository extends CrudRepository<Chamada, Integer> {
	 
	 @Query("select c from Chamada c where c.codigoBarras = :codigoBarras and c.data between(:dataInicial) and(:dataFinal) and c.nomePalestra = :nomePalestra")
	 List<Chamada> devolveChamadaPorCodBarrasEPalestra(@Param("codigoBarras") String codigoBarras,
			 										   @Param("dataInicial") Date dataInicial, 
			 									       @Param("dataFinal") Date dataFinal, 
			 									       @Param("nomePalestra") String nomePalestra, 
			 									       Pageable pageable);
	 
	 @Query("select c from Chamada c where c.data between(:dataInicial) and(:dataFinal) and c.nomePalestra = :nomePalestra")
	 List<Chamada> devolveChamadaDeAtehPorPalestra(@Param("dataInicial") Date dataInicial, 
			 									   @Param("dataFinal") Date dataFinal, 
			 									   @Param("nomePalestra") String nomePalestra, 
			 									   Pageable pageable);

}
