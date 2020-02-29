package et.com.smpp.InDTOs;

import et.com.smpp.model.InternalBulk;

public class InRegisterInternalBulkDTO {

    private Long id;
    private String message;
    private Boolean preparedStatus;


    public InRegisterInternalBulkDTO() {
    }

    public InRegisterInternalBulkDTO(Long id, String message, Boolean preparedStatus) {
        this.id = id;
        this.message = message;
        this.preparedStatus = preparedStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getPreparedStatus() {
        return preparedStatus;
    }

    public void setPreparedStatus(Boolean preparedStatus) {
        this.preparedStatus = preparedStatus;
    }
}
