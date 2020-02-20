package et.com.smpp.OutDTOs;

import et.com.smpp.model.BulkMessage;

import java.util.Date;

public class msgSendResponseDTO {
	private long id;
    private String phoneNumber;
    private String messageBody;
    private Date sentTime;
    private boolean sentStatus;
    private boolean send;

    public msgSendResponseDTO(long id, String phoneNumber, String messageBody, Date sentTime, boolean sentStatus, boolean send) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.messageBody = messageBody;
        this.sentTime = sentTime;
        this.sentStatus = sentStatus;
        this.send = send;
    }

    public msgSendResponseDTO() {

	}

	public msgSendResponseDTO(final BulkMessage entity) {
		this.phoneNumber = entity.getPhoneNumber();
		this.messageBody = entity.getMessageBody();
		this.sentTime = entity.getSentTime();
		this.sentStatus = entity.isSentStatus();
		this.send = entity.isSentStatus();
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

    public boolean isSend() {
        return send;
    }

    public void setSend(boolean send) {
        this.send = send;
    }
}
