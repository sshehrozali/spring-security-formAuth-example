package com.my.app.security;

public enum ApplicationUserPermissions {
    STUDENT_READ("student:read"),
    STUDENT_WRITE("student:write"),

    COURSES_READ("courses:read"),
    COURSES_WRITE("courses:write");

    private final String permissions;

    ApplicationUserPermissions(String permissions) {
        this.permissions = permissions;
    }

    public String getPermissions() {
        return permissions;
    }
}
