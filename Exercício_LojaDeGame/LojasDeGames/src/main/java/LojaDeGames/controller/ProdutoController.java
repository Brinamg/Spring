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

import LojaDeGamesRepository.CategoriaRepository;
import LojaDeGamesRepository.produtoRepository.ProdutoRepository;
import br.org.generation.LojaDeGames.model.Produto;


@RestController
	@RequestMapping("/produto")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public class ProdutoController {

		
		@Autowired
		private ProdutoRepository produtoRepository;
		
		@Autowired
		private CategoriaRepository categoriaRepository;
		
		@GetMapping
		public ResponseEntity <List<Produto>> getAll(){
			return ResponseEntity.ok(produtoRepository.findAll());
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<Produto> GetById(@PathVariable long id){

			return produtoRepository.findById(id)
					.map(resp -> ResponseEntity.ok(resp))
					.orElse(ResponseEntity.notFound().build());
			
		}
		
		@GetMapping("/nome/{nome}")
		public ResponseEntity<Object> getByTitulo(@PathVariable String nome){
			return ResponseEntity.ok(produtoRepository.findAllByTituloContainingIgnoreCase(nome));
		}
		
		@PostMapping
		public ResponseEntity<Produto> postProduto(@Valid @RequestBody Produto produto){
			    if (categoriaRepository.existsById(produto.getCategoria().getId()))	
				return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto));
				
			return ResponseEntity.notFound().build();
		}
		
		@PutMapping
		public ResponseEntity<Produto> putProduto(@Valid @RequestBody Produto produto) {
						
			return produtoRepository.findById(produto.getId())
					.map(resposta -> {
						return ResponseEntity.ok().body(produtoRepository.save(produto));
					})
					.orElse(ResponseEntity.notFound().build());

		}
		
		
		@DeleteMapping("/{id}")
		public void delete (@PathVariable long id){
			produtoRepository.deleteById(id);
					
		}

	}

