package usermanager.repository.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import usermanager.domain.admin.AdminSosPassword;

@Repository
public interface AdminSosPasswordRepository extends JpaRepository<AdminSosPassword, String> {
}
