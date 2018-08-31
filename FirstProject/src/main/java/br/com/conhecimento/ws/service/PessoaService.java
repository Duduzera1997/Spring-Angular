package br.com.conhecimento.ws.service;

import java.util.Collection;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.conhecimento.ws.model.Pessoa;
import br.com.conhecimento.ws.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	PessoaRepository pessoaRepository;

	// Negocios - @1;
	public Pessoa cadastrar(Pessoa pessoa) {

		return pessoaRepository.save(pessoa);

	}

	// @1;
	public Collection<Pessoa> buscar() {
		return pessoaRepository.findAll();
	}

	// @1;
	public void remover(Pessoa pessoa) {
		 pessoaRepository.deleteById(pessoa.getId());
	}

	// @1;
	public Optional<Pessoa> buscarPorID(Integer id) {
		return pessoaRepository.findById(id);
	}

	// @1;
	public Pessoa alterar(Pessoa pessoa) {
		 
		return pessoaRepository.save(pessoa);
	}

}
