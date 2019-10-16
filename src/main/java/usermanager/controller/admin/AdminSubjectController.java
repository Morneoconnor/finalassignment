package usermanager.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usermanager.domain.ResponseObj;
import usermanager.domain.admin.AdminSubject;
import usermanager.factory.ResponseObjFactory;
import usermanager.factory.admin.AdminSubjectFactory;
import usermanager.service.admin.AdminSubjectService;

import java.util.List;

@RestController
@RequestMapping(value = {"/", "/cputusermanager/admin/subject"})
public class AdminSubjectController {

    @Autowired
    private AdminSubjectService adminSubjectService;

    @PostMapping(value = "/create/{adminsospassword}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@PathVariable String id, String subject) {
        System.out.println("Entered Value: " + id + " - " + subject);
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Subject created!");
        AdminSubject savedSubject;
        if (subject == null || subject.trim().isEmpty() || subject.trim().equalsIgnoreCase("null")) {
            responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            responseObj.setResponseDescription("Provide login details!");
        } else {
            savedSubject = adminSubjectService.retrieveById(id);
            if (savedSubject != null) {
                responseObj.setResponseDescription("Login details already exist!");
            } else {
                savedSubject = AdminSubjectFactory.buildAdminSubject(id, subject);
                savedSubject = adminSubjectService.create(savedSubject);
            }
            responseObj.setResponse(savedSubject);
        }
        return ResponseEntity.ok(responseObj);
    }
    @PutMapping("/update/{adminlogin}")
    public void updateEmployee(@RequestBody String id, String subject){
        AdminSubject savedSubject;

        savedSubject = AdminSubjectFactory.buildAdminSubject( id, subject);
        adminSubjectService.update(savedSubject);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable("admin") String id) {
        adminSubjectService.delete(id);
    }

    @GetMapping("/read/{admin}")
    @ResponseBody
    public AdminSubject read(@PathVariable String id) {
        return adminSubjectService.read(id);
    }

    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAll(){
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Success");
        List<AdminSubject> adminPasswords = adminSubjectService.getAll();
        responseObj.setResponse(adminPasswords);
        return ResponseEntity.ok(responseObj);
    }
}

