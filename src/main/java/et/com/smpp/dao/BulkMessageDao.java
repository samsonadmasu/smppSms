package et.com.smpp.dao;

import et.com.smpp.model.BulkMessage;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
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

	@TransactionAttribute(value = TransactionAttributeType.REQUIRES_NEW)
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

	@TransactionAttribute(value = TransactionAttributeType.REQUIRES_NEW)
	public BulkMessage update(BulkMessage entity) {
		return em.merge(entity);
	}

	public BulkMessage updateBulk(BulkMessage entity) {
		return em.merge(entity);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public List<BulkMessage> sendall(long id){

		TypedQuery<BulkMessage> findAllQuery = em.createQuery("SELECT DISTINCT h FROM BulkMessage h where h.sentStatus = false and h.catagory = :id AND date(h.sentTime) = date(:date) ", BulkMessage.class);
		findAllQuery.setParameter("id", id)
				.setParameter("date", new Date());
		return findAllQuery.getResultList();
	}


	//"SELECT DISTINCT t FROM Attendance t  " +
	//                                " where t.customer.id =: studentId and " +
	//                                " date(t.date) = date(:date) " +
	//                                "ORDER BY t.id",


	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public List<BulkMessage> sendBulk(){
		TypedQuery<BulkMessage> findAllQuery = em.createQuery("SELECT DISTINCT h FROM BulkMessage h where h.sentStatus = false AND date(h.sentTime) = date(:date)", BulkMessage.class);
		findAllQuery.setParameter("date", new Date());
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
	//    Date date = new Date();
	    TypedQuery<BulkMessage> findAllQuery = em.createQuery("SELECT DISTINCT h FROM BulkMessage h where h.catagory =:catagory AND h.sentStatus = false AND date(h.sentTime) = date(:date)", BulkMessage.class);
         findAllQuery.setParameter("catagory", catagory);
		findAllQuery.setParameter("date", new Date());

	    return findAllQuery.getResultList().size();
	}


	public List<BulkMessage> prepareForSend(long id){
		TypedQuery<BulkMessage> findAllQuery = em.createQuery("SELECT DISTINCT h FROM BulkMessage h where h.send = false and h.send= false AND h.catagory =:id", BulkMessage.class);
		findAllQuery.setParameter("id", id);
		return findAllQuery.getResultList();
	}

	public List<BulkMessage> prepareForSendExternalInternal(){
		TypedQuery<BulkMessage> findAllQuery = em.createQuery("SELECT DISTINCT h FROM BulkMessage h where h.send = false", BulkMessage.class);
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
