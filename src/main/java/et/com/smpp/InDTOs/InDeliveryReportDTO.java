package et.com.smpp.InDTOs;

public class InDeliveryReportDTO {
    private String sender;


    public InDeliveryReportDTO() {
    }

    public InDeliveryReportDTO(String sender) {
        this.sender = sender;
    }


    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
