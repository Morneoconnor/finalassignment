package usermanager.service.student;

import usermanager.domain.student.StudentPersonalDetails;
import usermanager.service.IService;

import java.util.List;

public interface StudentPersonalDetailsService extends IService<StudentPersonalDetails, String> {
    StudentPersonalDetails retrieveById(String id);
    List<StudentPersonalDetails> getAll();
}
