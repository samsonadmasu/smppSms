package et.com.smpp.OutDTOs;

import et.com.smpp.model.InternalBulk;

public class OutListInternalBulkDTO {


    private Long id;
    private String message;
    private Boolean preparedStatus;
    private Boolean internal;
    private Boolean external;

    public OutListInternalBulkDTO(Long id, String message, Boolean preparedStatus, Boolean internal, Boolean external) {
        this.id = id;
        this.message = message;
        this.preparedStatus = preparedStatus;
        this.internal = internal;
        this.external = external;
    }

    public OutListInternalBulkDTO() {
    }

    public OutListInternalBulkDTO(final InternalBulk entity) {
        this.id = entity.getId();
        this.message = entity.getMessage();
        this.preparedStatus = entity.getPreparedStatus();
        this.internal = entity.getInternal();
        this.external = entity.getExternal();
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

    public Boolean getInternal() {
        return internal;
    }

    public void setInternal(Boolean internal) {
        this.internal = internal;
    }

    public Boolean getExternal() {
        return external;
    }

    public void setExternal(Boolean external) {
        this.external = external;
    }
}
