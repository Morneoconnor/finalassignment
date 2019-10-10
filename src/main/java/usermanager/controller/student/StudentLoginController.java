package usermanager.controller.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usermanager.domain.ResponseObj;
import usermanager.domain.student.StudentLogin;
import usermanager.factory.ResponseObjFactory;
import usermanager.factory.student.StudentLoginFactory;
import usermanager.service.student.StudentLoginService;

import java.util.List;

@RestController
@RequestMapping("/cputusermanager/student/studentlogin")
public class StudentLoginController {

    @Autowired
    private StudentLoginService studentLoginService;

    @PostMapping(value = "/create/{adminlogin}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createGender(@PathVariable String id, String username, String password) {
        System.out.println("Entered Value: " + id + " - " + username + " - " + password);
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Gender created!");
        StudentLogin savedStudentLogin;
        if (username == null || username.trim().isEmpty() || username.trim().equalsIgnoreCase("null")) {
            responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            responseObj.setResponseDescription("Provide login details!");
        } else {
            savedStudentLogin = studentLoginService.retrieveById(id);
            if (savedStudentLogin != null) {
                responseObj.setResponseDescription("Login details already exist!");
            } else {
                savedStudentLogin = StudentLoginFactory.buildStudentLogin(id, username, password);
                savedStudentLogin = studentLoginService.create(savedStudentLogin);
            }
            responseObj.setResponse(savedStudentLogin);
        }
        return ResponseEntity.ok(responseObj);
    }

    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAll(){
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Success");
        List<StudentLogin> studentLogins = studentLoginService.getAll();
        responseObj.setResponse(studentLogins);
        return ResponseEntity.ok(responseObj);
    }
}

