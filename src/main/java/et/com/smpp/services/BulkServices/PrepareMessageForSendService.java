package et.com.smpp.services.BulkServices;

import et.com.smpp.InDTOs.InFindByIdDTO;
import et.com.smpp.OutDTOs.ResponseMessageDTO;
import et.com.smpp.dao.*;
import et.com.smpp.model.*;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

@Stateless
public class PrepareMessageForSendService {
    @EJB
    BulkMessageDao BulkMessageDao;

    @EJB
    CatagoryTableDao CatagoryTableDao;

    @EJB
    MessageTableDao messagetableDao;

    @EJB
    SubscribtionTableDao subscribtiontableDao;

    @EJB
    StaffDao staffDao;

    @EJB
    RoleDao roleDao;

    @EJB
    SyncOrderRelationDumpDao syncOrderRelationDumpDao;

    @EJB
    BlackListDao blackListDao;

    @PersistenceContext(unitName = "smppSms-persistence-unit")
    private EntityManager em;

    String message = "የምን መረጃ ማግኘት ይፈልጋሉ ??" + "\n" +"የሚፈልጉትን መረጃ ለማግኘት" + "\n"+"A - ለአገር ውስጥ የስፖርት መረጃ" + "\n" + "B - ለአገር ውጭ ሀገራት የስፖርት መረጃ" +"\n" +"C - ለጤናዎ የዶክተር ምክር" + "\n" +"D - ለድንቃድንቅ የቴክኖሎጂ መረጃዎች" +"\n"
            +"E - ለአዳዲስ የቢዝነስ ሀሳቦች" +"\n" +"F - ለአዳዲስ የሙዚቃ እና የ ፊልም መረጃዎች" +"\n"  + "\n" + "የመረጡትን ፊደል መርጠው ወደ 8888 በነጻ ይላኩ" + "\n" + "1 ብር በቀን በሳምንት ለ 6 ቀን";

    public ResponseMessageDTO PrepareBulk(InFindByIdDTO inFindByIdDto) {
        try {

            List<SubscribtionTable> subscribtiontable = this.subscribtiontableDao.findByCatagoryId(inFindByIdDto.getId());

            List<BlackList> allBlackLists = this.blackListDao.listAll();
              subscribtiontable.forEach(item -> {

                      allBlackLists.forEach(item2 ->{
                                if(!item.getPhoneNumber().equals(item2.getPhoneNumber())) {
                                    System.out.println("-------------------------------------------------------->------------>----------");
                                    MessageTable messagetable = this.messagetableDao.findByCatagoryId(inFindByIdDto.getId());
                                    BulkMessage bulkTwo = new BulkMessage();
                                    bulkTwo.setMessageBody(messagetable.getMessage());
                                    bulkTwo.setPhoneNumber(item.getPhoneNumber());
                                    bulkTwo.setSentStatus(false);
                                    bulkTwo.setSend(false);
                                    bulkTwo.setSentTime(new Date());
                                    this.BulkMessageDao.create(bulkTwo);
                            }
                      });
            });
            return new ResponseMessageDTO(true, "yes!");
        } catch (Exception e) {
            return new ResponseMessageDTO(false, "no!");
        }
    }





    public ResponseMessageDTO PrepareInternalBulk() {

        try {
            List<SubscribtionTable> subscribtiontable = this.subscribtiontableDao.findByCatagoryInternalBulk();
              subscribtiontable.forEach(item -> {
               BulkMessage bulkTwo = new BulkMessage();
                bulkTwo.setMessageBody(message);
                 bulkTwo.setPhoneNumber(item.getPhoneNumber());
                bulkTwo.setSentStatus(false);
                bulkTwo.setSend(false);
                bulkTwo.setSentTime(new Date());
                this.BulkMessageDao.create(bulkTwo);
           });
            return new ResponseMessageDTO(true, "yes!");
        } catch (Exception e) {
            return new ResponseMessageDTO(false, "no!");
        }
    }




    public ResponseMessageDTO Send() {
        try {
            List<BulkMessage> BulkMessage = this.BulkMessageDao.prepareForSend();
            BulkMessage.forEach(item->{
                item.setSend(true);
                this.BulkMessageDao.update(item);
            });
            return new ResponseMessageDTO(true, "yes!");
        } catch (Exception e) {
            return new ResponseMessageDTO(false, "no!");
        }
    }





    public ResponseMessageDTO ReChooserSendFornewSubscribures() {

        try {
            List<SyncOrderRelationDump> NotChoose = this.syncOrderRelationDumpDao.NotChoose();
              NotChoose.forEach(item -> {

                String message2 = "";
                BulkMessage bulkTwo = new BulkMessage();
                bulkTwo.setMessageBody(message);
                System.out.println("------------------------------------------ 3");
                bulkTwo.setPhoneNumber(item.getUserId());
                bulkTwo.setSentStatus(false);
                bulkTwo.setSend(false);
                bulkTwo.setSentTime(new Date());
                this.BulkMessageDao.create(bulkTwo);
            });
            return new ResponseMessageDTO(true, "yes!");
        } catch (Exception e) {
            return new ResponseMessageDTO(false, "no!");
        }
    }

    public ResponseMessageDTO prepareForNotChoosen() {

return new ResponseMessageDTO(true, "test");
    }


}

