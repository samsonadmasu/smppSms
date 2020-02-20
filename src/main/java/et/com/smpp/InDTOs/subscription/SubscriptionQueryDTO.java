package et.com.smpp.InDTOs.subscription;

import java.util.Date;

public class SubscriptionQueryDTO {
    private Date startDate;
    private Date endDate;

    public SubscriptionQueryDTO() {
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
