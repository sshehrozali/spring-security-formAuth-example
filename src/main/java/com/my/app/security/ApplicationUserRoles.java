package com.my.app.security;

import java.util.Set;

public enum ApplicationUserRoles {
    STUDENT(permissions),
    ADMIN(permissions);

    private final Set<ApplicationUserPermissions> permissions;

    ApplicationUserRoles(Set<ApplicationUserPermissions> permissions) {
        this.permissions = permissions;
    }
}
