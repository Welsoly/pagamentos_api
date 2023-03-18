package uea.pagamentos_api.models;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity  //define que esta é uma  entidade no BD
public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id  //define que este é o ID no BD
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@NotBlank(message = "Nome é obrigatório")
	@Size(min=3, max=20, message= "Nome deve ter"
			+ "tamanho entre 3 e 20")
	private String nome;

	public Categoria() {
		super();
	}

	public Categoria(Long codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		Categoria other = (Categoria) obj;
		return Objects.equals(codigo, other.codigo);
	}

}
