package com.ualbany.daneeats.model;

import javax.persistence.*;

@Entity
@Table(name = "UserRoles")
public class Role extends Persistable {

    private User user;

    private UserRoleType roleType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Enumerated(EnumType.STRING)
	public UserRoleType getRoleType() {
		return roleType;
	}

	public void setRoleType(UserRoleType roleType) {
		this.roleType = roleType;
	}
}
