package usermanager.service.student;

import usermanager.domain.student.StudentEmergencyContact;
import usermanager.service.IService;

import java.util.List;

public interface StudentEmergencyContactService extends IService<StudentEmergencyContact, String> {
    StudentEmergencyContact retrieveById(String id);
    List<StudentEmergencyContact> getAll();
}
