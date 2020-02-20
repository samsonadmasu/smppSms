package et.com.smpp.OutDTOs;

import et.com.smpp.model.CatagoryTable;

public class OutGetCatagoryDTO {
    private long id;
    private String catagoryName;
    private String representative;

    public OutGetCatagoryDTO(long id, String catagoryName, String representative) {
        this.id = id;
        this.catagoryName = catagoryName;
        this.representative = representative;
    }



    public OutGetCatagoryDTO() {
    }


    public OutGetCatagoryDTO(final CatagoryTable entity) {
        this.id = entity.getId();
        this.catagoryName = entity.getCatagoryName();
        this.representative = entity.getRepresentative();
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
