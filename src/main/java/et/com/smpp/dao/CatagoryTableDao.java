package et.com.smpp.dao;

import et.com.smpp.model.CatagoryTable;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * DAO for CatagoryTable
 */


@Stateless
public class CatagoryTableDao {
	@PersistenceContext(unitName = "smppSms-persistence-unit")
	private EntityManager em;

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void create(CatagoryTable entity) {
		em.persist(entity);
	}

	public void createResent(CatagoryTable entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		CatagoryTable entity = em.find(CatagoryTable.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public CatagoryTable findById(Long id) {
		return em.find(CatagoryTable.class, id);
	}

	public CatagoryTable update(CatagoryTable entity) {
		return em.merge(entity);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public CatagoryTable updateResend(CatagoryTable entity) {
		return em.merge(entity);
	}




	public CatagoryTable findByMessage(String representative){
		List<CatagoryTable> CatagoryTable =  em.createQuery("SELECT DISTINCT c FROM CatagoryTable c WHERE c.representative  = :representative", CatagoryTable.class)
				.setParameter("representative", representative)
				.getResultList();

		if(!CatagoryTable.isEmpty()){
			return CatagoryTable.get(0);
		}
		return null;
	}

	public List<CatagoryTable> findByCurrentStatus(){

		List<CatagoryTable> CatagoryTable =  em.createQuery("SELECT DISTINCT c FROM CatagoryTable c where c.currentActive = true", CatagoryTable.class)
				.getResultList();


			return CatagoryTable;

	}





	public List<CatagoryTable> findByStatus(){
		TypedQuery<CatagoryTable> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT c FROM CatagoryTable c where c.status = true",
						CatagoryTable.class);
		return findAllQuery.getResultList();
	}



	public List<CatagoryTable> listAll() {
		TypedQuery<CatagoryTable> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT c FROM CatagoryTable c",
						CatagoryTable.class);
		return findAllQuery.getResultList();
	}

}
