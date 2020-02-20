package et.com.smpp.InDTOs;

public class InRegisterRoleDTO {
    private long id;
    private String roleName;

    public InRegisterRoleDTO(long id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public InRegisterRoleDTO() {
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
