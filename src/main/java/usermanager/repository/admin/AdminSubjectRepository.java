package usermanager.repository.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import usermanager.domain.admin.AdminSubject;

@Repository
public interface AdminSubjectRepository extends JpaRepository<AdminSubject, String> {
}