package cn.edu.gduf.netserver.domain;

/**
 * 角色类
 * @author cjy
 *
 */


public class Role {
   
   private int roleID;  //ID
   
   private String authID;	//权限ID
  
   private String roleName;   //角色名
   
   private String roleDescription;  //角色描述
   
  
   public int getRoleID() {
      return roleID;
   }
   
   
   public void setRoleID(int newRoleID) {
      roleID = newRoleID;
   }
   
 
   public String getAuthID() {
	return authID;
   }


	public void setAuthID(String authID) {
		this.authID = authID;
	}


	public String getRoleName() {
	      return roleName;
	}
   
 
	public void setRoleName(String newRoleName) {
		roleName = newRoleName;
	}


	public String getRoleDescription() {
		return roleDescription;
	}


	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}
   
	
}