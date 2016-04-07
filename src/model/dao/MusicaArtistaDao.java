package model.dao;

import java.util.List;

import model.domain.MusicaArtista;

public interface MusicaArtistaDao {

	List<MusicaArtista> getMusicaArtistas(MusicaArtista musicaartista);
	
	public void excluir(MusicaArtista musicaartista);

	MusicaArtista salvar(MusicaArtista musicaartista);

	void atualizar(MusicaArtista musicaartista);

}