package usermanager.service.admin;

import usermanager.domain.admin.AdminPersonalDetails;
import usermanager.service.IService;

import java.util.List;

public interface AdminPersonalDetailsService extends IService<AdminPersonalDetails, String> {
    AdminPersonalDetails retrieveById(String genderDesc);
    List<AdminPersonalDetails> getAll();
}
