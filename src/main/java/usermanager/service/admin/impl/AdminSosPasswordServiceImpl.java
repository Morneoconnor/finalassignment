package usermanager.service.admin.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usermanager.domain.admin.AdminSosPassword;
import usermanager.repository.admin.AdminSosPasswordRepository;
import usermanager.service.admin.AdminSosPasswordService;

import java.util.List;

@Service
public class AdminSosPasswordServiceImpl implements AdminSosPasswordService {

    private static AdminSosPasswordService adminSosPasswordService = null;
    @Autowired
    private AdminSosPasswordRepository adminSosPasswordRepository;

    private AdminSosPasswordServiceImpl() {
    }

    public static AdminSosPasswordService getAdminSosPasswordService() {
        if (adminSosPasswordService == null) adminSosPasswordService = new AdminSosPasswordServiceImpl();
        return adminSosPasswordService;
    }

    @Override
    public AdminSosPassword create(AdminSosPassword adminSosPassword) {
        return this.adminSosPasswordRepository.save(adminSosPassword);
    }

    @Override
    public AdminSosPassword read(String s) {
        return this.adminSosPasswordRepository.findById(s).orElse(null);
    }

    @Override
    public AdminSosPassword update(AdminSosPassword adminSosPassword) {
        return this.adminSosPasswordRepository.save(adminSosPassword);
    }

    @Override
    public void delete(String s) {
        this.adminSosPasswordRepository.deleteById(s);
    }

    @Override
    public AdminSosPassword retrieveById(String id) {
        List<AdminSosPassword> adminSosPasswords = getAll();
        for(AdminSosPassword adminSosPassword : adminSosPasswords) {
            if (adminSosPassword.getUserName().equalsIgnoreCase(id))
                return adminSosPassword;
        } return null;
    }

    @Override
    public List<AdminSosPassword> getAll() {
        return this.adminSosPasswordRepository.findAll();
    }
}
