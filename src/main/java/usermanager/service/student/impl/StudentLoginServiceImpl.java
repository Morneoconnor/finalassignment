package usermanager.service.student.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usermanager.domain.student.StudentLogin;
import usermanager.domain.student.StudentSosPassword;
import usermanager.repository.student.StudentLoginRepository;
import usermanager.service.student.StudentLoginService;

import java.util.List;

@Service
public class StudentLoginServiceImpl implements StudentLoginService {

    private static StudentLoginService studentLoginService = null;
    @Autowired
    private StudentLoginRepository studentLoginRepository;

    private StudentLoginServiceImpl() {
    }

    public static StudentLoginService getStudentLoginServiceService() {
        if (studentLoginService == null) studentLoginService = new StudentLoginServiceImpl();
        return studentLoginService;
    }

    @Override
    public StudentLogin create(StudentLogin studentLogin) {
        return this.studentLoginRepository.save(studentLogin);
    }

    @Override
    public StudentLogin read(String s) {
        return this.studentLoginRepository.findById(s).orElse(null);
    }

    @Override
    public StudentLogin update(StudentLogin studentLogin) {
        return this.studentLoginRepository.save(studentLogin);
    }

    @Override
    public void delete(String s) {
        this.studentLoginRepository.deleteById(s);
    }

    @Override
    public StudentLogin retrieveById(String raceDesc) {
        List<StudentLogin> studentLogins = getAll();
        for(StudentLogin studentLogin : studentLogins) {
            if (studentLogin.getId().equalsIgnoreCase(raceDesc))
                return studentLogin;
        } return null;
    }

    @Override
    public List<StudentLogin> getAll() {
        return this.studentLoginRepository.findAll();
    }
}


