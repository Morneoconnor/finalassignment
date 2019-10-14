package usermanager.factory.admin;


import usermanager.domain.admin.AdminEmergencyContact;

public class AdminEmergencyContactFactory {
    public static AdminEmergencyContact buildAdminEmergencyContact(String id, String name, String mobile) {
        return new AdminEmergencyContact.Builder()
                .id(id)
                .name(name)
                .mobile(mobile)
                .build();
    }
}
