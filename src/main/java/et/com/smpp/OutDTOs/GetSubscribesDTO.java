package et.com.smpp.OutDTOs;

import et.com.smpp.model.SubscribtionTable;

import java.util.Date;

public class GetSubscribesDTO {
    private long id;
    private String sender;
    private String message;
    private String reciever;
    private Date sentTime;
    private boolean sentStatus;

    public GetSubscribesDTO(long id, String sender, String message, String reciever, Date sentTime, boolean sentStatus) {
        this.id = id;
        this.sender = sender;
        this.message = message;
        this.reciever = reciever;
        this.sentTime = sentTime;
        this.sentStatus = sentStatus;
    }

    public GetSubscribesDTO() {
    }

    public GetSubscribesDTO(final SubscribtionTable entity) {
        this.id = entity.getId();
        this.sender = entity.getPhoneNumber();
        this.message = entity.getCatagoryTable().getCatagoryName();
        this.reciever = entity.getPhoneNumber();
        this.sentTime = entity.getCurrDate();
        this.sentStatus = entity.isStatus();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReciever() {
        return reciever;
    }

    public void setReciever(String reciever) {
        this.reciever = reciever;
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
