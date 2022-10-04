package com.my.app.security;

import com.google.common.collect.Sets;

import java.util.Set;

public enum ApplicationUserRoles {
    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(
            ApplicationUserPermissions.STUDENT_READ,
            ApplicationUserPermissions.STUDENT_WRITE,
            ApplicationUserPermissions.COURSES_READ,
            ApplicationUserPermissions.COURSES_WRITE
    )),
    ADMINTRAINEE(Sets.newHashSet(
            ApplicationUserPermissions.STUDENT_READ,
            ApplicationUserPermissions.COURSES_READ
    ));

    private final Set<ApplicationUserPermissions> permissions;

    ApplicationUserRoles(Set<ApplicationUserPermissions> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermissions> getPermissions() {
        return permissions;
    }
}
