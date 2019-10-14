package usermanager.factory.admin;

import usermanager.domain.admin.AdminSubject;

public class AdminSubjectFactory {
    public static AdminSubject buildAdminSubject(String id, String subject) {
        return new AdminSubject.Builder()
                .id(id)
                .subject(subject)
                .build();
    }
}