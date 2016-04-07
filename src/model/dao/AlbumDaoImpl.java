package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.domain.Album;

public class AlbumDaoImpl implements AlbumDao {
	
	@PersistenceContext(unitName="AlbumDeAlbums")
	private EntityManager entityManager;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Album> getAlbums(Album album) {
		StringBuffer hql = new StringBuffer("from album a"
				+ " where 1 = 1");		
		if (album.getNumero() != null) {
			hql.append(" and a.codigo = :codigo");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (album.getNumero() != null) {
			query.setParameter("codigo",album.getNumero());
		} 
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public void excluir(Album album) {
		album = entityManager.merge(album);
		entityManager.remove(album);
	}

	@Override
	@Transactional
	public Album salvar(Album album) {
		entityManager.persist(album);
		return album;
	}

	@Override
	@Transactional
	public void atualizar(Album album) {
		album = entityManager.merge(album);
	}
	

}
