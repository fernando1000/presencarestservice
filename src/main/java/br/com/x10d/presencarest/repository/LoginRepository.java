package br.com.x10d.presencarest.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.x10d.presencarest.model.Login;

public interface LoginRepository extends CrudRepository<Login, Integer> {

	 @Query("SELECT l FROM Login l WHERE l.usuario =:usuario")
	 List<Login> devolveLoginPorUsuario(@Param("usuario") String usuario, Pageable pageable);
	 
}
