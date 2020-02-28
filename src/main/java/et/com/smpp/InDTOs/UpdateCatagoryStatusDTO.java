package et.com.smpp.InDTOs;

public class UpdateCatagoryStatusDTO {

    private Long id;
    private String catagoryName;
     private Boolean currentActive;

    public UpdateCatagoryStatusDTO() {
    }

    public UpdateCatagoryStatusDTO(Long id, String catagoryName, Boolean currentActive) {
        this.id = id;
        this.catagoryName = catagoryName;
        this.currentActive = currentActive;
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

    public Boolean getCurrentActive() {
        return currentActive;
    }

    public void setCurrentActive(Boolean currentActive) {
        this.currentActive = currentActive;
    }
}
