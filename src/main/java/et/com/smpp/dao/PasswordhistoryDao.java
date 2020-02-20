package et.com.smpp.dao;

import et.com.smpp.model.Passwordhistory;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * DAO for Passwordhistory
 */
@Stateless
public class PasswordhistoryDao {
	@PersistenceContext(unitName = "smppSms-persistence-unit")
	private EntityManager em;

	public void create(Passwordhistory entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		Passwordhistory entity = em.find(Passwordhistory.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public Passwordhistory findById(Long id) {
		return em.find(Passwordhistory.class, id);
	}

	public Passwordhistory update(Passwordhistory entity) {
		return em.merge(entity);
	}


	@SuppressWarnings("unchecked")
	public Passwordhistory findUser(Long staffId) {
		Query findAllQuery = em.createQuery("SELECT p FROM passwordhistory p WHERE p.staffId = :staffId", Passwordhistory.class);
		findAllQuery.setParameter("staffId", staffId);
		List<Passwordhistory> result = findAllQuery.getResultList();
		return result.isEmpty() ? null : result.get(0);
	}

	public List<Passwordhistory> listAll(Integer startPosition,
			Integer maxResult) {
		TypedQuery<Passwordhistory> findAllQuery = em.createQuery(
				"SELECT DISTINCT p FROM Passwordhistory p ORDER BY p.id",
				Passwordhistory.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
