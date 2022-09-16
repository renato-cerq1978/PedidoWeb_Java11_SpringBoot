package br.com.pedido.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pedido.domain.model.Fornecedor;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, String> {

	
	List<Fornecedor> findByNome(String nome);
	List<Fornecedor> findByNomeContaining(String nome);
	Optional<Fornecedor> findByCnpj(String cnpj);
}
