package et.com.smpp.OutDTOs;

import et.com.smpp.model.BlackList;

public class OutBlackListDTO {
    private Long id;
    private String phoneNumber;

    public OutBlackListDTO() {
    }

    public OutBlackListDTO(Long id, String phoneNumber) {
        this.id = id;
        this.phoneNumber = phoneNumber;
    }

    public OutBlackListDTO(final BlackList entity) {
        this.id = entity.getId();
        this.phoneNumber = entity.getPhoneNumber();
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
