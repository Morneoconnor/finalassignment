package usermanager.service.student;

import usermanager.domain.student.StudentLogin;
import usermanager.service.IService;

import java.util.List;

public interface StudentLoginService extends IService<StudentLogin, String> {
    StudentLogin retrieveById(String genderDesc);
    List<StudentLogin> getAll();
}

