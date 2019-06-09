package com.blujay.backend.data;

public class Role {
	public static final String USER = "user";
	public static final String DRIVER = "driver";
	public static final String ADMIN = "admin";

	private Role() {
		// Static methods and fields only
	}

	public static String[] getAllRoles() {
		return new String[] { USER, DRIVER, ADMIN };
	}

}
