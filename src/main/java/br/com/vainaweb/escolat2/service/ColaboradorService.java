package br.com.vainaweb.escolat2.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vainaweb.escolat2.dto.DadosColaborador;
import br.com.vainaweb.escolat2.model.ColaboradorModel;
import br.com.vainaweb.escolat2.repository.ColaboradorRepository;
@Service
public class ColaboradorService {
@Autowired
private ColaboradorRepository repository;

public List<ColaboradorModel> encontrarTodosOsColaboradores() {
	// TODO Auto-generated method stub
	return repository.findAll();
}

public String cadastrar(DadosColaborador dados) {
	var existente = repository.findByCpf(dados.cpf());
	
	if(existente.isPresent()) {
		return "CPF Ja cadastrado";
	}
	else {
		var colaborador = new ColaboradorModel(dados.nome(), dados.cpf(), dados.email(), dados.cargo());
		
		return "Cadastro feito com sucesso";
	
	}
	
}
}
