package br.com.conhecimento.ws.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.conhecimento.ws.model.Pessoa;
import br.com.conhecimento.ws.service.PessoaService;

@RestController
public class PessoaController {
	
	@Autowired
	PessoaService pessoaService;

	// End points - @2;
	@RequestMapping(method = RequestMethod.POST, value = "/pessoas", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pessoa> cadastrarPessoa(@RequestBody Pessoa pessoa) {

		Pessoa pessoaCadastrada = pessoaService.cadastrar(pessoa);

		return new ResponseEntity<Pessoa>(pessoaCadastrada, HttpStatus.CREATED);
	}

	// @2;
	@RequestMapping(method = RequestMethod.GET, value = "/pessoas", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Pessoa>> buscarPessoas() {

		Collection<Pessoa> pessoasBuscadas = pessoaService.buscar();

		return new ResponseEntity<>(pessoasBuscadas, HttpStatus.OK);
	}

	// @2;
	@RequestMapping(method = RequestMethod.DELETE, value = "/pessoas/{id}")
	public ResponseEntity<Pessoa> removerPessoa(@PathVariable Integer id) {

		Pessoa pessoaEncontrada = pessoaService.buscarPorID(id);

		if (pessoaEncontrada == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			pessoaService.remover(pessoaEncontrada);
			return new ResponseEntity<>(HttpStatus.OK);
		}

	}
	
	// End points - @2;
		@RequestMapping(method = RequestMethod.PUT, value = "/pessoas", consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Pessoa> alterarCliente(@RequestBody Pessoa pessoa) {

			Pessoa pessoaAlterada = pessoaService.alterar(pessoa);

			return new ResponseEntity<Pessoa>(pessoaAlterada, HttpStatus.OK);
		}
	

}
