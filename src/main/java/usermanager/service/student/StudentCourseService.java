package usermanager.service.student;

import usermanager.domain.student.StudentCourse;
import usermanager.service.IService;

import java.util.List;

public interface StudentCourseService extends IService<StudentCourse, String> {
    StudentCourse retrieveById(String id);
    List<StudentCourse> getAll();
}