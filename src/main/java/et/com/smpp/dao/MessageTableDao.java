package et.com.smpp.dao;

import et.com.smpp.model.BulkMessage;
import et.com.smpp.model.MessageTable;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * DAO for MessageTable
 * Samson Admasu
 */
@Stateless
public class MessageTableDao {
	@PersistenceContext(unitName = "smppSms-persistence-unit")
	private EntityManager em;

	public void create(MessageTable entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		MessageTable entity = em.find(MessageTable.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public MessageTable findById(Long id) {
		return em.find(MessageTable.class, id);
	}

	public MessageTable update(MessageTable entity) {
		return em.merge(entity);
	}

	public MessageTable findByCatagoryId(long id){
		List<MessageTable> bankconfirmations = em
				.createQuery(
						"SELECT DISTINCT s FROM MessageTable s Where s.catagoryTable.id = :id",
						MessageTable.class)
				.setParameter("id",id)
				.getResultList();
		if (!bankconfirmations.isEmpty()){
			return bankconfirmations.get(0);
		}
		return null;
	}

	public List<MessageTable> FindMessageByCatagoryID(Long id){
		TypedQuery<MessageTable> findAllQuery = em.createQuery("SELECT DISTINCT h FROM MessageTable h where h.catagoryTable.id = :id", MessageTable.class);
		findAllQuery.setParameter("id", id);
		return findAllQuery.getResultList();
	}


	public List<MessageTable> listAll() {
		TypedQuery<MessageTable> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT m FROM MessageTable m",
						MessageTable.class);
		return findAllQuery.getResultList();
	}
}
