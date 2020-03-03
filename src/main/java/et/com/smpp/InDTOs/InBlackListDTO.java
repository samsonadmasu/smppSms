package et.com.smpp.InDTOs;

public class InBlackListDTO {
    private Long id;
    private String phoneNumber;


    public InBlackListDTO() {
    }

    public InBlackListDTO(Long id, String phoneNumber) {
        this.id = id;
        this.phoneNumber = phoneNumber;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
