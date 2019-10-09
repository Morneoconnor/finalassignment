package usermanager.service.admin;

import usermanager.domain.admin.AdminLogin;
import usermanager.service.IService;
import java.util.List;

public interface AdminLoginService extends IService<AdminLogin, String> {
    AdminLogin retrieveById(String genderDesc);
    List<AdminLogin> getAll();
}
