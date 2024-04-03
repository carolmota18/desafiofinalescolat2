package br.com.vainaweb.escolat2.model;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Endereco {
private String cep;
private String logadouro;
private String bairro;
private String cidade;
private String complemento;
private String uf;
private Integer numero;

}
