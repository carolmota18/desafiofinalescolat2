package br.com.vainaweb.escolat2.repository;

import java.util.Optional;


import org.springframework.stereotype.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vainaweb.escolat2.model.ColaboradorModel;
@Repository
public interface ColaboradorRepository  extends JpaRepository<ColaboradorModel, Long>{
 Optional<ColaboradorModel> findByCpf(String cpf);
}
