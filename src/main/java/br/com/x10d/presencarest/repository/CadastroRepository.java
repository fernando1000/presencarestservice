package br.com.x10d.presencarest.repository;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import br.com.x10d.presencarest.model.Cadastro;

public interface CadastroRepository extends CrudRepository<Cadastro, Integer> {

	 @Query("SELECT c FROM Cadastro c WHERE c.cpf =:cpf")
	 List<Cadastro> devolveMembroPorCPF(@Param("cpf") String cpf, Pageable pageable);

	 @Query("select c from Cadastro c where c.id between(:de) and(:ateh)")
	 List<Cadastro> devolveMembroDeAteh(@Param("de") int de, @Param("ateh") int ateh, Pageable pageable);

	 @Query("SELECT c FROM Cadastro c order by c.id desc")
	 List<Cadastro> devolveTodosDesc(Pageable pageable);
	 
}
