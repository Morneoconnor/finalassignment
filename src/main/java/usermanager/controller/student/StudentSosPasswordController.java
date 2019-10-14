package usermanager.controller.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usermanager.domain.ResponseObj;
import usermanager.domain.student.StudentSosPassword;
import usermanager.factory.ResponseObjFactory;
import usermanager.factory.student.StudentSosPasswordFactory;
import usermanager.service.student.StudentSosPasswordService;

import java.util.List;

@RestController
@RequestMapping("/cputusermanager/student/sospassword")
public class StudentSosPasswordController {

    @Autowired
    private StudentSosPasswordService studentSosPasswordService;

    @PostMapping(value = "/create/{studentsospassword}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createGender(@PathVariable String id, String username, String password) {
        System.out.println("Entered Value: " + id + " - " + username + " - " + password);
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Gender created!");
        StudentSosPassword savedStudentSosPassword;
        if (username == null || username.trim().isEmpty() || username.trim().equalsIgnoreCase("null")) {
            responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            responseObj.setResponseDescription("Provide login details!");
        } else {
            savedStudentSosPassword = studentSosPasswordService.retrieveById(id);
            if (savedStudentSosPassword != null) {
                responseObj.setResponseDescription("Login details already exist!");
            } else {
                savedStudentSosPassword = StudentSosPasswordFactory.buildStudentSosPassword(id, username, password);
                savedStudentSosPassword = studentSosPasswordService.create(savedStudentSosPassword);
            }
            responseObj.setResponse(savedStudentSosPassword);
        }
        return ResponseEntity.ok(responseObj);
    }

    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAll(){
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Success");
        List<StudentSosPassword> studentLogins = studentSosPasswordService.getAll();
        responseObj.setResponse(studentLogins);
        return ResponseEntity.ok(responseObj);
    }
}

