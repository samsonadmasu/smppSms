package et.com.smpp.services.AdminServices;

import et.com.smpp.InDTOs.*;
import et.com.smpp.InDTOs.subscription.InMessageTestDTO;
import et.com.smpp.dao.*;
import et.com.smpp.model.*;
import et.com.smpp.services.security.AuthRegisterServices;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;

@Stateless
public class AdminRegisterServices {
    @EJB
    BulkMessageDao BulkMessageDao;

    @EJB
    CatagoryTableDao CatagoryTableDao;

    @EJB
    MessageTableDao messagetableDao;

    @EJB
    SubscribtionTableDao subscribtiontableDao;

    @EJB
    RoleDao roleDao;

    @EJB
    StaffDao staffDao;

    @EJB
    MessageTestDao messageTestDao;

    @Inject
    AuthRegisterServices authRegisterServices;

@EJB
InternalBulkDao internalBulkDao;


@PersistenceContext(unitName = "smppSms-persistence-unit")
    private EntityManager em;

    public InRegisterCatagoryDTO RegisterCatagory(InRegisterCatagoryDTO inRegisterCatagoryDto) {

            CatagoryTable catagoryTable = new CatagoryTable();

            catagoryTable.setCatagoryName(inRegisterCatagoryDto.getCatagoryName());
            catagoryTable.setRepresentative(inRegisterCatagoryDto.getRepresentative());
            catagoryTable.setStatus(false);
            catagoryTable.setCurrentActive(false);

            CatagoryTableDao.create(catagoryTable);
            inRegisterCatagoryDto.setId(catagoryTable.getId());
            return inRegisterCatagoryDto;
    }


    public InRegisterInternalBulkDTO RegisterInternalBulk(InRegisterInternalBulkDTO inRegisterInternalBulkDTO) {

        InternalBulk internalBulk = new InternalBulk();
        internalBulk.setMessage(inRegisterInternalBulkDTO.getMessage());
        internalBulk.setPreparedStatus(false);
        internalBulkDao.create(internalBulk);

        inRegisterInternalBulkDTO.setId(internalBulk.getId());
        return inRegisterInternalBulkDTO;
    }




    public InMessageTestDTO registerTest(InMessageTestDTO inMessageTestDTO){

        MessageTest messageTest = new MessageTest();
        messageTest.setCatagoryId(inMessageTestDTO.getCatagoryTable());
        messageTest.setMessage(inMessageTestDTO.getMessage());
        messageTest.setCurrDate(new Date());
        this.messageTestDao.create(messageTest);
        return inMessageTestDTO;
    }

    public InMessageRegisterDTO RegisterMessage(InMessageRegisterDTO inMessageRegisterDto) {

        CatagoryTable CatagoryTable = this.CatagoryTableDao.findById(inMessageRegisterDto.getCatagoryTable());
        MessageTable messagetable = new MessageTable();
        messagetable.setCatagoryTable(CatagoryTable);
        messagetable.setMessage(inMessageRegisterDto.getMessage());
        messagetable.setCurrDate(new Date());
        this.messagetableDao.create(messagetable);
        return inMessageRegisterDto;
    }

    public InRegisterStaffDTO RegisterStaff(InRegisterStaffDTO inRegisterStaffDto) {


        Role role = this.roleDao.findById(inRegisterStaffDto.getRole());
         Staff staff = new Staff();

         staff.setFirstName(inRegisterStaffDto.getFirstName());
         staff.setLastName(inRegisterStaffDto.getLastName());
         staff.setUserName(inRegisterStaffDto.getUserName());
         staff.setEmail(inRegisterStaffDto.getEmail());
         staff.setPassword(inRegisterStaffDto.getPassword());
         staff.setPhoneNumber(inRegisterStaffDto.getPhoneNumber());
         staff.setRole(role);
         staff.setStaffStatus(true);
//        if(inRegisterStaffDto.isRegistrationStatus()){
//
//            }
//
//         //registerStaffToAuto
//        this.staffDao.create(staff);
//
        return inRegisterStaffDto;
    }

    public InRegisterRoleDTO RegisterRole(InRegisterRoleDTO inRegisterRoleDto) {

      Role role = new Role();
        role.setRoleName(inRegisterRoleDto.getRoleName());
        this.roleDao.create(role);

        return inRegisterRoleDto;
    }
}
