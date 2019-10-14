package usermanager.factory.admin;

import usermanager.domain.admin.AdminSosPassword;

public class AdminSosPasswordFactory {
    public static AdminSosPassword buildAdminSosPassword(String username, String password) {
        return new AdminSosPassword.Builder()
                .username(username)
                .password(password)
                .build();
    }
}
