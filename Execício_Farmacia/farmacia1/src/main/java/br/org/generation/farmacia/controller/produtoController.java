package br.org.generation.farmacia.controller;

import java.math.BigDecimal;
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

import br.org.generation.farmacia.model.produto;
import br.org.generation.farmacia.repository.categoriaRepository;
import br.org.generation.farmacia.repository.produtoRepository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins ="*", allowedHeaders="*")
public class produtoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private categoriaRepository categoriaRepository;
	
	@GetMapping
	public ResponseEntity<List<produto>> getAll(){
		return ResponseEntity.ok(produtoRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<produto> getById(@PathVariable Long id){
		return produtoRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<produto>> getByNome(@PathVariable String nome){
		return ResponseEntity.ok(produtoRepository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<produto> postProduto(@Valid @RequestBody produto produto){
		return categoriaRepository.findById(produto.getCategoria().getId())
				.map(reposta -> ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto)))
				.orElse(ResponseEntity.badRequest().build());
	}
	
	@PutMapping
	public ResponseEntity<produto> putProduto(@Valid @RequestBody produto produto){
		if(produtoRepository.existsById(produto.getId())) {
			return categoriaRepository.findById(produto.getCategoria().getId())
					.map(resposta-> ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto)))
					.orElse(ResponseEntity.badRequest().build());
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProduto(@PathVariable Long id){
		return produtoRepository.findById(id)
				.map(resposta ->{
					produtoRepository.deleteById(id);
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				})
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/preco/{start}/preco/{end}")
	public ResponseEntity <List<produto>> getByPrecoBetween(@PathVariable BigDecimal start, @PathVariable BigDecimal end){
		return ResponseEntity.ok(produtoRepository.findByPrecoBetween(start, end));
	}
	
	
}

