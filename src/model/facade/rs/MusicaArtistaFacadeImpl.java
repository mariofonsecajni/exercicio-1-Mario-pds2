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

import model.dao.MusicaArtistaDao;
import model.domain.MusicaArtista;
import model.facade.MusicaArtistaFacade;

@Path("/musicaartista")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class MusicaArtistaFacadeImpl implements MusicaArtistaFacade {

	@Inject
	private MusicaArtistaDao musicaartistaDao;
	
	
	@Override
	@GET
	public List<MusicaArtista> getMusicaArtistas() {
		return musicaartistaDao.getMusicaArtistas(new MusicaArtista());
	}

	@Override
	@GET
	@Path("/{codigo}")
	public List<MusicaArtista> getMusicaArtistas(@PathParam("codigo") Integer codigo) {
		MusicaArtista musicaartista = new MusicaArtista();
		musicaartista.setCodigo(codigo);
		return musicaartistaDao.getMusicaArtistas(musicaartista);
	}
	
	
	@Override
	@POST 
	public MusicaArtista salvar(MusicaArtista musicaartista) { 
		musicaartista = musicaartistaDao.salvar(musicaartista);
	 	return musicaartista;
	}
	
	@Override
	@PUT 
	public void atualizar(MusicaArtista musicaartista) { 
		musicaartistaDao.atualizar(musicaartista);
	}

	@Override
	@DELETE
	@Path("/{codigo}")
	public void deletarMusicaArtista(@PathParam("codigo") Integer codigo) {
		MusicaArtista musicaartista = new MusicaArtista();
		musicaartista.setCodigo(codigo);
		musicaartistaDao.excluir(musicaartista);
	}

}
