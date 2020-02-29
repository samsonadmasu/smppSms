package et.com.smpp.OutDTOs;

import et.com.smpp.model.InternalBulk;

public class OutListInternalBulkDTO {


    private Long id;
    private String message;
    private Boolean preparedStatus;


    public OutListInternalBulkDTO(Long id, String message, Boolean preparedStatus) {
        this.id = id;
        this.message = message;
        this.preparedStatus = preparedStatus;
    }

    public OutListInternalBulkDTO() {
    }

    public OutListInternalBulkDTO(final InternalBulk entity) {
        this.id = entity.getId();
        this.message = entity.getMessage();
        this.preparedStatus = entity.getPreparedStatus();
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
