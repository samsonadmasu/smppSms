package et.com.smpp.services.AdminServices;

import et.com.smpp.OutDTOs.EthioTelLogListOutDTO;
import et.com.smpp.OutDTOs.GetSubscribesDTO;
import et.com.smpp.OutDTOs.OutGetCatagoryDTO;
import et.com.smpp.OutDTOs.OutMessageDTO;
import et.com.smpp.dao.*;
import et.com.smpp.model.BulkMessage;
import et.com.smpp.model.CatagoryTable;
import et.com.smpp.model.MessageTable;
import et.com.smpp.model.SubscribtionTable;

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




}
