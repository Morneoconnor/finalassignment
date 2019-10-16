package usermanager.factory.admin;

import usermanager.domain.admin.AdminLogin;

public class AdminLoginFactory {
    public static AdminLogin buildAdminLogin(String username, String password) {
        return new AdminLogin.Builder()
                .username(username)
                .password(password)
                .build();
    }
}
