package et.com.smpp.InDTOs;

public class InRegisterCatagoryDTO {
    private long id;
    private String catagoryName;
    private String representative;
    private boolean status;
    private Boolean currentActive;

    public InRegisterCatagoryDTO() {
    }

    public InRegisterCatagoryDTO(long id, String catagoryName, String representative, boolean status, Boolean currentActive) {
        this.id = id;
        this.catagoryName = catagoryName;
        this.representative = representative;
        this.status = status;
        this.currentActive = currentActive;
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


    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Boolean getCurrentActive() {
        return currentActive;
    }

    public void setCurrentActive(Boolean currentActive) {
        this.currentActive = currentActive;
    }
}
