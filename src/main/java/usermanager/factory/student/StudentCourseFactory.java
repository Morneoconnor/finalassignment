package usermanager.factory.student;

import usermanager.domain.student.StudentCourse;

public class StudentCourseFactory {
    public static StudentCourse buildStudentCourse(String id, String course) {
        return new StudentCourse.Builder()
                .id(id)
                .course(course)
                .build();
    }
}