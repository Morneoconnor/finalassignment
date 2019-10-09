package usermanager.service.admin.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usermanager.domain.admin.AdminLogin;
import usermanager.repository.admin.AdminLoginRepository;
import usermanager.service.admin.AdminLoginService;

import java.util.List;

@Service
public class AdminLoginServiceImpl implements AdminLoginService {

    private static AdminLoginService adminLoginService = null;
    @Autowired
    private AdminLoginRepository adminLoginRepository;

    private AdminLoginServiceImpl() {
    }

    public static AdminLoginService getAdminLoginServiceService() {
        if (adminLoginService == null) adminLoginService = new AdminLoginServiceImpl();
        return adminLoginService;
    }

    @Override
    public AdminLogin create(AdminLogin adminLogin) {
        return this.adminLoginRepository.save(adminLogin);
    }

    @Override
    public AdminLogin read(String s) {
        return this.adminLoginRepository.findById(s).orElse(null);
    }

    @Override
    public AdminLogin update(AdminLogin adminLogin) {
        return this.adminLoginRepository.save(adminLogin);
    }

    @Override
    public void delete(String s) {
        this.adminLoginRepository.deleteById(s);
    }

    @Override
    public AdminLogin retrieveById(String raceDesc) {
        List<AdminLogin> adminLogins = getAll();
        for(AdminLogin adminLogin : adminLogins) {
            if (adminLogin.getId().equalsIgnoreCase(raceDesc))
                return adminLogin;
        } return null;
    }

    @Override
    public List<AdminLogin> getAll() {
        return this.adminLoginRepository.findAll();
    }
}

