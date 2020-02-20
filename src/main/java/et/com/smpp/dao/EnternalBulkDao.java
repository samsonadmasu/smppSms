package et.com.smpp.dao;

import et.com.smpp.model.EnternalBulk;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * DAO for EnternalBulk
 */
@Stateless
public class EnternalBulkDao {
	@PersistenceContext(unitName = "smppSms-persistence-unit")
	private EntityManager em;

	public void create(EnternalBulk entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		EnternalBulk entity = em.find(EnternalBulk.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public EnternalBulk findById(Long id) {
		return em.find(EnternalBulk.class, id);
	}

	public EnternalBulk update(EnternalBulk entity) {
		return em.merge(entity);
	}

	public List<EnternalBulk> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<EnternalBulk> findAllQuery = em.createQuery(
				"SELECT DISTINCT e FROM EnternalBulk e ORDER BY e.id",
				EnternalBulk.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
