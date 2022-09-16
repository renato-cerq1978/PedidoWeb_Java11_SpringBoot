package br.com.pedido.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.pedido.domain.DomainException;
import br.com.pedido.domain.model.Fornecedor;
import br.com.pedido.domain.repository.FornecedorRepository;

@Service
public class CatalogoFornecedorService {

	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	@Transactional
	public Fornecedor salvar (Fornecedor fornecedor) {
		
		boolean fornecedorExiste = fornecedorRepository.findByCnpj(fornecedor.getCnpj())
			.stream()
			.anyMatch(f -> !f.equals(fornecedor));
		
		if(fornecedorExiste) {
			throw new DomainException("Fornecedor já existe. CPNJ já existe.");
		}
		
		return fornecedorRepository.save(fornecedor);
	}
	
	@Transactional
	public void excluir(String codigo) {
		fornecedorRepository.deleteById(codigo);
	}
}
