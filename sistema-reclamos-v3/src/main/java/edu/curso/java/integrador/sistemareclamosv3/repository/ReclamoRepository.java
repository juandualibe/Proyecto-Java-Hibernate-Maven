package edu.curso.java.integrador.sistemareclamosv3.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.curso.java.integrador.sistemareclamosv3.bo.Reclamo;

import java.util.*;

@Repository
public interface ReclamoRepository extends CrudRepository<Reclamo, Long> {

	
	@Query(value = "select r from Reclamo r order by r.titulo")
	public List<Reclamo> recuperarTodosLosReclamosOrdenadosPorTitulo();
	
	@Query(value = "select r from Reclamo r where r.titulo like %:tituloLike% order by r.titulo")
	public List<Reclamo> buscarReclamosPorTitulo(@Param("tituloLike") String titulo);

}
