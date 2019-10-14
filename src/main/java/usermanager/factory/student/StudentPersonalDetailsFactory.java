package usermanager.factory.student;

import usermanager.domain.student.StudentPersonalDetails;

public class StudentPersonalDetailsFactory {
    public static StudentPersonalDetails buildStudentPersonalDetails(String id, String name, String lastname, String email,String mobile) {
        return new StudentPersonalDetails.Builder()
                .id(id)
                .name(name)
                .lastname(lastname)
                .email(email)
                .mobile(mobile)
                .build();
    }
}
