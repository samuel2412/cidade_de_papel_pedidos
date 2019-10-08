package br.com.cidadedepapel.pedido.controller.dto;

import java.math.BigDecimal;
import java.util.Calendar;

import org.springframework.data.domain.Page;

import br.com.cidadedepapel.pedido.models.Fornecedor;

public class FornecedorDto {
	
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
	
	
	
	
	public FornecedorDto(Fornecedor fornecedor) {
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



	public static Page<FornecedorDto> converter(Page<Fornecedor> fornecedores){
		return fornecedores.map(FornecedorDto::new);
	}

}
