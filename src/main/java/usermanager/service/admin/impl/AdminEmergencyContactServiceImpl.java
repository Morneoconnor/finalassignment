package usermanager.service.admin.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usermanager.domain.admin.AdminEmergencyContact;
import usermanager.repository.admin.AdminEmergencyContactRepository;
import usermanager.service.admin.AdminEmergencyContactService;

import java.util.List;

@Service
public class AdminEmergencyContactServiceImpl implements AdminEmergencyContactService {

    private static AdminEmergencyContactService adminEmergencyContactService = null;
    @Autowired
    private AdminEmergencyContactRepository adminEmergencyContactRepository;

    private AdminEmergencyContactServiceImpl() {
    }

    public static AdminEmergencyContactService getAdminEmergencyContactService() {
        if (adminEmergencyContactService == null) adminEmergencyContactService = new AdminEmergencyContactServiceImpl();
        return adminEmergencyContactService;
    }

    @Override
    public AdminEmergencyContact create(AdminEmergencyContact adminLogin) {
        return this.adminEmergencyContactRepository.save(adminLogin);
    }

    @Override
    public AdminEmergencyContact read(String s) {
        return this.adminEmergencyContactRepository.findById(s).orElse(null);
    }

    @Override
    public AdminEmergencyContact update(AdminEmergencyContact adminLogin) {
        return this.adminEmergencyContactRepository.save(adminLogin);
    }

    @Override
    public void delete(String s) {
        this.adminEmergencyContactRepository.deleteById(s);
    }

    @Override
    public AdminEmergencyContact retrieveById(String id) {
        List<AdminEmergencyContact> adminLogins = getAll();
        for(AdminEmergencyContact adminLogin : adminLogins) {
            if (adminLogin.getId().equalsIgnoreCase(id))
                return adminLogin;
        } return null;
    }

    @Override
    public List<AdminEmergencyContact> getAll() {
        return this.adminEmergencyContactRepository.findAll();
    }
}



