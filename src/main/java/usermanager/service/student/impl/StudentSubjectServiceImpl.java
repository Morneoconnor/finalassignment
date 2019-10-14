package usermanager.service.student.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usermanager.domain.student.StudentSubject;
import usermanager.repository.student.StudentSubjectRepository;
import usermanager.service.student.StudentSubjectService;

import java.util.List;

@Service
public class StudentSubjectServiceImpl implements StudentSubjectService {

    private static StudentSubjectService adminSubjectService = null;
    @Autowired
    private StudentSubjectRepository studentSubjectRepository;

    private StudentSubjectServiceImpl() {
    }

    public static StudentSubjectService getAdminCourseServiceService() {
        if (adminSubjectService == null) adminSubjectService = new StudentSubjectServiceImpl();
        return adminSubjectService;
    }

    @Override
    public StudentSubject create(StudentSubject adminLogin) {
        return this.studentSubjectRepository.save(adminLogin);
    }

    @Override
    public StudentSubject read(String s) {
        return this.studentSubjectRepository.findById(s).orElse(null);
    }

    @Override
    public StudentSubject update(StudentSubject adminLogin) {
        return this.studentSubjectRepository.save(adminLogin);
    }

    @Override
    public void delete(String s) {
        this.studentSubjectRepository.deleteById(s);
    }

    @Override
    public StudentSubject retrieveById(String id) {
        List<StudentSubject> adminLogins = getAll();
        for(StudentSubject adminLogin : adminLogins) {
            if (adminLogin.getId().equalsIgnoreCase(id))
                return adminLogin;
        } return null;
    }

    @Override
    public List<StudentSubject> getAll() {
        return this.studentSubjectRepository.findAll();
    }
}
