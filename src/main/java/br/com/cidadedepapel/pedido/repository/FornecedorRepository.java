package br.com.cidadedepapel.pedido.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cidadedepapel.pedido.models.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long>{


	Page<Fornecedor> findByRazaoSocial(String fornecedorNome, Pageable paginacao);

}
