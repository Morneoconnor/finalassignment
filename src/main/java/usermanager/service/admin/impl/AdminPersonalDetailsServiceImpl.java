package usermanager.service.admin.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usermanager.domain.admin.AdminPersonalDetails;
import usermanager.repository.admin.AdminPersonalDetailsRepository;
import usermanager.service.admin.AdminPersonalDetailsService;

import java.util.List;

@Service
public class AdminPersonalDetailsServiceImpl implements AdminPersonalDetailsService {

    private static AdminPersonalDetailsService adminPersonalDetailsService = null;
    @Autowired
    private AdminPersonalDetailsRepository adminPersonalDetailsRepository;

    private AdminPersonalDetailsServiceImpl() {
    }

    public static AdminPersonalDetailsService getAdminCourseServiceService() {
        if (adminPersonalDetailsService == null) adminPersonalDetailsService = new AdminPersonalDetailsServiceImpl();
        return adminPersonalDetailsService;
    }

    @Override
    public AdminPersonalDetails create(AdminPersonalDetails adminLogin) {
        return this.adminPersonalDetailsRepository.save(adminLogin);
    }

    @Override
    public AdminPersonalDetails read(String s) {
        return this.adminPersonalDetailsRepository.findById(s).orElse(null);
    }

    @Override
    public AdminPersonalDetails update(AdminPersonalDetails adminLogin) {
        return this.adminPersonalDetailsRepository.save(adminLogin);
    }

    @Override
    public void delete(String s) {
        this.adminPersonalDetailsRepository.deleteById(s);
    }

    @Override
    public AdminPersonalDetails retrieveById(String id) {
        List<AdminPersonalDetails> adminLogins = getAll();
        for(AdminPersonalDetails adminLogin : adminLogins) {
            if (adminLogin.getId().equalsIgnoreCase(id))
                return adminLogin;
        } return null;
    }

    @Override
    public List<AdminPersonalDetails> getAll() {
        return this.adminPersonalDetailsRepository.findAll();
    }
}