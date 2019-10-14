package usermanager.repository.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import usermanager.domain.admin.AdminPersonalDetails;

@Repository
public interface AdminPersonalDetailsRepository extends JpaRepository<AdminPersonalDetails, String> {
}