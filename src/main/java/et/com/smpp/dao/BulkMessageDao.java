package et.com.smpp.dao;

import et.com.smpp.model.BulkMessage;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * DAO for BulkMessage
 */
@Stateless
public class BulkMessageDao {
	@PersistenceContext(unitName = "smppSms-persistence-unit")
	private EntityManager em;

	public void create(BulkMessage entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		BulkMessage entity = em.find(BulkMessage.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public BulkMessage findById(Long id) {
		return em.find(BulkMessage.class, id);
	}

	public BulkMessage update(BulkMessage entity) {
		return em.merge(entity);
	}


	public List<BulkMessage> sendall(){
		TypedQuery<BulkMessage> findAllQuery = em.createQuery("SELECT DISTINCT h FROM BulkMessage h where h.sentStatus = false and h.send = true", BulkMessage.class);
		return findAllQuery.getResultList();
	}


	public List<BulkMessage> ethioTelLogListOut(String phoneNumber){
		TypedQuery<BulkMessage> findAllQuery = em.createQuery("SELECT DISTINCT h FROM BulkMessage h where h.phoneNumber = :phoneNumber", BulkMessage.class);
		findAllQuery.setParameter("phoneNumber", phoneNumber);
		return findAllQuery.getResultList();
	}



	public boolean fbPhoneMessage(String messageBody, String phoneNumber){
		List<BulkMessage> bankconfirmations =  em.createQuery("SELECT DISTINCT h FROM BulkMessage h WHERE h.messageBody = :messageBody AND h.phoneNumber = :phoneNumber", BulkMessage.class)
				.setParameter("messageBody", messageBody)
				.setParameter("phoneNumber", phoneNumber)
				.getResultList();

		if (!bankconfirmations.isEmpty()){
			return false;
		}
		return true;
	}


    public int listCatagoryandCount(long catagory){
	    Date date = new Date();
	    TypedQuery<BulkMessage> findAllQuery = em.createQuery("SELECT DISTINCT h FROM BulkMessage h where h.catagory =:id AND h.sentStatus = false AND h.sentTime=:date", BulkMessage.class);
         findAllQuery.setParameter("catagory", catagory);
         findAllQuery.setParameter("date", date);

	    return findAllQuery.getResultList().size();
	}


	public List<BulkMessage> prepareForSend(){
		TypedQuery<BulkMessage> findAllQuery = em.createQuery("SELECT DISTINCT h FROM BulkMessage h where h.send = false ", BulkMessage.class);
		return findAllQuery.getResultList();
	}

	public List<BulkMessage> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<BulkMessage> findAllQuery = em.createQuery(
				"SELECT DISTINCT b FROM BulkMessage b ",
				BulkMessage.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
