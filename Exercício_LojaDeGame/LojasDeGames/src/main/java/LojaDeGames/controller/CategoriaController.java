package LojaDeGames.controller;


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

import LojaDeGamesRepository.CategoriaRepository.categoriaRepository;
import br.org.generation.LojaDeGames.model.Categoria;

@RestController
		@RequestMapping("/categoria")
		@CrossOrigin(origins = "*", allowedHeaders = "*")
		public class CategoriaController {
			
			@Autowired
			private categoriaRepository CategoriaRepository;
			
			@GetMapping
			public ResponseEntity <List<Categoria>> getAll(){
				return ResponseEntity.ok(CategoriaRepository.findAll());
			}
			
			@GetMapping("/{id}")
			public ResponseEntity<Categoria> GetById(@PathVariable long id){
				return CategoriaRepository.findById(id)
						.map(resp -> ResponseEntity.ok(resp))
						.orElse(ResponseEntity.notFound().build());
				
			}
			
			@GetMapping("/tipo/{tipo}")
			public ResponseEntity<List<Categoria>> getByDescricao(@PathVariable String tipo){
				return ResponseEntity.ok(CategoriaRepository.findAllByDescricaoContainingIgnoreCase(tipo));
			}
			
			@PostMapping
			public ResponseEntity<Categoria> post (@RequestBody Categoria categoria){
				return ResponseEntity.status(HttpStatus.CREATED).body(CategoriaRepository.save(categoria));
			}
					
				
			@PutMapping
			public ResponseEntity<Categoria> putPostagem (@Valid @RequestBody Categoria categoria){
				
				return CategoriaRepository.existsById(categoria)
					.map(resposta -> ResponseEntity.ok().body(CategoriaRepository.save(categoria)))
					.orElse(ResponseEntity.notFound().build());
				
			}
			
			@DeleteMapping("/{id}")
			public void delete (@PathVariable long id){
				CategoriaRepository.deleteById(id);
						
			}
		}



