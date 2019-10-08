package br.com.cidadedepapel.pedido.controller.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import br.com.cidadedepapel.pedido.models.Fornecedor;

public class FornecedorDetalheDto {
	
	private Long id;
	private String cnpj;
	private String razaoSocial;
	private String nomeFantasia;
	private BigDecimal pedidoMinimo;
	private boolean status;
	private boolean consignado;
	private String obs;
	private Calendar dataCadastro;
	private Calendar dataUltimaAlteracao;
	private Long cadastradoPor_id;
	private List<EnderecoDto> enderecos;
	private List<ContatoDto> contatos;
	
	public FornecedorDetalheDto(Fornecedor fornecedor) {
		this.id = fornecedor.getId();
		this.cnpj = fornecedor.getCnpj();
		this.razaoSocial = fornecedor.getRazaoSocial();
		this.nomeFantasia = fornecedor.getNomeFantasia();
		this.pedidoMinimo = fornecedor.getPedidoMinimo();
		this.status = fornecedor.isStatus();
		this.consignado = fornecedor.isConsignado();
		this.obs = fornecedor.getObs();
		this.dataCadastro = fornecedor.getDataCadastro();
		this.dataUltimaAlteracao = fornecedor.getDataUltimaAlteracao();
		this.cadastradoPor_id = fornecedor.getCadastradoPor().getId();
		this.enderecos = new ArrayList<EnderecoDto>();
		enderecos.addAll(fornecedor.getEnderecos().stream().map(EnderecoDto::new).collect(Collectors.toList()));
		this.contatos = new ArrayList<ContatoDto>();
		contatos.addAll(fornecedor.getContatos().stream().map(ContatoDto::new).collect(Collectors.toList()));
		
	}

	public Long getId() {
		return id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public BigDecimal getPedidoMinimo() {
		return pedidoMinimo;
	}

	public boolean isStatus() {
		return status;
	}

	public boolean isConsignado() {
		return consignado;
	}

	public String getObs() {
		return obs;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public Calendar getDataUltimaAlteracao() {
		return dataUltimaAlteracao;
	}

	public Long getCadastradoPor_id() {
		return cadastradoPor_id;
	}

	public List<EnderecoDto> getEnderecos() {
		return enderecos;
	}

	public List<ContatoDto> getContatos() {
		return contatos;
	}
	
	

}
