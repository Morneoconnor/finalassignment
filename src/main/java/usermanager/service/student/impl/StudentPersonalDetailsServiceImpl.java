package usermanager.service.student.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usermanager.domain.student.StudentPersonalDetails;
import usermanager.repository.student.StudentPersonalDetailsRepository;
import usermanager.service.student.StudentPersonalDetailsService;

import java.util.List;

@Service
public class StudentPersonalDetailsServiceImpl implements StudentPersonalDetailsService {

    private static StudentPersonalDetailsService studentPersonalDetailsService = null;
    @Autowired
    private StudentPersonalDetailsRepository studentPersonalDetailsRepository;

    private StudentPersonalDetailsServiceImpl() {
    }

    public static StudentPersonalDetailsService getStudentCourseServiceService() {
        if (studentPersonalDetailsService == null) studentPersonalDetailsService = new StudentPersonalDetailsServiceImpl();
        return studentPersonalDetailsService;
    }

    @Override
    public StudentPersonalDetails create(StudentPersonalDetails adminLogin) {
        return this.studentPersonalDetailsRepository.save(adminLogin);
    }

    @Override
    public StudentPersonalDetails read(String s) {
        return this.studentPersonalDetailsRepository.findById(s).orElse(null);
    }

    @Override
    public StudentPersonalDetails update(StudentPersonalDetails adminLogin) {
        return this.studentPersonalDetailsRepository.save(adminLogin);
    }

    @Override
    public void delete(String s) {
        this.studentPersonalDetailsRepository.deleteById(s);
    }

    @Override
    public StudentPersonalDetails retrieveById(String id) {
        List<StudentPersonalDetails> adminLogins = getAll();
        for(StudentPersonalDetails adminLogin : adminLogins) {
            if (adminLogin.getId().equalsIgnoreCase(id))
                return adminLogin;
        } return null;
    }

    @Override
    public List<StudentPersonalDetails> getAll() {
        return this.studentPersonalDetailsRepository.findAll();
    }
}
