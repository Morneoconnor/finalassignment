package usermanager.repository.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import usermanager.domain.student.StudentEmergencyContact;

@Repository
public interface StudentEmergencyContactRepository extends JpaRepository<StudentEmergencyContact, String> {
}
