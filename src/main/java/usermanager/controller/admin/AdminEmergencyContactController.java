package usermanager.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usermanager.domain.ResponseObj;
import usermanager.domain.admin.AdminEmergencyContact;
import usermanager.factory.ResponseObjFactory;
import usermanager.factory.admin.AdminEmergencyContactFactory;
import usermanager.service.admin.AdminEmergencyContactService;

import java.util.List;

@RestController
@RequestMapping(value = {"/", "/cputusermanager/admin/emergencycontactservice"})
public class AdminEmergencyContactController {
    @Autowired
    private AdminEmergencyContactService adminEmergencyContactService;

    @PostMapping(value = "/create/{adminemergencycontactservice}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@PathVariable String id, String name, String mobile) {
        System.out.println("Entered Value: " + id + " - " + name);
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Contact created!");
        AdminEmergencyContact savedEmergencyContact;
        if (name == null || name.trim().isEmpty() || name.trim().equalsIgnoreCase("null")) {
            responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            responseObj.setResponseDescription("Provide login details!");
        } else {
            savedEmergencyContact = adminEmergencyContactService.retrieveById(id);
            if (savedEmergencyContact != null) {
                responseObj.setResponseDescription("Login details already exist!");
            } else {
                savedEmergencyContact = AdminEmergencyContactFactory.buildAdminEmergencyContact(id, name, mobile);
                savedEmergencyContact = adminEmergencyContactService.create(savedEmergencyContact);
            }
            responseObj.setResponse(savedEmergencyContact);
        }
        return ResponseEntity.ok(responseObj);
    }
    @PutMapping("/update/{id}")
    public void updateEmployee(@RequestBody String id, String name, String mobile){
        AdminEmergencyContact savedEmergencyContact;

        savedEmergencyContact = AdminEmergencyContactFactory.buildAdminEmergencyContact( id, name, mobile);
        adminEmergencyContactService.update(savedEmergencyContact);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        adminEmergencyContactService.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public AdminEmergencyContact read(@PathVariable String id) {
        return adminEmergencyContactService.read(id);
    }

    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity getAll(){
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Success");
        List<AdminEmergencyContact> adminLogins = adminEmergencyContactService.getAll();
        responseObj.setResponse(adminLogins);
        return ResponseEntity.ok(responseObj);
    }
}