package br.com.cidadedepapel.pedido.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cidadedepapel.pedido.models.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long>{

}
