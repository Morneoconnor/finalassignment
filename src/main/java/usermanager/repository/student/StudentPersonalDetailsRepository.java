package usermanager.repository.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import usermanager.domain.student.StudentPersonalDetails;

@Repository
public interface StudentPersonalDetailsRepository extends JpaRepository<StudentPersonalDetails, String> {
}
