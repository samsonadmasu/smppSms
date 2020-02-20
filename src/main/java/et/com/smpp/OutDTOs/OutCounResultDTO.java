package et.com.smpp.OutDTOs;

public class OutCounResultDTO {
    private int total;

    public OutCounResultDTO(int total) {
        this.total = total;
    }

    public OutCounResultDTO() {
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
