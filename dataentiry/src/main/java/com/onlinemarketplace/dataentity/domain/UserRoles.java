package com.onlinemarketplace.dataentity.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_roles")
public class UserRoles implements Serializable {

	/**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userRoleId;
    
    @Column
    private String username;
    
    @Column
    private String role ;

	public UserRoles() {
	    super();
	    // TODO Auto-generated constructor stub
    }

	public UserRoles(Long userRoleId, String username, String role) {
	    super();
	    this.userRoleId = userRoleId;
	    this.username = username;
	    this.role = role;
    }

	public Long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId( Long userRoleId ) {
		this.userRoleId = userRoleId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername( String username ) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole( String role ) {
		this.role = role;
	}

	@Override
    public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + ((role == null) ? 0 : role.hashCode());
	    result = prime * result
	            + ((userRoleId == null) ? 0 : userRoleId.hashCode());
	    result = prime * result
	            + ((username == null) ? 0 : username.hashCode());
	    return result;
    }

	@Override
    public boolean equals( Object obj ) {
	    if (this == obj)
		    return true;
	    if (obj == null)
		    return false;
	    if (getClass() != obj.getClass())
		    return false;
	    UserRoles other = (UserRoles) obj;
	    if (role == null) {
		    if (other.role != null)
			    return false;
	    } else if (!role.equals( other.role ))
		    return false;
	    if (userRoleId == null) {
		    if (other.userRoleId != null)
			    return false;
	    } else if (!userRoleId.equals( other.userRoleId ))
		    return false;
	    if (username == null) {
		    if (other.username != null)
			    return false;
	    } else if (!username.equals( other.username ))
		    return false;
	    return true;
    }

	@Override
    public String toString() {
	    return "UserRoles [userRoleId=" + userRoleId + ", username=" + username
	            + ", role=" + role + "]";
    }
    
    
    
}
