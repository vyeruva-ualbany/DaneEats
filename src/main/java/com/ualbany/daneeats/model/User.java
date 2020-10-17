package com.ualbany.daneeats.model;
import javax.persistence.*;



import java.util.Set;

@Entity(name = "User")
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = {"email", "userName"}) })
public class User extends Persistable {

	private String userName;
	private String email;
	private String password;
    private VerificationToken verificationToken;
	
    @Transient//this field will not be saved in the database.
    private String passwordConfirm;

    private Set<Role> roles;

    @Column(nullable = false)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "email", unique = true, nullable = false)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password")
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="userId")
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="userId")
    public VerificationToken getVerificationToken() {
        return verificationToken;
    }

    public void setVerificationToken(VerificationToken verificationToken) {
        this.verificationToken = verificationToken;
    }
}
