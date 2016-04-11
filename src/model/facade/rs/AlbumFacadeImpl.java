package model.facade.rs;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.dao.AlbumDao;
import model.domain.Album;
import model.facade.AlbumFacade;

@Path("/album")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class AlbumFacadeImpl implements AlbumFacade {

	@Inject
	private AlbumDao albumDao;
	
	
	@Override
	@GET
	public List<Album> getAlbums() {
		return albumDao.getAlbums(new Album());
	}

	@Override
	@GET
	@Path("/{codigo}")
	public List<Album> getAlbums(@PathParam("codigo") Integer codigo) {
		Album album = new Album();
		album.setNumero(codigo);
		return albumDao.getAlbums(album);
	}
	
	
	@Override
	@POST 
	public Album salvar(Album album) { 
		album = albumDao.salvar(album);
	 	return album;
	}
	
	@Override
	@PUT 
	public void atualizar(Album album) { 
		albumDao.atualizar(album);
	}

	@Override
	@DELETE
	@Path("/{codigo}")
	public void deletarAlbum(@PathParam("codigo") Integer codigo) {
		Album album = new Album();
		album.setNumero(codigo);
		albumDao.excluir(album);
	}

}
