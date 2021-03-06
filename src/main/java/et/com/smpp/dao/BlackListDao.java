package et.com.smpp.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import et.com.smpp.model.BlackList;
import et.com.smpp.model.BulkMessage;

/**
 * DAO for BlackList
 */
@Stateless
public class BlackListDao {
	@PersistenceContext(unitName = "smppSms-persistence-unit")
	private EntityManager em;

	public void create(BlackList entity) {
		em.persist(entity);
	}

	public BlackList deleteById(Long id) {
		BlackList entity = em.find(BlackList.class, id);
		if (entity != null) {
			em.remove(entity);
		}
		return entity;
	}

	public BlackList findById(Long id) {
		return em.find(BlackList.class, id);
	}

	public BlackList update(BlackList entity) {
		return em.merge(entity);
	}



	public List<BlackList> serachBlackList(String phoneNumber){
		TypedQuery<BlackList> findAllQuery = em.createQuery("SELECT DISTINCT h FROM BlackList h where h.phoneNumber = :phoneNumber", BlackList.class);
		findAllQuery.setParameter("phoneNumber", phoneNumber);
		return findAllQuery.getResultList();
	}



	public List<BlackList> listAll() {
		TypedQuery<BlackList> findAllQuery = em.createQuery(
				"SELECT DISTINCT b FROM BlackList b ORDER BY b.id",
				BlackList.class);
			return findAllQuery.getResultList();
	}
}
