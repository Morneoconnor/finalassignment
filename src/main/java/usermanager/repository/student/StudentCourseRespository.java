package usermanager.repository.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import usermanager.domain.student.StudentCourse;

@Repository
public interface StudentCourseRespository extends JpaRepository<StudentCourse, String> {
}
