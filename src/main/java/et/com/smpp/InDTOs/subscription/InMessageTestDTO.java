package et.com.smpp.InDTOs.subscription;

import java.util.Date;

public class InMessageTestDTO {
    private long id;
    private long CatagoryTable;
    private String message;
    private Date currDate;

    public InMessageTestDTO(long id, long catagoryTable, String message, Date currDate) {
        this.id = id;
        CatagoryTable = catagoryTable;
        this.message = message;
        this.currDate = currDate;
    }

    public InMessageTestDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCatagoryTable() {
        return CatagoryTable;
    }

    public void setCatagoryTable(long catagoryTable) {
        CatagoryTable = catagoryTable;
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
