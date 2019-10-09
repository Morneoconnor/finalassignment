package usermanager.factory.admin;

import usermanager.domain.admin.AdminLogin;

public class AdminLoginFactory {
    public static AdminLogin buildAdminLogin(String id, String username, String password) {
        return new AdminLogin.Builder()
                .id(id)
                .username(username)
                .password(password)
                .build();
    }
}