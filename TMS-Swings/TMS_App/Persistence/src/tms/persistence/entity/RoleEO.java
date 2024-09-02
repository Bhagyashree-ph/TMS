package tms.persistence.entity;

/**
 *
 * @author bhagya.shree
 */
public class RoleEO {
    
    private int roleID;
    private String roleName;
    
    /**
     *
     */
    public RoleEO() {
        
    }

    /**
     *
     * @param roleID
     * @param roleName
     */
    public RoleEO(int roleID, String roleName) {
        super();
        this.roleID = roleID;
        this.roleName = roleName;
    }
    
    /**
     *
     * @param roleID
     */
    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    /**
     *
     * @return
     */
    public int getRoleID() {
        return roleID;
    }

    /**
     *
     * @param roleName
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     *
     * @return
     */
    public String getRoleName() {
        return roleName;
    }

    @Override
    public String toString() {
        return "RoleEO contents [roleID : " + this.roleID +
            " rolenName : " + this.roleName + "]";
    }
}
