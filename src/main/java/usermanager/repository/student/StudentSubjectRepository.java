package usermanager.repository.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import usermanager.domain.student.StudentSubject;

@Repository
public interface StudentSubjectRepository extends JpaRepository<StudentSubject, String> {
}
