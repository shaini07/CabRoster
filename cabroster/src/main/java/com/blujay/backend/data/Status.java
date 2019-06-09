package com.blujay.backend.data;

public class Status {
    public static final String ACTIVE = "Active";
    public static final String INACTIVE = "Inactive";

    private Status() {
        // Static methods and fields only
    }

    public static String[] getAllRoles() {
        return new String[] { ACTIVE, INACTIVE };
    }

}
