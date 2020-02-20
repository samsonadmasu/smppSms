package et.com.smpp.InDTOs;


import java.sql.Date;

public class InByActiveByDateDTO {
    private Date startDate;
    private Date endDate;

    public InByActiveByDateDTO(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public InByActiveByDateDTO() {
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
