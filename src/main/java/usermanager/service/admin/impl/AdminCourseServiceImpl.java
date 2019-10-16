package usermanager.service.admin.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usermanager.domain.admin.AdminCourse;
import usermanager.repository.admin.AdminCourseRepository;
import usermanager.service.admin.AdminCourseService;

import java.util.List;

@Service
public class AdminCourseServiceImpl implements AdminCourseService {

    private static AdminCourseService adminCourseService = null;
    @Autowired
    private AdminCourseRepository adminCourseRepository;

    private AdminCourseServiceImpl() {
    }

    public static AdminCourseService getAdminCourseServiceService() {
        if (adminCourseService == null) adminCourseService = new AdminCourseServiceImpl();
        return adminCourseService;
    }

    @Override
    public AdminCourse create(AdminCourse adminLogin) {
        return this.adminCourseRepository.save(adminLogin);
    }

    @Override
    public AdminCourse read(String s) {
        return this.adminCourseRepository.findById(s).orElse(null);
    }

    @Override
    public AdminCourse update(AdminCourse adminLogin) {
        return this.adminCourseRepository.save(adminLogin);
    }

    @Override
    public void delete(String s) {
        this.adminCourseRepository.deleteById(s);
    }

    @Override
    public AdminCourse retrieveById(String id) {
        List<AdminCourse> adminLogins = getAll();
        for(AdminCourse adminLogin : adminLogins) {
            if (adminLogin.getUsername().equalsIgnoreCase(id))
                return adminLogin;
        } return null;
    }

    @Override
    public List<AdminCourse> getAll() {
        return this.adminCourseRepository.findAll();
    }
}


