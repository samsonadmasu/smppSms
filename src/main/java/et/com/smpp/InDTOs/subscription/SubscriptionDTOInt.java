package et.com.smpp.InDTOs.subscription;

import java.util.Date;

public class SubscriptionDTOInt {
    private Long id;
    private Date startDate;
    private Date endDate;

    public SubscriptionDTOInt() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
