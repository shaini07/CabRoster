package com.blujay.backend.data.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// "User" is a reserved word in some SQL implementations
@Entity(name = "UserInfo")
public class User extends AbstractEntity {

	@NotNull
	@Size(min = 1, max = 255)
	@Column(unique = true)
	private String email;

	@NotNull
	@Size(min = 4, max = 255)
	private String passwordHash;

	@NotNull
	@Size(min = 1, max = 255)
	private String name;

	@NotNull
	@Size(min = 1, max = 255)
	private String role;

	private boolean locked = false;

	public User() {
		// An empty constructor is needed for all beans
	}

	public User(String email, String name, String password, String role) {
		Objects.requireNonNull(email);
		Objects.requireNonNull(name);
		Objects.requireNonNull(password);
		Objects.requireNonNull(role);

		this.email = email;
		this.name = name;
		this.passwordHash = password;
		this.role = role;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String password) {
		this.passwordHash = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}
}
