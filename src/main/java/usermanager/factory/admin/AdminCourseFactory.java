package usermanager.factory.admin;

import usermanager.domain.admin.AdminCourse;

public class AdminCourseFactory {
    public static AdminCourse buildAdminCourse(String id, String course) {
        return new AdminCourse.Builder()
                .id(id)
                .course(course)
                .build();
    }
}
