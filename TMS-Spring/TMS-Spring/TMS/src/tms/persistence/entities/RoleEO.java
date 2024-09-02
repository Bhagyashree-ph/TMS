package tms.persistence.entities;

import javax.persistence.*;;

@Entity
@Table(name="ROLES")
public class RoleEO {
	
	@Column(name="ROLENAME")
	@Id
	private String roleName;
	
	@Column(name="ROLE_DESCRIPTION")
	private String roleDesc;
	
	public RoleEO() {
		
	}

    /**
     * @param roleName
     * @param roleDesc
     */
    public RoleEO(String roleName, String roleDesc) {
		super();
		this.roleName = roleName;
		this.roleDesc = roleDesc;
	}

    /**
     * @return
     */
    public String getRoleName() {
		return roleName;
	}

    /**
     * @param roleName
     */
    public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

    /**
     * @return
     */
    public String getRoleDesc() {
		return roleDesc;
	}

    /**
     * @param roleDesc
     */
    public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

    /**
     * @return
     */
    @Override
	public String toString() {
		return "RoleEO [roleName=" + roleName + ", roleDesc=" + roleDesc + "]";
	}
	
	
}
