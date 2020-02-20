package et.com.smpp.services.AdminServices;

import et.com.smpp.InDTOs.*;
import et.com.smpp.dao.*;
import et.com.smpp.model.CatagoryTable;
import et.com.smpp.model.MessageTable;
import et.com.smpp.model.Staff;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UpdateAdminServices {
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
    @PersistenceContext(unitName = "smppSms-persistence-unit")
    private EntityManager em;

    public InUpdateCatagoryDTO updateCatagory(InUpdateCatagoryDTO inUpdateCatagoryDto) {

        CatagoryTable CatagoryTable = this.CatagoryTableDao.findById(inUpdateCatagoryDto.getId());
        CatagoryTable.setCatagoryName(inUpdateCatagoryDto.getCatagoryName());
        CatagoryTable.setRepresentative(inUpdateCatagoryDto.getRepresentative());

        this.CatagoryTableDao.update(CatagoryTable);
        return inUpdateCatagoryDto;
    }

    public InUpdateMessageDTO updaterMessage(InUpdateMessageDTO inUpdateMessageDto) {
      //  CatagoryTable CatagoryTable = this.CatagoryTableDao.findById(inUpdateMessageDto.getCatagoryTable());
        MessageTable messagetable = this.messagetableDao.findById(inUpdateMessageDto.getId());

    //    messagetable.setCatagoryTable(CatagoryTable);
        messagetable.setMessage(inUpdateMessageDto.getMessage());
         this.messagetableDao.update(messagetable);
        return inUpdateMessageDto;
    }

    public InUpdateStaffDTO updaterStaff(InUpdateStaffDTO inUpdateStaffDto) {
        Staff staff = this.staffDao.findById(inUpdateStaffDto.getId());

        staff.setUserName(inUpdateStaffDto.getUserName());
        staff.setFirstName(inUpdateStaffDto.getFirstName());
        staff.setLastName(inUpdateStaffDto.getLastName());
        staff.setPassword(inUpdateStaffDto.getPassword());
        staff.setPhoneNumber(inUpdateStaffDto.getPhoneNumber());
        staff.setEmail(inUpdateStaffDto.getEmail());
        staff.setStaffStatus(inUpdateStaffDto.isStaffStatus());
        this.staffDao.update(staff);
        return inUpdateStaffDto;
    }



}
