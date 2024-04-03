package br.com.vainaweb.escolat2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vainaweb.escolat2.dto.DadosColaborador;
import br.com.vainaweb.escolat2.model.ColaboradorModel;
import br.com.vainaweb.escolat2.repository.ColaboradorRepository;
import br.com.vainaweb.escolat2.service.ColaboradorService;

@RestController
@RequestMapping("/colaborador-teste")
public class ColaboradorController {

	@Autowired
	private ColaboradorRepository repository;

	@Autowired
	private ColaboradorService service;

	@GetMapping
	public List<ColaboradorModel> listarTodosOsColaboradores() {
		return service.encontrarTodosOsColaboradores();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ColaboradorModel> ListarPorId(@PathVariable Long id) {

		return repository.findById(id).map(resposta -> ResponseEntity.status(HttpStatus.OK).body(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());

	}

	@PostMapping
	public ResponseEntity<String> cadastrarColaborador(@RequestBody DadosColaborador dados) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(dados));
	}


}
