package usermanager.repository.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import usermanager.domain.student.StudentSosPassword;

@Repository
public interface StudentSosPasswordRepository extends JpaRepository<StudentSosPassword, String> {
}
