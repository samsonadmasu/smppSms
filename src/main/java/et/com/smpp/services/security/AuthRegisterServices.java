package et.com.smpp.services.security;

import com.cassiomolin.security.domain.Authority;
import com.cassiomolin.security.service.PasswordEncoder;
import com.cassiomolin.user.domain.User;
import com.cassiomolin.user.service.UserService;

import et.com.smpp.InDTOs.InRegisterStaffDTO;
import et.com.smpp.dao.PasswordhistoryDao;
import et.com.smpp.dao.RoleDao;
import et.com.smpp.model.Passwordhistory;
import et.com.smpp.model.Role;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.EnumSet;


@Stateless
public class AuthRegisterServices {

    @PersistenceContext(unitName = "smppSms-persistence-unit")
    private EntityManager em;

    @Inject
    private PasswordEncoder passwordEncoder;

    @Inject
    private UserService userService;

    @EJB
    private RoleDao roleDao;

    @EJB
    private PasswordhistoryDao passwordhistoryDao;

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public InRegisterStaffDTO registeStaffToAuth(InRegisterStaffDTO staffRegisterDTO) {
        staffRegisterDTO = this.isUserNameAndEmailUnque(staffRegisterDTO);
        if (staffRegisterDTO.isRegistrationStatus()) {
            try {
                registerStaffToAuto(staffRegisterDTO);
                return staffRegisterDTO;
            } catch (Exception e) {
                return null;
            }
        } else
            System.out.println("++++++++++++++++++++++++++++++++ Else reached");
        return staffRegisterDTO;
    }


    private void registerStaffToAuto(InRegisterStaffDTO staffRegisterDTO) {
        Long roleId = staffRegisterDTO.getRole();
        Role role = this.roleDao.findById(roleId);
        EnumSet<Authority> authorities = null;
        switch (role.getRoleName()) {
            case "User":
                authorities = EnumSet.of(Authority.User);
                break;
        }
        if (authorities != null) {
            User user = registerUser(staffRegisterDTO, authorities);
            registerPasswordHistory(staffRegisterDTO, user);
        }

    }

    private User registerUser(InRegisterStaffDTO staffRegisterDTO, EnumSet<Authority> authorities) {
        User user = new User();
        String hashedPwd = this.passwordEncoder.hashPassword(staffRegisterDTO.getPassword());
        user.setPassword(hashedPwd);
        user.setUsername(staffRegisterDTO.getUserName());
        user.setStaffId(staffRegisterDTO.getId());
        user.setActive(true);
        user.setAuthorities(authorities);
        this.em.persist(user);
        return user;
    }


    private void registerPasswordHistory(InRegisterStaffDTO staffRegisterDTO, User user) {
        Passwordhistory passwordHistory = new Passwordhistory();
        passwordHistory.setStaffId(staffRegisterDTO.getId());
        passwordHistory.setPassword(user.getPassword());
        passwordHistory.setCreatedOn(new Date());
        this.passwordhistoryDao.create(passwordHistory);
    }


    public InRegisterStaffDTO isUserNameAndEmailUnque(InRegisterStaffDTO staffRegisterDTO) {

        //User userWithIdenticalEmail = this.userService.findByUsernameOrEmail(staffRegisterDTO.getEmail());
        User userWithIdenticalUserName = this.userService.findByUsernameOrEmail(staffRegisterDTO.getUserName());
        if ((userWithIdenticalUserName == null)) {
            staffRegisterDTO.setRegistrationStatus(true);
            staffRegisterDTO.setMessage("registration is  successful!");

            return staffRegisterDTO;
        } else {

            staffRegisterDTO.setRegistrationStatus(false);
            staffRegisterDTO.setMessage("username is already been taken , registration is not successful! ");

            return staffRegisterDTO;
        }

    }

  }


