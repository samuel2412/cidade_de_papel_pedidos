package br.com.cidadedepapel.pedido.controller.dto;

import org.springframework.data.domain.Page;

import br.com.cidadedepapel.pedido.models.Contato;

public class ContatoDto {

	
	private Long id;
	private String contatoNome;
	private String contato;
	private String contatoTipo;
	
	public ContatoDto(Contato c) {
		this.id = c.getId();
		this.contatoNome = c.getContatoNome();
		this.contato = c.getContato();
		this.contatoTipo = c.getContatoTipo().name();
	}
	public static Page<ContatoDto> converter(Page<Contato> contato){
		return contato.map(ContatoDto::new);
	}
	public Long getId() {
		return id;
	}
	public String getContatoNome() {
		return contatoNome;
	}
	public String getContato() {
		return contato;
	}
	public String getContatoTipo() {
		return contatoTipo;
	}
	
	

}
