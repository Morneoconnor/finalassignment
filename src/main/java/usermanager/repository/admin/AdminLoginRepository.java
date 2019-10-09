package usermanager.repository.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import usermanager.domain.admin.AdminLogin;

@Repository
public interface AdminLoginRepository extends JpaRepository<AdminLogin, String> {
}
