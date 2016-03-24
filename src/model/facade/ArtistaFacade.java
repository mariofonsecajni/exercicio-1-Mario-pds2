package model.facade;

import java.util.List;

import model.domain.Artista;

public interface ArtistaFacade {

	List<Artista> getArtistas();

	List<Artista> getArtistas(Integer codigo);

	Artista salvar(Artista artista);

	void atualizar(Artista artista);

	void deletarArtista(Integer codigo);

	
}