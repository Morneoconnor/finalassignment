package usermanager.factory.admin;

import usermanager.domain.admin.AdminPersonalDetails;

public class AdminPersonalDetailsFactory {
    public static AdminPersonalDetails buildAdminPersonalDetails(String id, String name, String lastname, String email,String mobile) {
        return new AdminPersonalDetails.Builder()
                .id(id)
                .name(name)
                .lastname(lastname)
                .email(email)
                .mobile(mobile)
                .build();
    }
}