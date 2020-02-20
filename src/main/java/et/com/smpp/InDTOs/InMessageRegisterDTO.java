package et.com.smpp.InDTOs;

import java.util.Date;

public class InMessageRegisterDTO {
    private long id;
    private long CatagoryTable;
    private String message;
    private Date currDate;


    public InMessageRegisterDTO() {
    }


    public InMessageRegisterDTO(long id, long CatagoryTable, String message, Date currDate) {
        this.id = id;
        this.CatagoryTable = CatagoryTable;
        this.message = message;
        this.currDate = currDate;
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

    public void setCatagoryTable(long CatagoryTable) {
        this.CatagoryTable = CatagoryTable;
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
