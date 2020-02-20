package et.com.smpp.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import et.com.smpp.model.SubscribtionTable;
import et.com.smpp.model.SyncOrderRelationDump;

/**
 * DAO for SyncOrderRelationDump
 */
@Stateless
public class SyncOrderRelationDumpDao {
	@PersistenceContext(unitName = "smppSms-persistence-unit")
	private EntityManager em;

	public void create(SyncOrderRelationDump entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		SyncOrderRelationDump entity = em.find(SyncOrderRelationDump.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public SyncOrderRelationDump findById(Long id) {
		return em.find(SyncOrderRelationDump.class, id);
	}

	public SyncOrderRelationDump update(SyncOrderRelationDump entity) {
		return em.merge(entity);
	}


	public List<SubscribtionTable> NotChoosee(){

		TypedQuery<SubscribtionTable> findAllQuery = em.createQuery(
				"SELECT phoneNumber from SubscribtionTable a",
				SubscribtionTable.class);
		return findAllQuery.getResultList();
	}

	public List<SyncOrderRelationDump> NotChoose(){

		TypedQuery<SyncOrderRelationDump> findAllQuery = em.createQuery(
				"SELECT DISTINCT s FROM SyncOrderRelationDump s where s.userId NOT IN (SELECT a.phoneNumber from SubscribtionTable a)",
				SyncOrderRelationDump.class);
		return findAllQuery.getResultList();
	}

	//select userId from SyncOrderRelationDump where userId NOT IN(select phoneNumber from subscribtionTable);

	public List<SyncOrderRelationDump> listAll(Integer startPosition,
			Integer maxResult) {
		TypedQuery<SyncOrderRelationDump> findAllQuery = em.createQuery(
				"SELECT DISTINCT s FROM SyncOrderRelationDump s ORDER BY s.id",
				SyncOrderRelationDump.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
