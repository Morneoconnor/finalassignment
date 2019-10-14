package usermanager.factory.student;

import usermanager.domain.student.StudentSubject;

public class StudentSubjectFactory {
    public static StudentSubject buildStudentSubject(String id, String subject) {
        return new StudentSubject.Builder()
                .id(id)
                .subject(subject)
                .build();
    }
}