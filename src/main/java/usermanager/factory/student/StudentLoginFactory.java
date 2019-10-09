package usermanager.factory.student;

import usermanager.domain.student.StudentLogin;

public class StudentLoginFactory {
    public static StudentLogin buildStudentLogin(String id, String username, String password) {
        return new StudentLogin.Builder()
                .id(id)
                .username(username)
                .password(password)
                .build();
    }
}
