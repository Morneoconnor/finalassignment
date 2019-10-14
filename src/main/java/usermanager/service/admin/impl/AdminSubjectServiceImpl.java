package usermanager.service.admin.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usermanager.domain.admin.AdminSubject;
import usermanager.repository.admin.AdminSubjectRepository;
import usermanager.service.admin.AdminSubjectService;

import java.util.List;

@Service
public class AdminSubjectServiceImpl implements AdminSubjectService {

    private static AdminSubjectService adminSubjectService = null;
    @Autowired
    private AdminSubjectRepository adminSubjectRepository;

    private AdminSubjectServiceImpl() {
    }

    public static AdminSubjectService getAdminCourseServiceService() {
        if (adminSubjectService == null) adminSubjectService = new AdminSubjectServiceImpl();
        return adminSubjectService;
    }

    @Override
    public AdminSubject create(AdminSubject adminLogin) {
        return this.adminSubjectRepository.save(adminLogin);
    }

    @Override
    public AdminSubject read(String s) {
        return this.adminSubjectRepository.findById(s).orElse(null);
    }

    @Override
    public AdminSubject update(AdminSubject adminLogin) {
        return this.adminSubjectRepository.save(adminLogin);
    }

    @Override
    public void delete(String s) {
        this.adminSubjectRepository.deleteById(s);
    }

    @Override
    public AdminSubject retrieveById(String id) {
        List<AdminSubject> adminLogins = getAll();
        for(AdminSubject adminLogin : adminLogins) {
            if (adminLogin.getId().equalsIgnoreCase(id))
                return adminLogin;
        } return null;
    }

    @Override
    public List<AdminSubject> getAll() {
        return this.adminSubjectRepository.findAll();
    }
}



