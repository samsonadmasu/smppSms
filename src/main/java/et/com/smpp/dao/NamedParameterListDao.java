package et.com.smpp.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import et.com.smpp.model.NamedParameterList;

/**
 * DAO for NamedParameterList
 */
@Stateless
public class NamedParameterListDao {
	@PersistenceContext(unitName = "smppSms-persistence-unit")
	private EntityManager em;

	public void create(NamedParameterList entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		NamedParameterList entity = em.find(NamedParameterList.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public NamedParameterList findById(Long id) {
		return em.find(NamedParameterList.class, id);
	}

	public NamedParameterList update(NamedParameterList entity) {
		return em.merge(entity);
	}

	public List<NamedParameterList> listAll(Integer startPosition,
			Integer maxResult) {
		TypedQuery<NamedParameterList> findAllQuery = em.createQuery(
				"SELECT DISTINCT n FROM NamedParameterList n ORDER BY n.id",
				NamedParameterList.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
