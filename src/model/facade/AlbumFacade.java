package model.facade;

import java.util.List;

import model.domain.Album;

public interface AlbumFacade {

	List<Album> getAlbums();

	List<Album> getAlbums(Integer codigo);

	Album salvar(Album album);

	void atualizar(Album album);

	void deletarAlbum(Integer codigo);

	
}