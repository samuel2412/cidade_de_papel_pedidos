package br.com.cidadedepapel.pedido.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cidadedepapel.pedido.models.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

}
