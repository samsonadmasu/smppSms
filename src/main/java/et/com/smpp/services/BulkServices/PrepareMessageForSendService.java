package et.com.smpp.services.BulkServices;

import et.com.smpp.OutDTOs.ResponseMessageDTO;
import et.com.smpp.dao.*;
import et.com.smpp.dao.SmppNumberDao;
import et.com.smpp.model.*;
import et.com.smpp.model.SmppNumber;
import et.com.smpp.services.AdminServices.ReportService;

import javax.ejb.*;
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


    @EJB
    CatagoryTableDao catagoryTableDao;

    @EJB
    InternalBulkDao internalBulkDao;

    @EJB
    ExternalBulkDao externalBulkDao;

    @EJB
    MessageSendService messageSendService;

    @EJB
    SmppNumberDao smppNumberDao;

    @EJB
    ReportService reportService;

    @PersistenceContext(unitName = "smppSms-persistence-unit")
    private EntityManager em;

//    String message = "የምን መረጃ ማግኘት ይፈልጋሉ ??" + "\n" +"የሚፈልጉትን መረጃ ለማግኘት" + "\n"+"A - ለአገር ውስጥ የስፖርት መረጃ" + "\n" + "B - ለአገር ውጭ ሀገራት የስፖርት መረጃ" +"\n" +"C - ለጤናዎ የዶክተር ምክር" + "\n" +"D - ለድንቃድንቅ የቴክኖሎጂ መረጃዎች" +"\n"
//            +"E - ለአዳዲስ የቢዝነስ ሀሳቦች" +"\n" +"F - ለአዳዲስ የሙዚቃ እና የ ፊልም መረጃዎች" +"\n"  + "\n" + "የመረጡትን ፊደል መርጠው ወደ 8888 በነጻ ይላኩ" + "\n" + "1 ብር በቀን በሳምንት ለ 6 ቀን";

    public ResponseMessageDTO PrepareBulk(long id) {
        try {

            List<SubscribtionTable> subscribtiontable = this.subscribtiontableDao.findByCatagoryId(id);
            List<BlackList> allBlackLists = this.blackListDao.listAll();

            subscribtiontable.forEach(item -> {
                CatagoryTable catagoryTable = this.CatagoryTableDao.findById(item.getCatagoryTable().getId());
                allBlackLists.forEach(item2 -> {
                    if (!item.getPhoneNumber().equals(item2.getPhoneNumber())) {
                        System.out.println("-------------------------------------------------------->------------>----------");
                        MessageTable messagetable = this.messagetableDao.findByCatagoryId(id);

                        BulkMessage bulkTwo = new BulkMessage();
                        bulkTwo.setId(null);
                        bulkTwo.setMessageBody(messagetable.getMessage());
                        bulkTwo.setPhoneNumber(item.getPhoneNumber());
                        bulkTwo.setSentStatus(false);
                        bulkTwo.setSend(false);
                        bulkTwo.setSentTime(new Date());
                        bulkTwo.setCatagory(item.getCatagoryTable().getId());

                        this.BulkMessageDao.create(bulkTwo);
                    }
                });
                catagoryTable.setStatus(true);
                this.catagoryTableDao.update(catagoryTable);
            });
            return new ResponseMessageDTO(true, "yes!");
        } catch (Exception e) {
            return new ResponseMessageDTO(false, "no!");
        }
    }


    public ResponseMessageDTO PrepareExternallBulk(long id) {
        InternalBulk internalBulk = this.internalBulkDao.findById(id);

        try {
            List<ExternalBulk> externalBulks = this.externalBulkDao.listAll();
            externalBulks.forEach(item -> {
                BulkMessage bulkTwo = new BulkMessage();
                bulkTwo.setMessageBody(internalBulk.getMessage());
                bulkTwo.setPhoneNumber(item.getPhoneNumber());
                bulkTwo.setSentStatus(false);
                bulkTwo.setSend(false);
                bulkTwo.setSentTime(new Date());
                bulkTwo.setCatagory((long) 1000001);
                this.BulkMessageDao.create(bulkTwo);
            });
            updateExternal(internalBulk);
            return new ResponseMessageDTO(true, "yes!");
        } catch (Exception e) {
            return new ResponseMessageDTO(false, "no!");
        }
    }


    public ResponseMessageDTO PrepareInternalBulk(long id) {
        InternalBulk internalBulk = this.internalBulkDao.findById(id);

        try {
            List<SubscribtionTable> subscribtiontable = this.subscribtiontableDao.findByCatagoryInternalBulk();
            subscribtiontable.forEach(item -> {
                BulkMessage bulkTwo = new BulkMessage();
                bulkTwo.setMessageBody(internalBulk.getMessage());
                bulkTwo.setPhoneNumber(item.getPhoneNumber());
                bulkTwo.setSentStatus(false);
                bulkTwo.setSend(false);
                bulkTwo.setSentTime(new Date());
                bulkTwo.setCatagory((long) 1000000);
                this.BulkMessageDao.create(bulkTwo);
            });
            updateInternal(internalBulk);
            return new ResponseMessageDTO(true, "yes!");
        } catch (Exception e) {
            return new ResponseMessageDTO(false, "no!");
        }
    }

    private void updateInternal(InternalBulk internalBulk) {
        internalBulk.setPreparedStatus(true);
        internalBulk.setInternal(true);
        this.internalBulkDao.create(internalBulk);
    }


    private void updateExternal(InternalBulk internalBulk) {
        internalBulk.setPreparedStatus(true);
        internalBulk.setExternal(true);
        this.internalBulkDao.create(internalBulk);
    }


    public ResponseMessageDTO SendExternalBulkS() {
        try {
            List<BulkMessage> BulkMessage = this.BulkMessageDao.prepareForSendExternalInternal();
            BulkMessage.forEach(item -> {
                item.setSend(true);
                this.BulkMessageDao.update(item);
            });


            List<InternalBulk> internalBulks = this.internalBulkDao.listAll();
            internalBulks.forEach(item -> {
                item.setPreparedStatus(false);
                item.setExternal(false);
                this.internalBulkDao.create(item);
            });

            return new ResponseMessageDTO(true, "yes!");
        } catch (Exception e) {
            return new ResponseMessageDTO(false, "no!");
        }
    }


    public ResponseMessageDTO SendInternalBulkS() {
        try {
            List<BulkMessage> BulkMessage = this.BulkMessageDao.prepareForSendExternalInternal();
            BulkMessage.forEach(item -> {
                item.setSend(true);
                this.BulkMessageDao.update(item);
            });


            List<InternalBulk> internalBulks = this.internalBulkDao.listAll();
            internalBulks.forEach(item -> {
                item.setPreparedStatus(false);
                item.setInternal(false);
                this.internalBulkDao.create(item);
            });

            return new ResponseMessageDTO(true, "yes!");
        } catch (Exception e) {
            return new ResponseMessageDTO(false, "no!");
        }
    }


    public ResponseMessageDTO SendExternalBulk() {

        try {

            SendExternalBulkS();

            sendSmsMo();


            return new ResponseMessageDTO(true, "yes!");
        } catch (Exception e) {
            return new ResponseMessageDTO(false, "no!");
        }
    }

    public ResponseMessageDTO SendInternalBulk() {

        try {

            SendInternalBulkS();

            sendSmsMo();
            return new ResponseMessageDTO(true, "yes!");
        } catch (Exception e) {
            return new ResponseMessageDTO(false, "no!");
        }
    }


    public ResponseMessageDTO Send(long id) {

        try {

            SendS(id);
            sendSmsMt(id);
            checkResend(id);

            return new ResponseMessageDTO(true, "yes!");
        } catch (Exception e) {
            return new ResponseMessageDTO(false, "no!");
        }
    }



    public ResponseMessageDTO ReSend(long id) {
        try {
            sendSmsMt(id);
            int count =   reportService.countPreparedById(id);
            if(count == 0){
            CatagoryTable catagoryTable = this.catagoryTableDao.findById(id);
            catagoryTable.setResendSms(false);
            this.catagoryTableDao.update(catagoryTable);
            }else{

            }
            return new ResponseMessageDTO(true, "yes!");
        } catch (Exception e) {
            return new ResponseMessageDTO(false, "no!");
        }
    }



    public ResponseMessageDTO SendS(long id) {
        try {
            List<BulkMessage> BulkMessage = this.BulkMessageDao.prepareForSend(id);

            BulkMessage.forEach(item -> {
                item.setSend(true);
                this.BulkMessageDao.update(item);
            });

            List<CatagoryTable> catagoryTable = this.catagoryTableDao.listAll();
            catagoryTable.forEach(item -> {
                item.setStatus(false);
                this.catagoryTableDao.update(item);
            });
            //       sendSms();
            return new ResponseMessageDTO(true, "yes!");
        } catch (Exception e) {
            return new ResponseMessageDTO(false, "no!");
        }
    }




    @Asynchronous
    public void ResendSmsMt(long id) {

        List<BulkMessage> msgSents = this.BulkMessageDao.sendall(id);

        msgSents.forEach((msg) -> {

            System.out.println("----------------------------------------------------------------------------------------------------");
            String message = msg.getMessageBody().trim();
            String phone = msg.getPhoneNumber().trim();

            try {
                SmppNumber smppNumber = this.smppNumberDao.mo();
                ResponseMessageDTO responseMessageDTO = messageSendService.sendSMS(message, phone, smppNumber.getMt(), smppNumber.getIpAdress(), smppNumber.getUsername(), smppNumber.getPassword());
                if (responseMessageDTO.isStatus()) {
                      msg.setSentStatus(true);
                    this.BulkMessageDao.updateBulk(msg);

                } else {
                    CatagoryTable catagoryTable = new CatagoryTable();
                   // catagoryTable.setResendSms(true);
                    this.catagoryTableDao.create(catagoryTable);
                }

                System.out.println("------------------------------------------------ sended ----------------------------------------------------");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            //          }
        });
    }


    public void checkResend(long id){

      int count =   reportService.countPreparedById(id);
        if(count!=0){

            CatagoryTable catagoryTable = this.catagoryTableDao.findById(id);
            catagoryTable.setResendSms(true);
            this.catagoryTableDao.update(catagoryTable);
        }else{

        }


    }


    @Asynchronous
    public void sendSmsMt(long id) {

        List<BulkMessage> msgSents = this.BulkMessageDao.sendall(id);

        msgSents.forEach((msg) -> {

            System.out.println("----------------------------------------------------------------------------------------------------");
            String message = msg.getMessageBody().trim();
            String phone = msg.getPhoneNumber().trim();

            try {
                SmppNumber smppNumber = this.smppNumberDao.mo();
                ResponseMessageDTO responseMessageDTO = messageSendService.sendSMS(message, phone, smppNumber.getMt(), smppNumber.getIpAdress(), smppNumber.getUsername(), smppNumber.getPassword());
                if (responseMessageDTO.isStatus()) {
                    msg.setSentStatus(true);
                    this.BulkMessageDao.updateBulk(msg);

                } else {
                    CatagoryTable catagoryTable = new CatagoryTable();
                    catagoryTable.setResendSms(true);
                    this.catagoryTableDao.createResent(catagoryTable);
                }

                System.out.println("------------------------------------------------ sended ----------------------------------------------------");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            //          }
        });
    }


    @Asynchronous
    public void sendSmsMo() {

        List<BulkMessage> msgSents = this.BulkMessageDao.sendBulk();

        msgSents.forEach((msg) -> {

            System.out.println("----------------------------------------------------------------------------------------------------");

            String message = msg.getMessageBody().trim();
            String phone = msg.getPhoneNumber().trim();
            try {
                SmppNumber smppNumber = this.smppNumberDao.mo();
                messageSendService.sendSMS(message, phone, smppNumber.getMo(), smppNumber.getIpAdress(), smppNumber.getUsername(), smppNumber.getPassword());
                msg.setSentStatus(true);
                this.BulkMessageDao.update(msg);
                System.out.println("------------------------------------------------ sended ----------------------------------------------------");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            //          }
        });
    }


    public ResponseMessageDTO ReChooserSendFornewSubscribures() {

        try {
            List<SyncOrderRelationDump> NotChoose = this.syncOrderRelationDumpDao.NotChoose();
            NotChoose.forEach(item -> {

                String message2 = "";
                BulkMessage bulkTwo = new BulkMessage();
                bulkTwo.setMessageBody("insert rechooser message hir");
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


