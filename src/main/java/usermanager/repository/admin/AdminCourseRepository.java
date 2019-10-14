package usermanager.repository.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import usermanager.domain.admin.AdminCourse;

@Repository
public interface AdminCourseRepository extends JpaRepository<AdminCourse, String> {
}