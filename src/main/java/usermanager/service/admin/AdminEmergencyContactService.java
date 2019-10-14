package usermanager.service.admin;

import usermanager.domain.admin.AdminEmergencyContact;
import usermanager.service.IService;

import java.util.List;

public interface AdminEmergencyContactService extends IService<AdminEmergencyContact, String> {
    AdminEmergencyContact retrieveById(String id);
    List<AdminEmergencyContact> getAll();
}