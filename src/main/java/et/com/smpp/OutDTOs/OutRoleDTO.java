package et.com.smpp.OutDTOs;

import et.com.smpp.model.Role;

public class OutRoleDTO {
    private long id;
    private String roleName;


    public OutRoleDTO() {
    }

    public OutRoleDTO(long id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public OutRoleDTO(final Role entity) {
        this.id = entity.getId();
        this.roleName = entity.getRoleName();

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
