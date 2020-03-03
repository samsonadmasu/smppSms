package et.com.smpp.InDTOs;

import javax.ws.rs.FormParam;
import org.jboss.resteasy.annotations.providers.multipart.PartType;

public class FileUploadForm {
    String batchName;

    public FileUploadForm() {
    }

    private byte[] data;

    public byte[] getData() {
        return data;
    }

    @FormParam("uploadedFile")
    @PartType("application/octet-stream")
    public void setData(byte[] data) {
        this.data = data;
    }

    public String getBatchName() {
        return batchName;
    }
    @FormParam("batchName")
    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }
}
