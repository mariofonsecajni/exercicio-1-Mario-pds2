package model.dao;

import java.util.List;

import model.domain.Album;

public interface AlbumDao {

	List<Album> getAlbums(Album album);
	
	public void excluir(Album album);

	Album salvar(Album album);

	void atualizar(Album album);

}