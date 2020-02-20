package et.com.smpp.services.BulkServices;

import et.com.smpp.InDTOs.InSubscriptioDTO;
import et.com.smpp.dao.BulkMessageDao;
import et.com.smpp.dao.CatagoryTableDao;
import et.com.smpp.dao.MessageTableDao;
import et.com.smpp.dao.SubscribtionTableDao;
import et.com.smpp.model.BulkMessage;
import et.com.smpp.model.CatagoryTable;
import et.com.smpp.model.SubscribtionTable;


import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

@Stateless
public class SubscrptionService {

    @EJB
    BulkMessageDao BulkMessageDao;

    @EJB
    CatagoryTableDao CatagoryTableDao;

    @EJB
    MessageTableDao messagetableDao;

    @EJB
    SubscribtionTableDao subscribtiontableDao;

    @PersistenceContext(unitName = "smppSms-persistence-unit")
    private EntityManager em;

    public InSubscriptioDTO RegisterSubscription(InSubscriptioDTO subscriptionSMSRequestDto) {
        CatagoryTable CatagoryTable = this.CatagoryTableDao.findByMessage(subscriptionSMSRequestDto.getMessage());
        int subscribtiontable = this.subscribtiontableDao.findByPhoneMessage(subscriptionSMSRequestDto.getSender(),CatagoryTable.getId());

        if(subscribtiontable > 0){
            thankYou(subscriptionSMSRequestDto);
        }else{
            if(subscriptionSMSRequestDto.getMessage().equals("1")){
                Setting(subscriptionSMSRequestDto);
                thankYou(subscriptionSMSRequestDto);
            }else if(subscriptionSMSRequestDto.getMessage().equals("2")){
                Setting(subscriptionSMSRequestDto);
                thankYou(subscriptionSMSRequestDto);
            }else if(subscriptionSMSRequestDto.getMessage().equals("3")){
                Setting(subscriptionSMSRequestDto);
                thankYou(subscriptionSMSRequestDto);
            }else if(subscriptionSMSRequestDto.getMessage().equals("4")){
                Setting(subscriptionSMSRequestDto);
                thankYou(subscriptionSMSRequestDto);
            }else if(subscriptionSMSRequestDto.getMessage().equals("5")){
                Setting(subscriptionSMSRequestDto);
                thankYou(subscriptionSMSRequestDto);
            }else if(subscriptionSMSRequestDto.getMessage().equals("6")){
                Setting(subscriptionSMSRequestDto);
                thankYou(subscriptionSMSRequestDto);
            }else if(subscriptionSMSRequestDto.getMessage().equals("STOP")){
                List<SubscribtionTable> subscribtiontablea = this.subscribtiontableDao.findByPhone(subscriptionSMSRequestDto.getSender());
                subscribtiontablea.forEach(item->{
                    item.setStatus(false);
                    this.subscribtiontableDao.update(item);
                });
                Unsubscribe(subscriptionSMSRequestDto);
            }
        }
        return subscriptionSMSRequestDto;
    }

    public void Setting(InSubscriptioDTO subscriptionSMSRequestDto){
        CatagoryTable CatagoryTable = this.CatagoryTableDao.findByMessage(subscriptionSMSRequestDto.getMessage());
        SubscribtionTable subscribtiontable = new SubscribtionTable();
        subscribtiontable.setCatagoryTable(CatagoryTable);
        subscribtiontable.setPhoneNumber(subscriptionSMSRequestDto.getSender());
        subscribtiontable.setPhoneNumber(subscriptionSMSRequestDto.getReciever());
        subscribtiontable.setCurrDate(new Date());
        subscribtiontable.setStatus(true);
        this.subscribtiontableDao.create(subscribtiontable);
    }

    public void thankYou(InSubscriptioDTO subscriptionSMSRequestDto){
        BulkMessage message = new BulkMessage();
        message.setPhoneNumber(subscriptionSMSRequestDto.getSender());
        message.setMessageBody("thank you for subscription you can -------- 0982-843737");
        message.setSend(true);
        message.setSentTime(new Date());
        message.setSentStatus(false);
        this.BulkMessageDao.create(message);
    }

    public void Unsubscribe(InSubscriptioDTO subscriptionSMSRequestDto){
        BulkMessage message = new BulkMessage();
        message.setPhoneNumber(subscriptionSMSRequestDto.getSender());
        message.setMessageBody("You are succesfully unsubscribed from our service." + "\n"+"\n"+"to subscribe again" + "\n"+"A - for Sport" + "\n"  + "B - ye fikir tikisoch" +"\n" +"C - ababaloch" +
                "\n" +"\n" + "yemeretutin fidel wede 8888 benetsa yilaku " + "\n" + "1 ETB/SMS for 6 times/week");
        message.setSend(true);
        message.setSentTime(new Date());
        message.setSentStatus(false);
        this.BulkMessageDao.create(message);
    }
}
