package br.org.generation.farmacia.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.generation.farmacia.model.categoria;
import br.org.generation.farmacia.model.produto;
import br.org.generation.farmacia.repository.categoriaRepository;


@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins="*", allowedHeaders="*")
public class CategoriaController<CategoriaRepository> {
	
	@Autowired
	private categoriaRepository categoriaRepository;
	
	@GetMapping
	public ResponseEntity<List<categoria>> getAll(){
		return ResponseEntity.ok(categoriaRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<categoria> getById(@PathVariable Long id){
		return (categoriaRepository.findById(id))
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/setor/{setor}")
	public ResponseEntity<List<produto>> getByCategoria(@PathVariable String setor){
		return ResponseEntity.ok(categoriaRepository.findAllByNomeContainingIgnoreCase(setor));
	}
	
	@PostMapping
	public ResponseEntity <categoria> postCategoria(@Valid @RequestBody categoria categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(categoria));
	}
	
	@PutMapping
	public ResponseEntity <categoria> putCategoria (@Valid @RequestBody categoria categoria){
		return categoriaRepository.findById(categoria.getId())
				.map(resposta ->{
					return ResponseEntity.ok().body(categoriaRepository.save(categoria));
				})
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCategoria(@PathVariable Long id){
		return categoriaRepository.findById(id)
				.map(resposta -> {
					categoriaRepository.deleteById(id);
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				})
				.orElse(ResponseEntity.notFound().build());
	}
	

}
