package usermanager.controller.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usermanager.domain.ResponseObj;
import usermanager.domain.student.StudentEmergencyContact;
import usermanager.factory.ResponseObjFactory;
import usermanager.factory.student.StudentEmergencyContactFactory;
import usermanager.service.student.StudentEmergencyContactService;

import java.util.List;

@RestController
@RequestMapping(value = {"/", "/cputusermanager/admin/emergencycontact"})
public class StudentEmergencyContactController {
    @Autowired
    private StudentEmergencyContactService studentEmergencyContactService;

    @PostMapping(value = "/create/{adminemergencycontactservice}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@PathVariable String id, String name, String mobile) {
        System.out.println("Entered Value: " + id + " - " + name);
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Contact created!");
        StudentEmergencyContact savedEmergencyContact;
        if (name == null || name.trim().isEmpty() || name.trim().equalsIgnoreCase("null")) {
            responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            responseObj.setResponseDescription("Provide login details!");
        } else {
            savedEmergencyContact = studentEmergencyContactService.retrieveById(id);
            if (savedEmergencyContact != null) {
                responseObj.setResponseDescription("Login details already exist!");
            } else {
                savedEmergencyContact = StudentEmergencyContactFactory.buildStudentEmergencyContact(id, name, mobile);
                savedEmergencyContact = studentEmergencyContactService.create(savedEmergencyContact);
            }
            responseObj.setResponse(savedEmergencyContact);
        }
        return ResponseEntity.ok(responseObj);
    }
    @PutMapping("/update/{id}")
    public void updateEmployee(@RequestBody String id, String name, String mobile){
        StudentEmergencyContact savedEmergencyContact;

        savedEmergencyContact = StudentEmergencyContactFactory.buildStudentEmergencyContact(id, name, mobile);
        studentEmergencyContactService.update(savedEmergencyContact);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        studentEmergencyContactService.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public StudentEmergencyContact read(@PathVariable String id) {
        return studentEmergencyContactService.read(id);
    }

    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity getAll(){
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Success");
        List<StudentEmergencyContact> adminLogins = studentEmergencyContactService.getAll();
        responseObj.setResponse(adminLogins);
        return ResponseEntity.ok(responseObj);
    }
}
