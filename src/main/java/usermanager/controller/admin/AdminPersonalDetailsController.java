package usermanager.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usermanager.domain.ResponseObj;
import usermanager.domain.admin.AdminPersonalDetails;
import usermanager.factory.ResponseObjFactory;
import usermanager.factory.admin.AdminPersonalDetailsFactory;
import usermanager.service.admin.AdminPersonalDetailsService;

import java.util.List;

@RestController
@RequestMapping(value = {"/", "/cputusermanager/admin/adminpersonaldetails"})
public class AdminPersonalDetailsController {

    @Autowired
    private AdminPersonalDetailsService adminPersonalDetailsService;

    @PostMapping(value = "/create/{adminsospassword}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@PathVariable String id, String name, String lastname, String email, String mobile) {
        System.out.println("Entered Value: " + id + " - " + name + " - " + lastname);
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Gender created!");
        AdminPersonalDetails savedPersonalDetails;
        if (name == null || name.trim().isEmpty() || name.trim().equalsIgnoreCase("null")) {
            responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            responseObj.setResponseDescription("Provide login details!");
        } else {
            savedPersonalDetails = adminPersonalDetailsService.retrieveById(id);
            if (savedPersonalDetails != null) {
                responseObj.setResponseDescription("Login details already exist!");
            } else {
                savedPersonalDetails = AdminPersonalDetailsFactory.buildAdminPersonalDetails(id, name, lastname, email, mobile);
                savedPersonalDetails = adminPersonalDetailsService.create(savedPersonalDetails);
            }
            responseObj.setResponse(savedPersonalDetails);
        }
        return ResponseEntity.ok(responseObj);
    }
    @PutMapping("/update/{adminlogin}")
    public void updateEmployee(@RequestBody String id, String name, String lastname, String email, String mobile){
        AdminPersonalDetails savedAdminPersonalDetails;

        savedAdminPersonalDetails = AdminPersonalDetailsFactory.buildAdminPersonalDetails( id, name, lastname, email, mobile);
        adminPersonalDetailsService.update(savedAdminPersonalDetails);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        adminPersonalDetailsService.delete(id);
    }

    @GetMapping("/read/{admin}")
    @ResponseBody
    public AdminPersonalDetails read(@PathVariable String id) {
        return adminPersonalDetailsService.read(id);
    }

    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAll(){
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Success");
        List<AdminPersonalDetails> adminPasswords = adminPersonalDetailsService.getAll();
        responseObj.setResponse(adminPasswords);
        return ResponseEntity.ok(responseObj);
    }
}

