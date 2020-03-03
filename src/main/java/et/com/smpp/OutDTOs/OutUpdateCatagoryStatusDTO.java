package et.com.smpp.OutDTOs;

public class OutUpdateCatagoryStatusDTO {
    private Long id;
    private String catagoryName;
    private String representative;
    private boolean status;
    private Boolean currentActive;
    private Boolean catagoryStatus;


    public OutUpdateCatagoryStatusDTO(Long id, String catagoryName, String representative, boolean status, Boolean currentActive, Boolean catagoryStatus) {
        this.id = id;
        this.catagoryName = catagoryName;
        this.representative = representative;
        this.status = status;
        this.currentActive = currentActive;
        this.catagoryStatus = catagoryStatus;
    }

    public OutUpdateCatagoryStatusDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public boolean isCurrentActive() {
        return currentActive;
    }

    public void setCurrentActive(boolean currentActive) {
        this.currentActive = currentActive;
    }

    public Boolean getCurrentActive() {
        return currentActive;
    }

    public void setCurrentActive(Boolean currentActive) {
        this.currentActive = currentActive;
    }

    public Boolean getCatagoryStatus() {
        return catagoryStatus;
    }

    public void setCatagoryStatus(Boolean catagoryStatus) {
        this.catagoryStatus = catagoryStatus;
    }
}
