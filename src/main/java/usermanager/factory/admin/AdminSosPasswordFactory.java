package usermanager.factory.admin;

import usermanager.domain.admin.AdminSosPassword;

public class AdminSosPasswordFactory {
    public static AdminSosPassword buildAdminSosPassword(String id, String username, String password) {
        return new AdminSosPassword.Builder()
                .id(id)
                .username(username)
                .password(password)
                .build();
    }
}
