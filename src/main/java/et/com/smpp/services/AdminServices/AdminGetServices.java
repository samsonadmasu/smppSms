package et.com.smpp.services.AdminServices;

import et.com.smpp.InDTOs.InRegisterInternalBulkDTO;
import et.com.smpp.InDTOs.InUpdateCatagoryDTO;
import et.com.smpp.OutDTOs.*;
import et.com.smpp.dao.*;
import et.com.smpp.model.*;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.QueryParam;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class AdminGetServices {
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


    public List<OutMessageDTO> listMessageByCatagory(Long id){
        List<OutMessageDTO> message = new ArrayList<OutMessageDTO>();

        List<MessageTable> messageList = this.messagetableDao.FindMessageByCatagoryID(id);
        messageList.forEach((item)->{
            message.add(new OutMessageDTO(item));
        });
        return message;
    }


    public List <OutCatagoryStatusDetail> listCatagoryWithStatus(){

        List<OutCatagoryStatusDetail> message = new ArrayList<OutCatagoryStatusDetail>();
        List<CatagoryTable> catagoryTables = this.CatagoryTableDao.listAll();

        catagoryTables.forEach((item)->{
              message.add(new OutCatagoryStatusDetail(item));
        });
        return message;
    }




    public List<OutConfirmationSendDTO> listUpdatedCatagorys(){

        List<OutConfirmationSendDTO> message = new ArrayList<OutConfirmationSendDTO>();
        OutConfirmationSendDTO outConfirmationSendDTO = new OutConfirmationSendDTO();

        List<CatagoryTable> updatedCatagory = this.CatagoryTableDao.findByStatus();

        updatedCatagory.forEach((item)->{
            message.add(new OutConfirmationSendDTO(item));
        });
    return message;
    }




    public List<OutStaffDTO> listStaff(){
        List<OutStaffDTO> message = new ArrayList<OutStaffDTO>();
        List<Staff> messageList = this.staffDao.listAll();

        messageList.forEach((item)->{
            message.add(new OutStaffDTO(item));
        });
        return message;
    }


    public List<OutRoleDTO> listRole(){
        List<OutRoleDTO> message = new ArrayList<OutRoleDTO>();
        List<Role> messageList = this.roleDao.listAll();

        messageList.forEach((item)->{
            message.add(new OutRoleDTO(item));
        });
        return message;
    }


    public List<OutGetCatagoryDTO> listCatagory(){
        List<OutGetCatagoryDTO> catagorys = new ArrayList<OutGetCatagoryDTO>();
        List<CatagoryTable> catagortyList = this.CatagoryTableDao.listAll();
        catagortyList.forEach((item)->{
            catagorys.add(new OutGetCatagoryDTO(item));
        });
        return catagorys;
    }

    public List<OutMessageDTO> listMessage(){
        List<OutMessageDTO> message = new ArrayList<OutMessageDTO>();
        List<MessageTable> messageList = this.messagetableDao.listAll();
        messageList.forEach((item)->{
            message.add(new OutMessageDTO(item));
        });
        return message;
    }

    public List<GetSubscribesDTO> listSubscriberActive(){
        List<GetSubscribesDTO> subscriber = new ArrayList<GetSubscribesDTO>();
        List<SubscribtionTable> subscriberList = this.subscribtiontableDao.listAllActive();
        subscriberList.forEach((item)->{
            subscriber.add(new GetSubscribesDTO(item));
        });
        return subscriber;
    }


    public List<OutListInternalBulkDTO> lisInternalBulks(){
        List<OutListInternalBulkDTO> subscriber = new ArrayList<OutListInternalBulkDTO>();
        List<InternalBulk> subscriberList = this.internalBulkDao.listAll();
        subscriberList.forEach((item)->{
            subscriber.add(new OutListInternalBulkDTO(item));
        });
        return subscriber;
    }



    public List<GetSubscribesDTO> listSubscriberDeactive(){
        List<GetSubscribesDTO> subscriber = new ArrayList<GetSubscribesDTO>();
        List<SubscribtionTable> subscriberList = this.subscribtiontableDao.listAllDeactive();
        subscriberList.forEach((item)->{
            subscriber.add(new GetSubscribesDTO(item));
        });
        return subscriber;
    }


    public List<EthioTelLogListOutDTO> ethioTelLogListOut(String phoneNumber){
        List<EthioTelLogListOutDTO> subscriber = new ArrayList<EthioTelLogListOutDTO>();
        List<BulkMessage> subscriberList = this.BulkMessageDao.ethioTelLogListOut(phoneNumber);
        subscriberList.forEach((item)->{
            subscriber.add(new EthioTelLogListOutDTO(item));
        });
        return subscriber;
    }

    public List<OutBlackListDTO> listBlackLists(){
        List<OutBlackListDTO> blackList = new ArrayList<OutBlackListDTO>();
        List<BlackList> list = this.blackListDao.listAll();
        list.forEach(item->{
            blackList.add(new OutBlackListDTO(item));
        });
     return  blackList;
    }


    public List<OutBlackListDTO> searchBlacklist(String phoneNumber){

        List<OutBlackListDTO> subscriber = new ArrayList<OutBlackListDTO>();
        List<BlackList> subscriberList = this.blackListDao.serachBlackList(phoneNumber);
        subscriberList.forEach((item)->{
            subscriber.add(new OutBlackListDTO(item));
        });
        return subscriber;
    }

}
