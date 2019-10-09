package usermanager.service.student;

import usermanager.domain.student.StudentSosPassword;
import usermanager.service.IService;

import java.util.List;

public interface StudentSosPasswordService extends IService<StudentSosPassword, String> {
    StudentSosPassword retrieveById(String genderDesc);
    List<StudentSosPassword> getAll();
}