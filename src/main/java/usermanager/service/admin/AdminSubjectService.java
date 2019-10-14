package usermanager.service.admin;

import usermanager.domain.admin.AdminSubject;
import usermanager.service.IService;

import java.util.List;

public interface AdminSubjectService extends IService<AdminSubject, String> {
    AdminSubject retrieveById(String genderDesc);
    List<AdminSubject> getAll();
}
