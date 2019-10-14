package usermanager.factory.student;

import usermanager.domain.student.StudentEmergencyContact;

public class StudentEmergencyContactFactory {
    public static StudentEmergencyContact buildStudentEmergencyContact(String id, String name, String mobile) {
        return new StudentEmergencyContact.Builder()
                .id(id)
                .name(name)
                .mobile(mobile)
                .build();
    }
}

