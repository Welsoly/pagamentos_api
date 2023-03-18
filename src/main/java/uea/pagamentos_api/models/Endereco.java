package uea.pagamentos_api.models;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Embeddable //Classe incorporada em outra classe
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "Logradouro é obrigatório")
	@Size(min=5, max=30, message= "Logradouro deve ter"
			+ "tamanho entre 5 e 30")
	private String logradouro, nome, complemento, bairro, cep, cidade, estado;

	public Endereco() {
		super();
	}

	public Endereco(@Valid String logradouro, String nome, String complemento, String bairro, String cep, String cidade,
			String estado) {

		super();
		this.logradouro = logradouro;
		this.nome = nome;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
