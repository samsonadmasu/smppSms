package et.com.smpp.InDTOs;

public class InUpdateCatagoryDTO {
    private long id;
    private String catagoryName;
    private String representative;

    public InUpdateCatagoryDTO() {
    }

    public InUpdateCatagoryDTO(long id, String catagoryName, String representative) {
        this.id = id;
        this.catagoryName = catagoryName;
        this.representative = representative;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCatagoryName() {
        return catagoryName;
    }

    public void setCatagoryName(String catagoryName) {
        this.catagoryName = catagoryName;
    }

    public String getRepresentative() {
        return representative;
    }

    public void setRepresentative(String representative) {
        this.representative = representative;
    }
}
