package et.com.smpp.services.AdminServices;

import et.com.smpp.DeleteDTO.DeleteFromBlacklistDTO;
import et.com.smpp.InDTOs.*;
import et.com.smpp.OutDTOs.OutUpdateCatagoryStatusDTO;
import et.com.smpp.OutDTOs.ResponseMessageDTO;
import et.com.smpp.dao.*;
import et.com.smpp.model.*;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;

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


    @EJB
    InternalBulkDao internalBulkDao;

    @EJB
    BlackListDao blackListDao;

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

        MessageTable messagetable = this.messagetableDao.findById(inUpdateMessageDto.getId());

        messagetable.setMessage(inUpdateMessageDto.getMessage());
        messagetable.setCurrDate(new Date());
         this.messagetableDao.update(messagetable);
        return inUpdateMessageDto;
    }


    // important
//update if message for this catagory bulk to send
    public UpdateCatagoryStatusDTO updateCatagoryInStatus(UpdateCatagoryStatusDTO updateCatagoryStatusDTO) {

        CatagoryTable CatagoryTable = this.CatagoryTableDao.findById(updateCatagoryStatusDTO.getId());

        if(CatagoryTable.getCatagoryStatus()==true) {
            CatagoryTable.setCurrentActive(updateCatagoryStatusDTO.getCurrentActive());
            this.CatagoryTableDao.update(CatagoryTable);
            return updateCatagoryStatusDTO;
        }else{
            updateCatagoryStatusDTO.setCurrentActive(false);
           return updateCatagoryStatusDTO;
        }
     }


    //
    public InRegisterInternalBulkDTO updateInternalBulk(InRegisterInternalBulkDTO inRegisterInternalBulkDTO) {

        InternalBulk CatagoryTable = this.internalBulkDao.findById(inRegisterInternalBulkDTO.getId());
        CatagoryTable.setMessage(inRegisterInternalBulkDTO.getMessage());
        this.internalBulkDao.update(CatagoryTable);
        return inRegisterInternalBulkDTO;
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

    public ResponseMessageDTO deleteBlacklist(DeleteFromBlacklistDTO deleteFromBlackListDTO) {
        try {
            BlackList blackList = this.blackListDao.deleteById(deleteFromBlackListDTO.getId());
            return new ResponseMessageDTO(true, "yes!");
        } catch (Exception e) {
            return new ResponseMessageDTO(false, "no!");
        }
    }


    public OutUpdateCatagoryStatusDTO updateCatagoryStatus(OutUpdateCatagoryStatusDTO updateCatagoryStatusDTO){
        CatagoryTable catagoryTable = this.CatagoryTableDao.findById(updateCatagoryStatusDTO.getId());
        catagoryTable.setCatagoryStatus(updateCatagoryStatusDTO.getCatagoryStatus());
        this.CatagoryTableDao.update(catagoryTable);
        return updateCatagoryStatusDTO;
    }


}
