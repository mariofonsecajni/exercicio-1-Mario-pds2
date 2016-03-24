package model.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import model.dao.ArtistaDao;
import model.domain.Artista;
import model.facade.ArtistaFacade;

@WebService(serviceName="ws/artista")
public class ArtistaFacadeImpl implements ArtistaFacade {
	
	@Inject
	private ArtistaDao artistaDao;
			
	@WebMethod
	public List<Artista> getArtistas() {
		return artistaDao.getArtistas(new Artista());
	}
	
	@Override
	@WebMethod(operationName="getArtistaCodigo")
	public List<Artista> getArtistas(@WebParam(name="codigoArtista") 
							Integer codigo) {
		Artista artista = new Artista();
		artista.setCodigo(codigo);
		return artistaDao.getArtistas(artista);
	}
	
	@WebMethod
	public Artista salvar(@WebParam(name="artista") Artista artista) {
		return artistaDao.salvar(artista);
	}
	
	@WebMethod
	public void atualizar(@WebParam(name="artista") Artista artista) {
		artistaDao.atualizar(artista);
	}
	
	@WebMethod
	public void deletarArtista(@WebParam(name="codigoArtista") Integer codigo) {
		Artista artista = new Artista();
		artista.setCodigo(codigo);
		artistaDao.excluir(artista);
	}

	

	



}
