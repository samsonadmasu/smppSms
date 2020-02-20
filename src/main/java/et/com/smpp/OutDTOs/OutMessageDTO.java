package et.com.smpp.OutDTOs;

import et.com.smpp.model.MessageTable;

public class OutMessageDTO {
    private long id;
    private String message;

    public OutMessageDTO() {
    }

    public OutMessageDTO(long id, String message) {
        this.id = id;
        this.message = message;
     }

    public OutMessageDTO(final MessageTable entity) {
        this.id = entity.getId();
        this.message = entity.getMessage();

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

 }
