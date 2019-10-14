package usermanager.repository.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import usermanager.domain.admin.AdminEmergencyContact;

@Repository
public interface AdminEmergencyContactRepository extends JpaRepository<AdminEmergencyContact, String> {
}