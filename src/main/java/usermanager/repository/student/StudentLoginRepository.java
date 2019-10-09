package usermanager.repository.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import usermanager.domain.student.StudentLogin;

@Repository
public interface StudentLoginRepository extends JpaRepository<StudentLogin, String> {
}
