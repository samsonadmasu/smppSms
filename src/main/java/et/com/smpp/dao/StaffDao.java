package et.com.smpp.dao;

import et.com.smpp.model.CatagoryTable;
import et.com.smpp.model.Staff;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * DAO for Staff
 */
@Stateless
public class StaffDao {
	@PersistenceContext(unitName = "smppSms-persistence-unit")
	private EntityManager em;

	public void create(Staff entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		Staff entity = em.find(Staff.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public Staff findById(Long id) {
		return em.find(Staff.class, id);
	}

	public Staff update(Staff entity) {
		return em.merge(entity);
	}

	public Staff findbyUserName(String userName){
		List<Staff> staff =  em.createQuery("SELECT DISTINCT c FROM Staff c WHERE c.userName = :userName", Staff.class)
				.setParameter("userName", userName)
				.getResultList();

		if(!staff.isEmpty()){
			return staff.get(0);
		}
		return null;
	}

	public List<Staff> listAll() {
		TypedQuery<Staff> findAllQuery = em
				.createQuery(
						"SELECT DISTINCT s FROM Staff s LEFT JOIN FETCH s.role ORDER BY s.id",
						Staff.class);
			return findAllQuery.getResultList();
	}
}
