package br.com.cidadedepapel.pedido.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Fornecedor {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String cnpj;
	private String razaoSocial;
	private String nomeFantasia;
	
	private int icms;
	private String ie;
	private String origem;
	
	private BigDecimal pedidoMinimo;
	private String ramo;
	private boolean status;
	
	private boolean consignado;
	private String obs;
	
	private Calendar dataCadastro = Calendar.getInstance();
	private Calendar dataUltimaAlteracao;
	
	@ManyToOne
	private Usuario cadastradoPor;
	
	@OneToMany(mappedBy = "fornecedor")
	private List<Endereco> enderecos = new ArrayList<>();
	
	@OneToMany(mappedBy = "fornecedor")
	private List<Contato> contatos = new ArrayList<>();
	
	
	
	public Fornecedor() {}



	public Fornecedor(String cnpj2, String razaoSocial2,
			 String nomeFantasia2, int icms2, String ie2, String origem2, BigDecimal pedidoMinimo2,
			String ramo2, boolean status2, boolean consignado2, String obs2, Calendar dataCadastro2, Usuario usuario,
			Endereco endereco, Contato contato) {
		this.cnpj = cnpj2;
		this.razaoSocial = razaoSocial2;
		this.nomeFantasia = nomeFantasia2;
		this.icms = icms2;
		this.ie = ie2;
		this.origem = origem2;
		this.pedidoMinimo = pedidoMinimo2;
		this.ramo = ramo2;
		this.status = status2;
		this.consignado = consignado2;
		this.obs = obs2;
		this.dataCadastro = dataCadastro2;
		this.cadastradoPor = usuario;
		enderecos.add(endereco);
		contatos.add(contato);
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getCnpj() {
		return cnpj;
	}



	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}



	



	public String getRazaoSocial() {
		return razaoSocial;
	}



	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}



	public String getNomeFantasia() {
		return nomeFantasia;
	}



	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}



	public int getIcms() {
		return icms;
	}



	public void setIcms(int icms) {
		this.icms = icms;
	}



	public String getIe() {
		return ie;
	}



	public void setIe(String ie) {
		this.ie = ie;
	}



	public String getOrigem() {
		return origem;
	}



	public void setOrigem(String origem) {
		this.origem = origem;
	}



	public BigDecimal getPedidoMinimo() {
		return pedidoMinimo;
	}



	public void setPedidoMinimo(BigDecimal pedidoMinimo) {
		this.pedidoMinimo = pedidoMinimo;
	}



	public String getRamo() {
		return ramo;
	}



	public void setRamo(String ramo) {
		this.ramo = ramo;
	}



	public boolean isStatus() {
		return status;
	}



	public void setStatus(boolean status) {
		this.status = status;
	}



	public boolean isConsignado() {
		return consignado;
	}



	public void setConsignado(boolean consignado) {
		this.consignado = consignado;
	}



	public String getObs() {
		return obs;
	}



	public void setObs(String obs) {
		this.obs = obs;
	}



	public Calendar getDataCadastro() {
		return dataCadastro;
	}



	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}



	public Calendar getDataUltimaAlteracao() {
		return dataUltimaAlteracao;
	}



	public void setDataUltimaAlteracao(Calendar dataUltimaAlteracao) {
		this.dataUltimaAlteracao = dataUltimaAlteracao;
	}



	public Usuario getCadastradoPor() {
		return cadastradoPor;
	}



	public void setCadastradoPor(Usuario cadastradoPor) {
		this.cadastradoPor = cadastradoPor;
	}



	public List<Endereco> getEnderecos() {
		return enderecos;
	}



	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}



	public List<Contato> getContatos() {
		return contatos;
	}



	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	};
	
	
	
	
	

}
