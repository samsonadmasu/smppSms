package com.cassiomolin.user.service;

import com.cassiomolin.user.domain.User;

import et.com.smpp.dao.PasswordhistoryDao;
import et.com.smpp.dao.StaffDao;
import et.com.smpp.model.Passwordhistory;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Service that provides operations for {@link User}s.
 *
 * @author cassiomolin
 */
@ApplicationScoped
public class UserService {
    @EJB
    StaffDao staffDao;
    @EJB
    PasswordhistoryDao passwordhistoryDao;


    @PersistenceContext(unitName = "smppSms-persistence-unit", type = PersistenceContextType.TRANSACTION)
    private EntityManager em;

    /**
     * Find a user by username or email.
     *
     * @param identifier
     * @return
     */
    public User findByUsernameOrEmail(String identifier) {
        List<User> users = em.createQuery("SELECT u FROM User u WHERE u.username = :identifier", User.class)
                .setParameter("identifier", identifier)
                .setMaxResults(1)
                .getResultList();
        if (users.isEmpty()) {
            return null;
        }
        return users.get(0);
    }


    /**
     * Find all users.
     *
     * @return
     */
    public List<User> findAll() {
        return em.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    /**
     * Find a user by id.
     *
     * @param userId
     * @return
     */
    public Optional<User> findById(Long userId) {
        return Optional.ofNullable(em.find(User.class, userId));
    }

    @Transactional
    public User userActiveDeactive(boolean active, long id) {


        String staffName = staffDao.findById(id).getUserName();

        List<User> users = em.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class)
                .setParameter("username", staffName)
                .setMaxResults(1)
                .getResultList();
        if (users.isEmpty()) {

            return null;
        } else {
            users.get(0).setActive(active);
            em.merge(users.get(0));
            return users.get(0);

        }
    }

    public boolean resetPassword(String username, String newPasswordAsh) {

        List<User> users = em.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class)
                .setParameter("username", username)
                .setMaxResults(1)
                .getResultList();
        if (users.isEmpty()) {
            return false;
        } else {
            users.get(0).setPassword(newPasswordAsh);

            em.merge(users.get(0));
            return true;
        }

    }

    public boolean isPasswordChanged(User user) {
        String userPassword = user.getPassword();
        Passwordhistory passwordHistory = this.passwordhistoryDao.findUser(user.getStaffId());
        return !userPassword.equals(passwordHistory.getPassword());

    }

}
