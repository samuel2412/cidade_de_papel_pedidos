package br.com.cidadedepapel.pedido.controller.form;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CNPJ;

import br.com.cidadedepapel.pedido.models.Contato;
import br.com.cidadedepapel.pedido.models.ContatoTipo;
import br.com.cidadedepapel.pedido.models.Endereco;
import br.com.cidadedepapel.pedido.models.Fornecedor;
import br.com.cidadedepapel.pedido.models.Uf;
import br.com.cidadedepapel.pedido.models.Usuario;
import br.com.cidadedepapel.pedido.repository.ContatoRepository;
import br.com.cidadedepapel.pedido.repository.EnderecoRepository;
import br.com.cidadedepapel.pedido.repository.UsuarioRepository;

public class FornecedorForm {
	@NotNull @NotEmpty
	@CNPJ
	private String cnpj;
	@NotNull @NotEmpty
	private String razaoSocial;
	@NotNull @NotEmpty
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
	
	private Long cadastradoPor;
	
	//endereco
	private String endereco;
	private String numero;
	private String cep;
	private String bairro;
	private String cidade;
	private int uf;
	
	//contato
	private String contatoNome;
	private String contato;
	private int contatoTipo;
	
	
	public String getCnpj() {
		return cnpj;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public int getIcms() {
		return icms;
	}
	public String getIe() {
		return ie;
	}
	public String getOrigem() {
		return origem;
	}
	public BigDecimal getPedidoMinimo() {
		return pedidoMinimo;
	}
	public String getRamo() {
		return ramo;
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
	public Long getCadastradoPor() {
		return cadastradoPor;
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
	public int getUf() {
		return uf;
	}
	public String getContatoNome() {
		return contatoNome;
	}
	public String getContato() {
		return contato;
	}
	public int getContatoTipo() {
		return contatoTipo;
	}
	
		
	public Fornecedor converter(EnderecoRepository enderecoRepository,ContatoRepository contatoRepository,UsuarioRepository usuarioRepository) {
		Endereco endereco = new Endereco();
		endereco.setEndereco(this.endereco);
		endereco.setNumero(this.numero);
		endereco.setCep(this.cep);
		endereco.setBairro(this.bairro);
		endereco.setCidade(this.cidade);
		endereco.setUf(Uf.getById(new Long(this.uf)));
		
		Contato contato = new Contato();
		contato.setContato(this.contato);
		contato.setContatoNome(this.contatoNome);
		contato.setContatoTipo(ContatoTipo.getById(new Long(this.contatoTipo)));
		
		Optional<Usuario> cadastrador = usuarioRepository.findById(cadastradoPor);
		
		return new Fornecedor(cnpj,razaoSocial,nomeFantasia,icms,ie,origem,pedidoMinimo,ramo,status,consignado,obs,dataCadastro,cadastrador.get(),endereco,contato);
	}
	
	
	
	
}
