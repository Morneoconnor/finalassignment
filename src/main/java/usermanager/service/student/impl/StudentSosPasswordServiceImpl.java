package usermanager.service.student.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usermanager.domain.student.StudentSosPassword;
import usermanager.repository.student.StudentSosPasswordRepository;
import usermanager.service.student.StudentSosPasswordService;

import java.util.List;

@Service
public class StudentSosPasswordServiceImpl implements StudentSosPasswordService {

    private static StudentSosPasswordService studentSosPasswordService = null;
    @Autowired
    private StudentSosPasswordRepository studentSosPasswordRepository;

    private StudentSosPasswordServiceImpl() {
    }

    public static StudentSosPasswordService getStudentLoginServiceService() {
        if (studentSosPasswordService == null) studentSosPasswordService = new StudentSosPasswordServiceImpl();
        return studentSosPasswordService;
    }

    @Override
    public StudentSosPassword create(StudentSosPassword studentSosPassword) {
        return this.studentSosPasswordRepository.save(studentSosPassword);
    }

    @Override
    public StudentSosPassword read(String s) {
        return this.studentSosPasswordRepository.findById(s).orElse(null);
    }

    @Override
    public StudentSosPassword update(StudentSosPassword studentSosPassword) {
        return this.studentSosPasswordRepository.save(studentSosPassword);
    }

    @Override
    public void delete(String s) {
        this.studentSosPasswordRepository.deleteById(s);
    }

    @Override
    public StudentSosPassword retrieveById(String raceDesc) {
        List<StudentSosPassword> studentSosPasswords = getAll();
        for(StudentSosPassword studentSosPassword : studentSosPasswords) {
            if (studentSosPassword.getId().equalsIgnoreCase(raceDesc))
                return studentSosPassword;
        } return null;
    }

    @Override
    public List<StudentSosPassword> getAll() {
        return this.studentSosPasswordRepository.findAll();
    }
}
