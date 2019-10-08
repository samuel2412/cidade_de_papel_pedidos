package br.com.cidadedepapel.pedido.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.cidadedepapel.pedido.controller.dto.FornecedorDetalheDto;
import br.com.cidadedepapel.pedido.controller.dto.FornecedorDto;
import br.com.cidadedepapel.pedido.controller.form.FornecedorForm;
import br.com.cidadedepapel.pedido.models.Contato;
import br.com.cidadedepapel.pedido.models.Endereco;
import br.com.cidadedepapel.pedido.models.Fornecedor;
import br.com.cidadedepapel.pedido.repository.ContatoRepository;
import br.com.cidadedepapel.pedido.repository.EnderecoRepository;
import br.com.cidadedepapel.pedido.repository.FornecedorRepository;
import br.com.cidadedepapel.pedido.repository.UsuarioRepository;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {
	
	@Autowired
	FornecedorRepository fornecedorRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Autowired
	ContatoRepository contatoRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	
	@GetMapping
	@Transactional
	public Page<FornecedorDto> fornecedores(@RequestParam(required = false) String fornecedorNome,
			@PageableDefault(sort="id", direction = Direction.ASC, page=0,size=10) Pageable paginacao) {
		
		if (fornecedorNome == null) {
			Page<Fornecedor> fornecedores = fornecedorRepository.findAll(paginacao);
			return FornecedorDto.converter(fornecedores);
		} else {
			Page<Fornecedor> fornecedores = fornecedorRepository.findByRazaoSocial(fornecedorNome,paginacao);
			return FornecedorDto.converter(fornecedores);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FornecedorDetalheDto> detalhe(@PathVariable Long id) {
		Optional<Fornecedor> fornecedor = fornecedorRepository.findById(id);
		if (fornecedor.isPresent()) {
			//System.out.println("AAAAAAAA	"+fornecedor.get().getEnderecos().size() );
			return ResponseEntity.ok(new FornecedorDetalheDto(fornecedor.get()));
		}
		return ResponseEntity.notFound().build();

	}
	
	
	
	
	@PostMapping
	@Transactional
	public ResponseEntity<FornecedorDto> cadastrar(@RequestBody @Valid FornecedorForm form, UriComponentsBuilder uriBuilder) {

		Fornecedor fornecedor = form.converter(enderecoRepository,contatoRepository,usuarioRepository);
		
		
		
		fornecedorRepository.save(fornecedor);
		Endereco endereco = fornecedor.getEnderecos().get(fornecedor.getEnderecos().size()-1);
		Contato contato = fornecedor.getContatos().get(fornecedor.getContatos().size()-1);
		
		endereco.setFornecedor(fornecedor);
		contato.setFornecedor(fornecedor);
		
		enderecoRepository.save(endereco);
		contatoRepository.save(contato);
		

		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(fornecedor.getId()).toUri();

		return ResponseEntity.created(uri).body(new FornecedorDto(fornecedor));

	}
	
	

}
