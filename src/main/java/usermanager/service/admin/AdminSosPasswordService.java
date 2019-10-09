package usermanager.service.admin;

import usermanager.domain.admin.AdminSosPassword;
import usermanager.service.IService;

import java.util.List;

public interface AdminSosPasswordService extends IService<AdminSosPassword, String> {
    AdminSosPassword retrieveById(String genderDesc);
    List<AdminSosPassword> getAll();
}