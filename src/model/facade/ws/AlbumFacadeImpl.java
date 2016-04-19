package model.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import model.dao.AlbumDao;
import model.domain.Album;
import model.facade.AlbumFacade;

@WebService(serviceName="ws/album")
public class AlbumFacadeImpl implements AlbumFacade {
	
	@Inject
	private AlbumDao albumDao;
			
	@WebMethod
	public List<Album> getAlbums() {
		return albumDao.getAlbums(new Album());
	}
	
	@Override
	@WebMethod(operationName="getAlbumNumero")
	public List<Album> getAlbums(@WebParam(name="codigoAlbum") 
							Integer codigo) {
		Album album = new Album();
		album.setNumero(codigo);
		return albumDao.getAlbums(album);
	}
	
	@WebMethod
	public Album salvar(@WebParam(name="album") Album album) {
		return albumDao.salvar(album);
	}
	
	@WebMethod
	public void atualizar(@WebParam(name="album") Album album) {
		albumDao.atualizar(album);
	}
	
	@WebMethod
	public void deletarAlbum(@WebParam(name="codigoAlbum") Integer codigo) {
		Album album = new Album();
		album.setNumero(codigo);
		albumDao.excluir(album);
	}

	

	



}
