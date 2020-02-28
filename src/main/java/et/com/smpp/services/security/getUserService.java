package et.com.smpp.services.security;

import com.cassiomolin.security.service.PasswordEncoder;
import com.cassiomolin.user.service.UserService;
import et.com.smpp.OutDTOs.OutStaffDTO;
import et.com.smpp.dao.PasswordhistoryDao;
import et.com.smpp.dao.RoleDao;
import et.com.smpp.dao.StaffDao;
import et.com.smpp.model.Staff;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class getUserService {
    @PersistenceContext(unitName = "smppSms-persistence-unit")
    private EntityManager em;

    @Inject
    private PasswordEncoder passwordEncoder;

    @Inject
    private UserService userService;

    @EJB
    private RoleDao roleDao;

    @EJB
    StaffDao staffDao;

    @EJB
    private PasswordhistoryDao passwordhistoryDao;



}
