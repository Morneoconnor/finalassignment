package usermanager.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usermanager.domain.ResponseObj;
import usermanager.domain.admin.AdminSosPassword;
import usermanager.factory.ResponseObjFactory;
import usermanager.factory.admin.AdminSosPasswordFactory;
import usermanager.service.admin.AdminSosPasswordService;

import java.util.List;

@RestController
@RequestMapping("/cputusermanager/admin/adminsospassword")
public class AdminSosPasswordController {

    @Autowired
    private AdminSosPasswordService adminSosPasswordService;

    @PostMapping(value = "/create/{adminsospassword}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createGender(@PathVariable String id, String username, String password) {
        System.out.println("Entered Value: " + id + " - " + username + " - " + password);
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Gender created!");
        AdminSosPassword savedAdminSosPassword;
        if (username == null || username.trim().isEmpty() || username.trim().equalsIgnoreCase("null")) {
            responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            responseObj.setResponseDescription("Provide login details!");
        } else {
            savedAdminSosPassword = adminSosPasswordService.retrieveById(id);
            if (savedAdminSosPassword != null) {
                responseObj.setResponseDescription("Login details already exist!");
            } else {
                savedAdminSosPassword = AdminSosPasswordFactory.buildAdminSosPassword(id, username, password);
                savedAdminSosPassword = adminSosPasswordService.create(savedAdminSosPassword);
            }
            responseObj.setResponse(savedAdminSosPassword);
        }
        return ResponseEntity.ok(responseObj);
    }

    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAll(){
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Success");
        List<AdminSosPassword> adminPasswords = adminSosPasswordService.getAll();
        responseObj.setResponse(adminPasswords);
        return ResponseEntity.ok(responseObj);
    }
}
