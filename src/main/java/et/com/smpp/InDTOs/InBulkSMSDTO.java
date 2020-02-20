package et.com.smpp.InDTOs;

import java.util.Date;

public class InBulkSMSDTO {
    private long id;
    private String phoneNumber;
    private String messageBody;
    private Date sentTime;
    private boolean sentStatus;


    public InBulkSMSDTO(long id, String phoneNumber, String messageBody, Date sentTime, boolean sentStatus) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.messageBody = messageBody;
        this.sentTime = sentTime;
        this.sentStatus = sentStatus;
    }


    public InBulkSMSDTO() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public Date getSentTime() {
        return sentTime;
    }

    public void setSentTime(Date sentTime) {
        this.sentTime = sentTime;
    }

    public boolean isSentStatus() {
        return sentStatus;
    }

    public void setSentStatus(boolean sentStatus) {
        this.sentStatus = sentStatus;
    }
}
