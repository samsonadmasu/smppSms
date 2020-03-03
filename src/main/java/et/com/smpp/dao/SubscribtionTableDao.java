package et.com.smpp.dao;

import et.com.smpp.model.SubscribtionTable;



import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

/**
 * DAO for SubscribtionTable
 */
@Stateless
public class SubscribtionTableDao {
	@PersistenceContext(unitName = "smppSms-persistence-unit")
	private EntityManager em;

	public void create(SubscribtionTable entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		SubscribtionTable entity = em.find(SubscribtionTable.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public SubscribtionTable findById(Long id) {
		return em.find(SubscribtionTable.class, id);
	}

	public SubscribtionTable update(SubscribtionTable entity) {
		return em.merge(entity);
	}

	public List<SubscribtionTable> findByCatagoryId(Long id){
		TypedQuery<SubscribtionTable> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT s FROM SubscribtionTable s where s.catagoryTable.id = :id AND s.status = true AND s.catagoryTable.catagoryStatus = true",
						SubscribtionTable.class);
		findAllQuery.setParameter("id", id);
		return findAllQuery.getResultList();
	}
//findByPhoneMessage

	public int findByPhoneMessage(String phoneNumber, Long id){
		TypedQuery<SubscribtionTable> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT s FROM SubscribtionTable s where s.phoneNumber = :phoneNumber and s.catagoryTable.id = :id and s.status = true",
						SubscribtionTable.class);
		findAllQuery.setParameter("phoneNumber", phoneNumber);
		findAllQuery.setParameter("id", id);
		return findAllQuery.getResultList().size();
	}

	public List<SubscribtionTable> findByCatagoryInternalBulk(){
		TypedQuery<SubscribtionTable> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT s FROM SubscribtionTable s where s.status = false",
						SubscribtionTable.class);
		return findAllQuery.getResultList();
	}

	public List<SubscribtionTable> listAllActive() {
		TypedQuery<SubscribtionTable> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT s FROM SubscribtionTable s Where s.status = TRUE",
						SubscribtionTable.class);
		return findAllQuery.getResultList();
	}

	public List<SubscribtionTable> listAllDeactive() {
		TypedQuery<SubscribtionTable> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT s FROM SubscribtionTable s Where s.status = false",
						SubscribtionTable.class);
		return findAllQuery.getResultList();
	}


	//findByPhone
	public List<SubscribtionTable> findByPhone(String phoneNumber) {
		TypedQuery<SubscribtionTable> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT s FROM SubscribtionTable s Where s.phoneNumber = :phoneNumber",
						SubscribtionTable.class);
		findAllQuery.setParameter("phoneNumber", phoneNumber);
		return findAllQuery.getResultList();
	}


	// Dailly
	public Integer countSubscribersDailyByCatagory(Long id){
		Query findAllQuery = em.createQuery("SELECT DISTINCT h FROM SubscribtionTable h Where h.status = TRUE AND h.currDate = CURRENT_DATE() AND  h.catagoryTable.id = :id", SubscribtionTable.class);
		findAllQuery.setParameter("id", id);
		return findAllQuery.getResultList().size();
	}

	public Integer countSubscribersDailyAll(){
		Query findAllQuery = em.createQuery("SELECT DISTINCT h FROM SubscribtionTable h Where h.status = TRUE and h.currDate = CURRENT_DATE()", SubscribtionTable.class);
		return findAllQuery.getResultList().size();
	}


// all rounded
	//SELECT e FROM Events e WHERE e.eventsDate BETWEEN :startDate AND :endDate

	public Long countSubscribersBetweenAll(Date startDate, Date endDate){
		return em.createQuery("SELECT count(h) FROM SubscribtionTable h Where h.status = TRUE AND h.currDate BETWEEN :startDate AND :endDate", Long.class)
				.setParameter("startDate", startDate)
				.setParameter("endDate", endDate)
				.getSingleResult();
	}


	//select count(m.enterprise) from Member m where m.enterprise.id=:id and m.age between :min and :max

	public Long countSubscribersBetweenByCatagory(Date startDate, Date endDate, Long id){
		return em.createQuery("SELECT count(h) FROM SubscribtionTable h Where h.status = TRUE AND h.currDate BETWEEN :startDate AND :endDate AND h.catagoryTable.id = :id", Long.class)
				.setParameter("id", id)
				.setParameter("startDate", startDate)
				.setParameter("endDate", endDate)
				.getSingleResult();
	}

	//@Query("select e from MyEntity e where year(e.createdAt) = year(current_date) and  month(e.createdAt) = month(current_date)")
	//List<MyEntity> getAllOfCurrentMonth();

	//month
	public Integer countSubscribersmonthlyAll(){
		Query findAllQuery = em.createQuery("SELECT DISTINCT h FROM SubscribtionTable h Where h.status = TRUE AND year(h.currDate) = year(current_date ) and month(h.currDate) = month(current_date )", SubscribtionTable.class);
		return findAllQuery.getResultList().size();
	}

	public Integer countSubscribersMonthByCatagory(Long id){
		Query findAllQuery = em.createQuery("SELECT DISTINCT h FROM SubscribtionTable h Where h.status = TRUE AND year(h.currDate) = year(current_date ) and month(h.currDate) = month(current_date ) AND h.catagoryTable.id = :id", SubscribtionTable.class);
		findAllQuery.setParameter("id", id);
		return findAllQuery.getResultList().size();
	}

	//year

	public Integer countSubscribersYearlybyCatagory(Long id){
		Query findAllQuery = em.createQuery("SELECT DISTINCT h FROM SubscribtionTable h Where h.status = TRUE AND year(h.currDate) = year(current_date ) AND h.catagoryTable.id = :id", SubscribtionTable.class);
		findAllQuery.setParameter("id", id);
		return findAllQuery.getResultList().size();
	}


	public Integer countSubscribersYearlyAll(){
		Query findAllQuery = em.createQuery("SELECT DISTINCT h FROM SubscribtionTable h Where h.status = TRUE AND year(h.currDate) = year(current_date )", SubscribtionTable.class);
		return findAllQuery.getResultList().size();
	}


	//all
	public Integer countSubscribersAllByCatagory(Long id){
		Query findAllQuery = em.createQuery("SELECT DISTINCT h FROM SubscribtionTable h Where h.status = TRUE AND h.catagoryTable.id = :id", SubscribtionTable.class);
		findAllQuery.setParameter("id", id);
		return findAllQuery.getResultList().size();
	}

	public Integer countSubscribersALL(){
		Query findAllQuery = em.createQuery("SELECT DISTINCT h FROM SubscribtionTable h Where h.status = TRUE ", SubscribtionTable.class);
		return findAllQuery.getResultList().size();
	}

}
