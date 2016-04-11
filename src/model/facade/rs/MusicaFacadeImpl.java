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

import model.dao.MusicaDao;
import model.domain.Musica;
import model.facade.MusicaFacade;

@Path("/musica")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class MusicaFacadeImpl implements MusicaFacade {

	@Inject
	private MusicaDao musicaDao;
	
	
	@Override
	@GET
	public List<Musica> getMusicas() {
		return musicaDao.getMusicas(new Musica());
	}

	@Override
	@GET
	@Path("/{codigo}")
	public List<Musica> getMusicas(@PathParam("codigo") Integer codigo) {
		Musica musica = new Musica();
		musica.setCodigo(codigo);
		return musicaDao.getMusicas(musica);
	}
	
	
	@Override
	@POST 
	public Musica salvar(Musica musica) { 
		musica = musicaDao.salvar(musica);
	 	return musica;
	}
	
	@Override
	@PUT 
	public void atualizar(Musica musica) { 
		musicaDao.atualizar(musica);
	}

	@Override
	@DELETE
	@Path("/{codigo}")
	public void deletarMusica(@PathParam("codigo") Integer codigo) {
		Musica musica = new Musica();
		musica.setCodigo(codigo);
		musicaDao.excluir(musica);
	}

}
