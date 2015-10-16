package com.onlinemarketplace.dataentity.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class Users implements Serializable {

	/**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String username;
    
    @Column
    private String password ;
    
    @Column
    private int enabled ;
    

	public Users(String username, String password, int enabled) {
	    super();
	    this.username = username;
	    this.password = password;
	    this.enabled = enabled;
    }

	public Users() {
	    super();
	    // TODO Auto-generated constructor stub
    }

	public String getUsername() {
		return username;
	}

	public void setUsername( String username ) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword( String password ) {
		this.password = password;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled( int enabled ) {
		this.enabled = enabled;
	}

	@Override
    public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + enabled;
	    result = prime * result
	            + ((password == null) ? 0 : password.hashCode());
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
	    Users other = (Users) obj;
	    if (enabled != other.enabled)
		    return false;
	    if (password == null) {
		    if (other.password != null)
			    return false;
	    } else if (!password.equals( other.password ))
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
	    return "Users [username=" + username + ", password=" + password
	            + ", enabled=" + enabled + "]";
    }
    
    
    

}
