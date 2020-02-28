package et.com.smpp.OutDTOs;

import et.com.smpp.model.CatagoryTable;

public class OutConfirmationSendDTO {

     private  long catagoryId;
    private String catagoryName;

    public OutConfirmationSendDTO() {
    }


    public OutConfirmationSendDTO(long catagoryId, String catagoryName) {
           this.catagoryId = catagoryId;
        this.catagoryName = catagoryName;
    }

    public OutConfirmationSendDTO(final CatagoryTable entity) {
       this.catagoryId = entity.getId();
        this.catagoryName = entity.getCatagoryName();
    }



    public long getCatagoryId() {
        return catagoryId;
    }

    public void setCatagoryId(long catagoryId) {
        this.catagoryId = catagoryId;
    }

    public String getCatagoryName() {
        return catagoryName;
    }

    public void setCatagoryName(String catagoryName) {
        this.catagoryName = catagoryName;
    }
}
