package br.com.cidadedepapel.pedido.controller.dto;

import org.springframework.data.domain.Page;

import br.com.cidadedepapel.pedido.models.Endereco;

public class EnderecoDto {
	private Long id;
	private String endereco;
	private String numero;
	private String cep;
	private String bairro;
	private String cidade;
	private String uf;
	
	public EnderecoDto(Endereco e) {
		this.id = e.getId();
		this.endereco = e.getEndereco();
		this.numero = e.getNumero();
		this.cep = e.getCep();
		this.bairro = e.getBairro();
		this.cidade = e.getCidade();
		this.uf = e.getUf().name();
	}
	
	public static Page<EnderecoDto> converter(Page<Endereco> endereco){
		return endereco.map(EnderecoDto::new);
	}

	public Long getId() {
		return id;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getNumero() {
		return numero;
	}

	public String getCep() {
		return cep;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public String getUf() {
		return uf;
	}
	
	
	
	
}
