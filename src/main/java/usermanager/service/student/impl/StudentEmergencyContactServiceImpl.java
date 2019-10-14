package usermanager.service.student.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usermanager.domain.student.StudentEmergencyContact;
import usermanager.repository.student.StudentEmergencyContactRepository;
import usermanager.service.student.StudentEmergencyContactService;

import java.util.List;

@Service
public class StudentEmergencyContactServiceImpl implements StudentEmergencyContactService {

    private static StudentEmergencyContactService studentEmergencyContactService = null;
    @Autowired
    private StudentEmergencyContactRepository studentEmergencyContactRepository;

    private StudentEmergencyContactServiceImpl() {
    }

    public static StudentEmergencyContactService getAdminEmergencyContactService() {
        if (studentEmergencyContactService == null) studentEmergencyContactService = new StudentEmergencyContactServiceImpl();
        return studentEmergencyContactService;
    }

    @Override
    public StudentEmergencyContact create(StudentEmergencyContact adminLogin) {
        return this.studentEmergencyContactRepository.save(adminLogin);
    }

    @Override
    public StudentEmergencyContact read(String s) {
        return this.studentEmergencyContactRepository.findById(s).orElse(null);
    }

    @Override
    public StudentEmergencyContact update(StudentEmergencyContact adminLogin) {
        return this.studentEmergencyContactRepository.save(adminLogin);
    }

    @Override
    public void delete(String s) {
        this.studentEmergencyContactRepository.deleteById(s);
    }

    @Override
    public StudentEmergencyContact retrieveById(String id) {
        List<StudentEmergencyContact> adminLogins = getAll();
        for(StudentEmergencyContact adminLogin : adminLogins) {
            if (adminLogin.getId().equalsIgnoreCase(id))
                return adminLogin;
        } return null;
    }

    @Override
    public List<StudentEmergencyContact> getAll() {
        return this.studentEmergencyContactRepository.findAll();
    }
}





