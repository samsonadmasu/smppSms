package et.com.smpp.OutDTOs;

import et.com.smpp.model.MessageTable;

import java.util.Date;

public class OutMessageDTO {
    private long id;
    private String message;
    private  long catagoryId;
    private String catagoryName;
    private Date currDate;

    public OutMessageDTO() {
    }

    public OutMessageDTO(long id, String message, long catagoryId, String catagoryName, Date currDate) {
        this.id = id;
        this.message = message;
        this.catagoryId = catagoryId;
        this.catagoryName = catagoryName;
        this.currDate = currDate;
    }

    public OutMessageDTO(final MessageTable entity) {
        this.id = entity.getId();
        this.message = entity.getMessage();
        this.catagoryId = entity.getCatagoryTable().getId();
        this.catagoryName = entity.getCatagoryTable().getCatagoryName();
        this.currDate = entity.getCurrDate();

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getCatagoryId() {
        return catagoryId;
    }

    public void setCatagoryId(long catagoryId) {
        this.catagoryId = catagoryId;
    }

    public String getCatagoryName() {
        return catagoryName;
    }

    public void setCatagoryName(String catagoryName) {
        this.catagoryName = catagoryName;
    }

    public Date getCurrDate() {
        return currDate;
    }

    public void setCurrDate(Date currDate) {
        this.currDate = currDate;
    }
}
