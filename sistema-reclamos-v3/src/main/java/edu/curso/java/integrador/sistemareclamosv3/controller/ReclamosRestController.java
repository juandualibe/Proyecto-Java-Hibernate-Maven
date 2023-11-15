package edu.curso.java.integrador.sistemareclamosv3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.curso.java.integrador.sistemareclamosv3.bo.Reclamo;
import edu.curso.java.integrador.sistemareclamosv3.controller.dto.ReclamoDTO;
import edu.curso.java.integrador.sistemareclamosv3.service.ReclamoService;

import java.util.*;

@RestController
@RequestMapping("/api/reclamos")
public class ReclamosRestController {
	
	@Autowired
	private ReclamoService reclamoService;

	
	@GetMapping //URL FINAL ES: /api/reclamos
	public List<ReclamoDTO> recuperarTodosLosReclamos() {
		List<ReclamoDTO> reclamosDTO = new ArrayList<ReclamoDTO>();
		
		List<Reclamo> reclamos = reclamoService.recuperarTodosLosReclamos();
		for (Reclamo reclamo : reclamos) {
			reclamosDTO.add(new ReclamoDTO(reclamo));
		}
		
		return reclamosDTO;
	}
	
	@GetMapping(path = "/{id}") //URL FINAL ES: /api/reclamos/123456
	public ReclamoDTO recuperarReclamoPorId(@PathVariable Long id) {
		Reclamo reclamo = reclamoService.buscarReclamoPorId(id);
		ReclamoDTO reclamoDTO = new ReclamoDTO(reclamo);
		return reclamoDTO;
	}
	
	@PostMapping //URL FINAL ES: /api/reclamos
	public ReclamoDTO altaDeNuevoReclamo(@RequestBody ReclamoDTO reclamoDTO) {
		Reclamo reclamo = new Reclamo();
		reclamo.setTitulo(reclamoDTO.getTitulo());
		reclamo.setDescripcion(reclamoDTO.getDescripcion());
		Long idNuevoReclamo = reclamoService.altaDeNuevoReclamo(reclamo);
		reclamoDTO.setId(idNuevoReclamo);
		return reclamoDTO;
	}
	
	
	@DeleteMapping(path = "/{id}") //URL FINAL ES: /api/reclamos/123456
	public void borarReclamoPorId(@PathVariable Long id) {
		reclamoService.borrarReclamo(id);	
	}
	
	@PutMapping(path = "/{id}") //URL FINAL ES: /api/reclamos/123456
	public ReclamoDTO altaDeNuevoReclamo(@PathVariable Long id, @RequestBody ReclamoDTO reclamoDTO) {
		Reclamo reclamo = reclamoService.buscarReclamoPorId(id);
		reclamo.setTitulo(reclamoDTO.getTitulo());
		reclamo.setDescripcion(reclamoDTO.getDescripcion());
		reclamoService.actualizarReclamo(reclamo);
		return reclamoDTO;
	}
	
}
