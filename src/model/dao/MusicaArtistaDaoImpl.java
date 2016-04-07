package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.domain.MusicaArtista;

public class MusicaArtistaDaoImpl implements MusicaArtistaDao {
	
	@PersistenceContext(unitName="AlbumDeMusicaArtistas")
	private EntityManager entityManager;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<MusicaArtista> getMusicaArtistas(MusicaArtista musicaartista) {
		StringBuffer hql = new StringBuffer("from musicaartista a"
				+ " where 1 = 1");		
		if (musicaartista.getCodigo() != null) {
			hql.append(" and a.codigo = :codigo");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (musicaartista.getCodigo() != null) {
			query.setParameter("codigo",musicaartista.getCodigo());
		} 
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public void excluir(MusicaArtista musicaartista) {
		musicaartista = entityManager.merge(musicaartista);
		entityManager.remove(musicaartista);
	}

	@Override
	@Transactional
	public MusicaArtista salvar(MusicaArtista musicaartista) {
		entityManager.persist(musicaartista);
		return musicaartista;
	}

	@Override
	@Transactional
	public void atualizar(MusicaArtista musicaartista) {
		musicaartista = entityManager.merge(musicaartista);
		entityManager.persist(musicaartista);		
	}
	

}
