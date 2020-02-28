package et.com.smpp.OutDTOs;

import et.com.smpp.model.CatagoryTable;

public class OutCatagoryStatusDetail {

    private Long id;
    private String catagoryName;
    private String representative;
    private boolean status;
    private boolean currentActive;

    public OutCatagoryStatusDetail() {
    }

    public OutCatagoryStatusDetail(Long id, String catagoryName, String representative, boolean status, Boolean currentActive) {
        this.id = id;
        this.catagoryName = catagoryName;
        this.representative = representative;
        this.status = status;
        this.currentActive = currentActive;
    }

    public OutCatagoryStatusDetail(final CatagoryTable entity) {
        this.id = entity.getId();
        this.catagoryName = entity.getCatagoryName();
        this.representative = entity.getRepresentative();
        this.status = entity.isStatus();
        this.currentActive = entity.getCurrentActive();


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
}
