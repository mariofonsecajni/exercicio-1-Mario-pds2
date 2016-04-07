package model.facade;

import java.util.List;

import model.domain.MusicaArtista;

public interface MusicaArtistaFacade {

	List<MusicaArtista> getMusicaArtistas();

	List<MusicaArtista> getMusicaArtistas(Integer codigo);

	MusicaArtista salvar(MusicaArtista musicaartista);

	void atualizar(MusicaArtista musicaartista);

	void deletarMusicaArtista(Integer codigo);

	
}