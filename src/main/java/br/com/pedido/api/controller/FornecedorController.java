package br.com.pedido.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.pedido.domain.model.Fornecedor;
import br.com.pedido.domain.repository.FornecedorRepository;
import br.com.pedido.domain.service.CatalogoFornecedorService;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	@Autowired
	private CatalogoFornecedorService catalogoFornecedorService;
	
	@GetMapping()
	public List<Fornecedor> listar() {
		return fornecedorRepository.findAll();
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Fornecedor> buscar(@PathVariable String codigo) {
		
		return fornecedorRepository.findById(codigo)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Fornecedor adicionar(@Valid @RequestBody Fornecedor fornecedor) {
		return catalogoFornecedorService.salvar(fornecedor);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<Fornecedor> atualizar (@Valid @PathVariable String codigo, @RequestBody Fornecedor fornecedor){
		if(!fornecedorRepository.existsById(codigo)) {
			ResponseEntity.notFound().build();
		}
		
		fornecedor.setCodigo(codigo);
		fornecedor = catalogoFornecedorService.salvar(fornecedor);
		
		return ResponseEntity.ok(fornecedor);
	}
	
	@DeleteMapping("/{codigo}")
	public ResponseEntity<Void> remover (@PathVariable String codigo){
		if(!fornecedorRepository.existsById(codigo)) {
			ResponseEntity.notFound().build();
		}
		
		catalogoFornecedorService.excluir(codigo);
		
		return ResponseEntity.noContent().build();
	}
}
