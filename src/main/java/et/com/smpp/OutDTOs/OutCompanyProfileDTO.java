package et.com.smpp.OutDTOs;

import et.com.smpp.model.CompanyProfile;

public class OutCompanyProfileDTO {
    private Long id;
    private String companyName;

    public OutCompanyProfileDTO() {
    }

    public OutCompanyProfileDTO(Long id, String companyName) {
        this.id = id;
        this.companyName = companyName;
    }

    public OutCompanyProfileDTO(final CompanyProfile entity) {
        this.id = entity.getId();
        this.companyName = entity.getCompanyName();

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
