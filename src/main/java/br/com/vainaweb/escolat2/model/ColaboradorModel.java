package br.com.vainaweb.escolat2.model;
import org.hibernate.validator.constraints.br.CPF;
import br.com.vainaweb.escolat2.enums.Cargo;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "tb-colaboradores")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class ColaboradorModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	
	private String nome;
	
	@Email
	@Column(unique=true)
	private String email;
	
	@CPF
	@Column(unique = true)
	private String cpf;
	
	private Cargo cargo;
	
	@Embedded
	private Endereco endereco;

	
	
	public ColaboradorModel(String nome, String cpf, String email,Cargo cargo) {
		this.nome = nome;
		this.email = email;
		this.cpf= cpf;
		this.cargo = cargo;
	}
}
