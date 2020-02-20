package et.com.smpp.InDTOs;

import java.util.Date;

public class InUpdateMessageDTO {

    private long id;
//    private long CatagoryTable;
    private String message;
    private Date currDate;

    public InUpdateMessageDTO() {
    }

    public InUpdateMessageDTO(long id, String message, Date currDate) {
        this.id = id;
        this.message = message;
        this.currDate = currDate;
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

    public Date getCurrDate() {
        return currDate;
    }

    public void setCurrDate(Date currDate) {
        this.currDate = currDate;
    }
}
