package model.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import model.dao.MusicaDao;
import model.domain.Musica;
import model.facade.MusicaFacade;

@WebService(serviceName="ws/musica")
public class MusicaFacadeImpl implements MusicaFacade {
	
	@Inject
	private MusicaDao musicaDao;
			
	@WebMethod
	public List<Musica> getMusicas() {
		return musicaDao.getMusicas(new Musica());
	}
	
	@Override
	@WebMethod(operationName="getMusicaCodigo")
	public List<Musica> getMusicas(@WebParam(name="codigoMusica") 
							Integer codigo) {
		Musica musica = new Musica();
		musica.setCodigo(codigo);
		return musicaDao.getMusicas(musica);
	}
	
	@WebMethod
	public Musica salvar(@WebParam(name="musica") Musica musica) {
		return musicaDao.salvar(musica);
	}
	
	@WebMethod
	public void atualizar(@WebParam(name="musica") Musica musica) {
		musicaDao.atualizar(musica);
	}
	
	@WebMethod
	public void deletarMusica(@WebParam(name="codigoMusica") Integer codigo) {
		Musica musica = new Musica();
		musica.setCodigo(codigo);
		musicaDao.excluir(musica);
	}

	

	



}
