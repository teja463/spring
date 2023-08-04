package com.teja.springboot.security.security;

public enum ApplicationUserPermissions {
    STUDENT_READ("student:read"),
    STUDENT_WRITE("student:write"),
    COURSES_READ("courses:read"),
    COURSES_WRITE("courses:write");

    private String permission;

    ApplicationUserPermissions(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return this.permission;
    }
}
