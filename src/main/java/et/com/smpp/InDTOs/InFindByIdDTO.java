package et.com.smpp.InDTOs;

public class InFindByIdDTO {
    private long id;

    public InFindByIdDTO(long id) {
        this.id = id;
    }

    public InFindByIdDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
