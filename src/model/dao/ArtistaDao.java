package model.dao;

import java.util.List;

import model.domain.Artista;

public interface ArtistaDao {

	List<Artista> getArtistas(Artista artista);
	
	public void excluir(Artista artista);

	Artista salvar(Artista artista);

	void atualizar(Artista artista);

}