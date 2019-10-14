package usermanager.service.student;

import usermanager.domain.student.StudentSubject;
import usermanager.service.IService;

import java.util.List;

public interface StudentSubjectService extends IService<StudentSubject, String> {
    StudentSubject retrieveById(String genderDesc);
    List<StudentSubject> getAll();
}
