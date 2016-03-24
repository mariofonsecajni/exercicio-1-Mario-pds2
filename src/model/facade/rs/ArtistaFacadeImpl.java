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

import model.dao.ArtistaDao;
import model.domain.Artista;
import model.facade.ArtistaFacade;

@Path("/artista")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class ArtistaFacadeImpl implements ArtistaFacade {

	@Inject
	private ArtistaDao artistaDao;
	
	
	@Override
	@GET
	public List<Artista> getArtistas() {
		return artistaDao.getArtistas(new Artista());
	}

	@Override
	@GET
	@Path("/{codigo}")
	public List<Artista> getArtistas(@PathParam("codigo") Integer codigo) {
		Artista artista = new Artista();
		artista.setCodigo(codigo);
		return artistaDao.getArtistas(artista);
	}
	
	
	@Override
	@POST 
	public Artista salvar(Artista artista) { 
		artista = artistaDao.salvar(artista);
	 	return artista;
	}
	
	@Override
	@PUT 
	public void atualizar(Artista artista) { 
		artistaDao.atualizar(artista);
	}

	@Override
	@DELETE
	@Path("/{codigo}")
	public void deletarArtista(@PathParam("codigo") Integer codigo) {
		Artista artista = new Artista();
		artista.setCodigo(codigo);
		artistaDao.excluir(artista);
	}

}
