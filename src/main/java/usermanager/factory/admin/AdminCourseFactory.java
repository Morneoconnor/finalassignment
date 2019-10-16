package usermanager.factory.admin;

import usermanager.domain.admin.AdminCourse;

public class AdminCourseFactory {
    public static AdminCourse buildAdminCourse(String username, String course) {
        return new AdminCourse.Builder()
                .username(username)
                .course(course)
                .build();
    }
}
