package usermanager.service.admin;

import usermanager.domain.admin.AdminCourse;
import usermanager.service.IService;

import java.util.List;

public interface AdminCourseService extends IService<AdminCourse, String> {
    AdminCourse retrieveById(String id);
    List<AdminCourse> getAll();
}
