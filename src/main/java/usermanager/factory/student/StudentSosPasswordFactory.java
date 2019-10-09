package usermanager.factory.student;

import usermanager.domain.student.StudentSosPassword;

public class StudentSosPasswordFactory {
    public static StudentSosPassword buildStudentSosPassword(String id, String username, String password) {
        return new StudentSosPassword.Builder()
                .id(id)
                .username(username)
                .password(password)
                .build();
    }
}
