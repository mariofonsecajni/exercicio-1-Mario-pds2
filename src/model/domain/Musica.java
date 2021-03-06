package model.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MUSICA")
public class Musica implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COD_MUSICA")
	private Integer codigo;

	@Column(name = "NM_MUSICA")
	private String nome;

	@Column(name = "VL_DURACAO")
	private Double duracao;

	@ManyToOne
	@JoinColumn(name = "COD_ALBUM", referencedColumnName = "COD_ALBUM")
	private Album album;

	@ManyToMany
	@JoinTable(name = "MusicaArtista", joinColumns = @JoinColumn(name = "COD_MUSICA"),
	inverseJoinColumns = @JoinColumn(name = "COD_ARTISTA"))
	private List<Artista> artistas;

	/*
	 * @ManyToMany
	 * 
	 * @JoinTable(name="TB_ITEM_PEDIDO",
	 * joinColumns= @JoinColumn(name="CD_ACERVO"),
	 * inverseJoinColumns= @JoinColumn(name="CD_EMPRESTIMO")) private
	 * List<Emprestimo> emprestimos;
	 * 
	 */

	public Musica(Integer codigo, String nome, Double duracao) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.duracao = duracao;
	}

	public Musica() {
		super();
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getDuracao() {
		return duracao;
	}

	public void setDuracao(Double duracao) {
		this.duracao = duracao;
	}

	@Override
	public String toString() {
		return "Musica [codigo=" + codigo + ", nome=" + nome + ", duracao=" + duracao + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Musica other = (Musica) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
